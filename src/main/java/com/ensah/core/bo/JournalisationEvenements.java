package com.ensah.core.bo;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JournalisationEvenements {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEvenement;
    private String details;
    private String adresseIP;
    private Date DateHeure;
    private String typeEvenement;
    private String criticite;

   /** @pdRoleInfo migr=no name=Compte assc=Association_19 coll=java.util.Collection impl=java.util.HashSet mult=1..1 side=A */
    @ManyToOne
    @JoinColumn(name="idCompte")
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
            oldCompte.removeEvenements(this);
         }
         if (newCompte != null)
         {
            this.compte = newCompte;
            this.compte.addEvenements(this);
         }
      }
   }

}
