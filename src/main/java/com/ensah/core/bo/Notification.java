package com.ensah.core.bo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notification {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int idNotification;

   private String type;

   private String titre;

   private String texte;

   private Date dateCreation;

   private int etat;

   /** @pdRoleInfo migr=no name=Compte assc=Association_10 coll=java.util.Collection impl=java.util.HashSet mult=1..1 side=A */
   @ManyToOne
   @JoinColumn(name="compte_id")
   public Compte compte;


   /** @pdGenerated default parent getter */
   public Compte getCompte() {
      return compte;
   }

   /** @pdGenerated default parent setter
     * @param newCompte */
   public void setCompte(Compte newCompte) {
      if (this.compte == null || !this.compte.equals(newCompte))
      {
         if (this.compte != null)
         {
            Compte oldCompte = this.compte;
            this.compte = null;
            oldCompte.removeNotifications(this);
         }
         if (newCompte != null)
         {
            this.compte = newCompte;
            this.compte.addNotifications(this);
         }
      }
   }

}
