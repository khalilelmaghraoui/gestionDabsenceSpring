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
public class Compte {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idCompte;

    private int enabled;
    private int accountNotExpired;
    private int accountNotLocked;
    private int login;
    private int password;
    private boolean disconnectAccount;
    private boolean accepteDemandeAutorisationAbsence;
    private boolean affichePhoto;
    private boolean afficheEmail;

    @ManyToOne
    @JoinColumn(name="role_id")
    public Role role;

    @OneToMany(mappedBy="compte", cascade=CascadeType.ALL)
    public Collection<Notification> notifications;

    @OneToMany(mappedBy="compte", cascade=CascadeType.ALL)
    public Collection<Message> messagesEnvoyes;

    @OneToMany(mappedBy="compte", cascade=CascadeType.ALL)
    public Collection<Message> messagesReçus;


    @ManyToMany
    @JoinTable(
	   		name="Compte_Conversation",
				joinColumns=@JoinColumn(name="idCompte"),
				inverseJoinColumns=@JoinColumn(name="idConversation"))
    public Collection<Conversation> conversationsCrees;


    @OneToMany(mappedBy="compte", cascade=CascadeType.ALL)
    public Collection<JournalisationEvenements> evenements;

    @ManyToOne
    @JoinColumn(name="idUtilisateur")
    public Utilisateur proprietaire;

    @OneToMany(mappedBy="compte", cascade=CascadeType.ALL)
    public Collection<Conversation> conversationReçues;


   /** @pdGenerated default parent getter */
   public Role getRole() {
      return role;
   }

