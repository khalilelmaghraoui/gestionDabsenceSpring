package com.ensah.core.bo;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Message {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int idMessage;

   private String texte;

   private Date dateHeure;

   @ManyToOne
   @JoinColumn(name="idConversation")
   public Conversation conversation;

   @ManyToOne
   @JoinColumn(name="idCompte")
   public Compte expediteur;

   @ManyToOne
   @JoinColumn(name="Com_idCompte")
   public Compte destinataire;


   public Conversation getConversation() {
      return conversation;
   }

   /** @pdGenerated default parent setter
     * @param newConversation */
   public void setConversation(Conversation newConversation) {
      if (this.conversation == null || !this.conversation.equals(newConversation))
      {
         if (this.conversation != null)
         {
            Conversation oldConversation = this.conversation;
            this.conversation = null;
            oldConversation.removeMessages(this);
         }
         if (newConversation != null)
         {
            this.conversation = newConversation;
            this.conversation.addMessages(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Compte getExpediteur() {
      return expediteur;
   }

   /** @pdGenerated default parent setter
     * @param newCompte */
   public void setExpediteur(Compte newCompte) {
      if (this.expediteur == null || !this.expediteur.equals(newCompte))
      {
         if (this.expediteur != null)
         {
            Compte oldCompte = this.expediteur;
            this.expediteur = null;
            oldCompte.removeMessagesEnvoyes(this);
         }
         if (newCompte != null)
         {
            this.expediteur = newCompte;
            this.expediteur.addMessagesEnvoyes(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Compte getDestinataire() {
      return destinataire;
   }

   /** @pdGenerated default parent setter
     * @param newCompte */
   public void setDestinataire(Compte newCompte) {
      if (this.destinataire == null || !this.destinataire.equals(newCompte))
      {
         if (this.destinataire != null)
         {
            Compte oldCompte = this.destinataire;
            this.destinataire = null;
            oldCompte.removeMessagesReçus(this);
         }
         if (newCompte != null)
         {
            this.destinataire = newCompte;
            this.destinataire.addMessagesReçus(this);
         }
      }
   }

}
