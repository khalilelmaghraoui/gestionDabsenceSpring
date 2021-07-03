package com.ensah.core.bo;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Conversation {

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int idConversation;

   private String type;

   private String titre;

   private int etat;


   @ManyToMany(cascade=CascadeType.ALL)
   @JoinTable(
		   		name="Compte_Conversation",
   				joinColumns=@JoinColumn(name="idConversation"),
   				inverseJoinColumns=@JoinColumn(name="idCompte"))
   public Collection<Compte> participant;

   @OneToMany(mappedBy="conversation", cascade=CascadeType.ALL)
   public Collection<Message> messages;

   @ManyToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="createurConversation")
   public Compte createurConversation;


   /** @pdGenerated default getter */
   public Collection<Compte> getParticipant() {
      if (participant == null)
         participant = new HashSet<Compte>();
      return participant;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorParticipant() {
      if (participant == null)
         participant = new HashSet<Compte>();
      return participant.iterator();
   }

   /** @pdGenerated default setter
     * @param newParticipant */
   public void setParticipant(Collection<Compte> newParticipant) {
      removeAllParticipant();
      for (Iterator iter = newParticipant.iterator(); iter.hasNext();)
         addParticipant((Compte)iter.next());
   }

   /** @pdGenerated default add
     * @param newCompte */
   public void addParticipant(Compte newCompte) {
      if (newCompte == null)
         return;
      if (this.participant == null)
         this.participant = new HashSet<Compte>();
      if (!this.participant.contains(newCompte))
      {
         this.participant.add(newCompte);
         newCompte.addConversationReçues(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldCompte */
   public void removeParticipant(Compte oldCompte) {
      if (oldCompte == null)
         return;
      if (this.participant != null)
         if (this.participant.contains(oldCompte))
         {
            this.participant.remove(oldCompte);
            oldCompte.removeConversationReçues(this);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllParticipant() {
      if (participant != null)
      {
         Compte oldCompte;
         for (Iterator iter = getIteratorParticipant(); iter.hasNext();)
         {
            oldCompte = (Compte)iter.next();
            iter.remove();
            oldCompte.removeConversationReçues(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<Message> getMessages() {
      if (messages == null)
         messages = new HashSet<Message>();
      return messages;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorMessages() {
      if (messages == null)
         messages = new HashSet<Message>();
      return messages.iterator();
   }

   /** @pdGenerated default setter
     * @param newMessages */
   public void setMessages(Collection<Message> newMessages) {
      removeAllMessages();
      for (Iterator iter = newMessages.iterator(); iter.hasNext();)
         addMessages((Message)iter.next());
   }

   /** @pdGenerated default add
     * @param newMessage */
   public void addMessages(Message newMessage) {
      if (newMessage == null)
         return;
      if (this.messages == null)
         this.messages = new HashSet<Message>();
      if (!this.messages.contains(newMessage))
      {
         this.messages.add(newMessage);
         newMessage.setConversation(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldMessage */
   public void removeMessages(Message oldMessage) {
      if (oldMessage == null)
         return;
      if (this.messages != null)
         if (this.messages.contains(oldMessage))
         {
            this.messages.remove(oldMessage);
            oldMessage.setConversation((Conversation)null);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllMessages() {
      if (messages != null)
      {
         Message oldMessage;
         for (Iterator iter = getIteratorMessages(); iter.hasNext();)
         {
            oldMessage = (Message)iter.next();
            iter.remove();
            oldMessage.setConversation((Conversation)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Compte getCreateurConversation() {
      return createurConversation;
   }

   /** @pdGenerated default parent setter
     * @param newCompte */
   public void setCreateurConversation(Compte newCompte) {
      if (this.createurConversation == null || !this.createurConversation.equals(newCompte))
      {
         if (this.createurConversation != null)
         {
            Compte oldCompte = this.createurConversation;
            this.createurConversation = null;
            oldCompte.removeConversationsCrees(this);
         }
         if (newCompte != null)
         {
            this.createurConversation = newCompte;
            this.createurConversation.addConversationsCrees(this);
         }
      }
   }

}