   /** @pdGenerated default parent setter
     * @param newRole */
   public void setRole(Role newRole) {
      if (this.role == null || !this.role.equals(newRole))
      {
         if (this.role != null)
         {
            Role oldRole = this.role;
            this.role = null;
            oldRole.removeComptes(this);
         }
         if (newRole != null)
         {
            this.role = newRole;
            this.role.addComptes(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<Notification> getNotifications() {
      if (notifications == null)
         notifications = new HashSet<Notification>();
      return notifications;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorNotifications() {
      if (notifications == null)
         notifications = new HashSet<Notification>();
      return notifications.iterator();
   }

   /** @pdGenerated default setter
     * @param newNotifications */
   public void setNotifications(Collection<Notification> newNotifications) {
      removeAllNotifications();
      for (Iterator iter = newNotifications.iterator(); iter.hasNext();)
         addNotifications((Notification)iter.next());
   }

   /** @pdGenerated default add
     * @param newNotification */
   public void addNotifications(Notification newNotification) {
      if (newNotification == null)
         return;
      if (this.notifications == null)
         this.notifications = new HashSet<Notification>();
      if (!this.notifications.contains(newNotification))
      {
         this.notifications.add(newNotification);
         newNotification.setCompte(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldNotification */
   public void removeNotifications(Notification oldNotification) {
      if (oldNotification == null)
         return;
      if (this.notifications != null)
         if (this.notifications.contains(oldNotification))
         {
            this.notifications.remove(oldNotification);
            oldNotification.setCompte((Compte)null);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllNotifications() {
      if (notifications != null)
      {
         Notification oldNotification;
         for (Iterator iter = getIteratorNotifications(); iter.hasNext();)
         {
            oldNotification = (Notification)iter.next();
            iter.remove();
            oldNotification.setCompte((Compte)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<Message> getMessagesEnvoyes() {
      if (messagesEnvoyes == null)
         messagesEnvoyes = new HashSet<Message>();
      return messagesEnvoyes;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorMessagesEnvoyes() {
      if (messagesEnvoyes == null)
         messagesEnvoyes = new HashSet<Message>();
      return messagesEnvoyes.iterator();
   }

   /** @pdGenerated default setter
     * @param newMessagesEnvoyes */
   public void setMessagesEnvoyes(Collection<Message> newMessagesEnvoyes) {
      removeAllMessagesEnvoyes();
      for (Iterator iter = newMessagesEnvoyes.iterator(); iter.hasNext();)
         addMessagesEnvoyes((Message)iter.next());
   }

   /** @pdGenerated default add
     * @param newMessage */
   public void addMessagesEnvoyes(Message newMessage) {
      if (newMessage == null)
         return;
      if (this.messagesEnvoyes == null)
         this.messagesEnvoyes = new HashSet<Message>();
      if (!this.messagesEnvoyes.contains(newMessage))
      {
         this.messagesEnvoyes.add(newMessage);
         newMessage.setExpediteur(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldMessage */
   public void removeMessagesEnvoyes(Message oldMessage) {
      if (oldMessage == null)
         return;
      if (this.messagesEnvoyes != null)
         if (this.messagesEnvoyes.contains(oldMessage))
         {
            this.messagesEnvoyes.remove(oldMessage);
            oldMessage.setExpediteur((Compte)null);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllMessagesEnvoyes() {
      if (messagesEnvoyes != null)
      {
         Message oldMessage;
         for (Iterator iter = getIteratorMessagesEnvoyes(); iter.hasNext();)
         {
            oldMessage = (Message)iter.next();
            iter.remove();
            oldMessage.setExpediteur((Compte)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<Message> getMessagesReçus() {
      if (messagesReçus == null)
         messagesReçus = new HashSet<Message>();
      return messagesReçus;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorMessagesReçus() {
      if (messagesReçus == null)
         messagesReçus = new HashSet<Message>();
      return messagesReçus.iterator();
   }

   /** @pdGenerated default setter
     * @param newMessagesReçus */
   public void setMessagesReçus(Collection<Message> newMessagesReçus) {
      removeAllMessagesReçus();
      for (Iterator iter = newMessagesReçus.iterator(); iter.hasNext();)
         addMessagesReçus((Message)iter.next());
   }

   /** @pdGenerated default add
     * @param newMessage */
   public void addMessagesReçus(Message newMessage) {
      if (newMessage == null)
         return;
      if (this.messagesReçus == null)
         this.messagesReçus = new HashSet<Message>();
      if (!this.messagesReçus.contains(newMessage))
      {
         this.messagesReçus.add(newMessage);
         newMessage.setDestinataire(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldMessage */
   public void removeMessagesReçus(Message oldMessage) {
      if (oldMessage == null)
         return;
      if (this.messagesReçus != null)
         if (this.messagesReçus.contains(oldMessage))
         {
            this.messagesReçus.remove(oldMessage);
            oldMessage.setDestinataire((Compte)null);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllMessagesReçus() {
      if (messagesReçus != null)
      {
         Message oldMessage;
         for (Iterator iter = getIteratorMessagesReçus(); iter.hasNext();)
         {
            oldMessage = (Message)iter.next();
            iter.remove();
            oldMessage.setDestinataire((Compte)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<Conversation> getConversationsCrees() {
      if (conversationsCrees == null)
         conversationsCrees = new HashSet<Conversation>();
      return conversationsCrees;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorConversationsCrees() {
      if (conversationsCrees == null)
         conversationsCrees = new HashSet<Conversation>();
      return conversationsCrees.iterator();
   }

   /** @pdGenerated default setter
     * @param newConversationsCrees */
   public void setConversationsCrees(Collection<Conversation> newConversationsCrees) {
      removeAllConversationsCrees();
      for (Iterator iter = newConversationsCrees.iterator(); iter.hasNext();)
         addConversationsCrees((Conversation)iter.next());
   }

   /** @pdGenerated default add
     * @param newConversation */
   public void addConversationsCrees(Conversation newConversation) {
      if (newConversation == null)
         return;
      if (this.conversationsCrees == null)
         this.conversationsCrees = new HashSet<Conversation>();
      if (!this.conversationsCrees.contains(newConversation))
      {
         this.conversationsCrees.add(newConversation);
         newConversation.setCreateurConversation(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldConversation */
   public void removeConversationsCrees(Conversation oldConversation) {
      if (oldConversation == null)
         return;
      if (this.conversationsCrees != null)
         if (this.conversationsCrees.contains(oldConversation))
         {
            this.conversationsCrees.remove(oldConversation);
            oldConversation.setCreateurConversation((Compte)null);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllConversationsCrees() {
      if (conversationsCrees != null)
      {
         Conversation oldConversation;
         for (Iterator iter = getIteratorConversationsCrees(); iter.hasNext();)
         {
            oldConversation = (Conversation)iter.next();
            iter.remove();
            oldConversation.setCreateurConversation((Compte)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<JournalisationEvenements> getEvenements() {
      if (evenements == null)
         evenements = new HashSet<JournalisationEvenements>();
      return evenements;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorEvenements() {
      if (evenements == null)
         evenements = new HashSet<JournalisationEvenements>();
      return evenements.iterator();
   }

   /** @pdGenerated default setter
     * @param newEvenements */
   public void setEvenements(Collection<JournalisationEvenements> newEvenements) {
      removeAllEvenements();
      for (Iterator iter = newEvenements.iterator(); iter.hasNext();)
         addEvenements((JournalisationEvenements)iter.next());
   }

   /** @pdGenerated default add
     * @param newJournalisationEvenements */
   public void addEvenements(JournalisationEvenements newJournalisationEvenements) {
      if (newJournalisationEvenements == null)
         return;
      if (this.evenements == null)
         this.evenements = new HashSet<JournalisationEvenements>();
      if (!this.evenements.contains(newJournalisationEvenements))
      {
         this.evenements.add(newJournalisationEvenements);
         newJournalisationEvenements.setCompte(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldJournalisationEvenements */
   public void removeEvenements(JournalisationEvenements oldJournalisationEvenements) {
      if (oldJournalisationEvenements == null)
         return;
      if (this.evenements != null)
         if (this.evenements.contains(oldJournalisationEvenements))
         {
            this.evenements.remove(oldJournalisationEvenements);
            oldJournalisationEvenements.setCompte((Compte)null);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllEvenements() {
      if (evenements != null)
      {
         JournalisationEvenements oldJournalisationEvenements;
         for (Iterator iter = getIteratorEvenements(); iter.hasNext();)
         {
            oldJournalisationEvenements = (JournalisationEvenements)iter.next();
            iter.remove();
            oldJournalisationEvenements.setCompte((Compte)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Utilisateur getProprietaire() {
      return proprietaire;
   }

   /** @pdGenerated default parent setter
     * @param newUtilisateur */
   public void setProprietaire(Utilisateur newUtilisateur) {
      if (this.proprietaire == null || !this.proprietaire.equals(newUtilisateur))
      {
         if (this.proprietaire != null)
         {
            Utilisateur oldUtilisateur = this.proprietaire;
            this.proprietaire = null;
            oldUtilisateur.removeComptes(this);
         }
         if (newUtilisateur != null)
         {
            this.proprietaire = newUtilisateur;
            this.proprietaire.addComptes(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<Conversation> getConversationReçues() {
      if (conversationReçues == null)
         conversationReçues = new HashSet<Conversation>();
      return conversationReçues;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorConversationReçues() {
      if (conversationReçues == null)
         conversationReçues = new HashSet<Conversation>();
      return conversationReçues.iterator();
   }

   /** @pdGenerated default setter
     * @param newConversationReçues */
   public void setConversationReçues(Collection<Conversation> newConversationReçues) {
      removeAllConversationReçues();
      for (Iterator iter = newConversationReçues.iterator(); iter.hasNext();)
         addConversationReçues((Conversation)iter.next());
   }

   /** @pdGenerated default add
     * @param newConversation */
   public void addConversationReçues(Conversation newConversation) {
      if (newConversation == null)
         return;
      if (this.conversationReçues == null)
         this.conversationReçues = new HashSet<Conversation>();
      if (!this.conversationReçues.contains(newConversation))
      {
         this.conversationReçues.add(newConversation);
         newConversation.addParticipant(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldConversation */
   public void removeConversationReçues(Conversation oldConversation) {
      if (oldConversation == null)
         return;
      if (this.conversationReçues != null)
         if (this.conversationReçues.contains(oldConversation))
         {
            this.conversationReçues.remove(oldConversation);
            oldConversation.removeParticipant(this);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllConversationReçues() {
      if (conversationReçues != null)
      {
         Conversation oldConversation;
         for (Iterator iter = getIteratorConversationReçues(); iter.hasNext();)
         {
            oldConversation = (Conversation)iter.next();
            iter.remove();
            oldConversation.removeParticipant(this);
         }
      }
   }

}
