package com.ensah.core.bo;


import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
@Entity
public class Role {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int idRole;


   private String nomRole;

   @OneToMany(mappedBy="role", cascade=CascadeType.ALL)
   public Collection<Compte> comptes;


   /** @pdGenerated default getter */
   public Collection<Compte> getComptes() {
      if (comptes == null)
         comptes = new HashSet<Compte>();
      return comptes;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorComptes() {
      if (comptes == null)
         comptes = new HashSet<Compte>();
      return comptes.iterator();
   }

   /** @pdGenerated default setter
     * @param newComptes */
   public void setComptes(Collection<Compte> newComptes) {
      removeAllComptes();
      for (Iterator iter = newComptes.iterator(); iter.hasNext();)
         addComptes((Compte)iter.next());
   }

   /** @pdGenerated default add
     * @param newCompte */
   public void addComptes(Compte newCompte) {
      if (newCompte == null)
         return;
      if (this.comptes == null)
         this.comptes = new HashSet<Compte>();
      if (!this.comptes.contains(newCompte))
      {
         this.comptes.add(newCompte);
         newCompte.setRole(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldCompte */
   public void removeComptes(Compte oldCompte) {
      if (oldCompte == null)
         return;
      if (this.comptes != null)
         if (this.comptes.contains(oldCompte))
         {
            this.comptes.remove(oldCompte);
            oldCompte.setRole((Role)null);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllComptes() {
      if (comptes != null)
      {
         Compte oldCompte;
         for (Iterator iter = getIteratorComptes(); iter.hasNext();)
         {
            oldCompte = (Compte)iter.next();
            iter.remove();
            oldCompte.setRole((Role)null);
         }
      }
   }

}
