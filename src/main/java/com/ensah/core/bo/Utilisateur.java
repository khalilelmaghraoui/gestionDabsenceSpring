package com.ensah.core.bo;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Utilisateur {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int idUtilisateur;


   private String nom;

   private String prenom;

   private String cin;
   @Column(unique=true)
   private String email;

   private String telephone;

   private String nomArabe;

   private String prenomArabe;

   private String photo;

   //@OneToMany(mappedBy="utilisateur", cascade=CascadeType.ALL)
   public Collection<Compte> comptes;



   public Collection<Compte> getComptes() {
      if (comptes == null)
         comptes = new HashSet<Compte>();
      return comptes;
   }


   public Iterator getIteratorComptes() {
      if (comptes == null)
         comptes = new HashSet<Compte>();
      return comptes.iterator();
   }



   public void setComptes(Collection<Compte> newComptes) {
      removeAllComptes();
      for (Iterator iter = newComptes.iterator(); iter.hasNext();)
         addComptes((Compte)iter.next());
   }



   public void addComptes(Compte newCompte) {
      if (newCompte == null)
         return;
      if (this.comptes == null)
         this.comptes = new HashSet<Compte>();
      if (!this.comptes.contains(newCompte))
      {
         this.comptes.add(newCompte);
         newCompte.setProprietaire(this);
      }
   }



   public void removeComptes(Compte oldCompte) {
      if (oldCompte == null)
         return;
      if (this.comptes != null)
         if (this.comptes.contains(oldCompte))
         {
            this.comptes.remove(oldCompte);
            oldCompte.setProprietaire((Utilisateur)null);
         }
   }



   public void removeAllComptes() {
      if (comptes != null)
      {
         Compte oldCompte;
         for (Iterator iter = getIteratorComptes(); iter.hasNext();)
         {
            oldCompte = (Compte)iter.next();
            iter.remove();
            oldCompte.setProprietaire((Utilisateur)null);
         }
      }
   }

}
