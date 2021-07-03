package com.ensah.core.bo;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@Entity
public class Niveau {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int idNiveau;

   private String alias;

   private String titre;

   @OneToMany(mappedBy="niveau", cascade=CascadeType.ALL)
   public Collection<Module> modules;

   @OneToMany(mappedBy="niveau", cascade=CascadeType.ALL)
   public Collection<Inscription> niveau;

   @ManyToOne
   @JoinColumn(name="idModule")
   public Filiere filiere;


   /** @pdGenerated default getter */
   public Collection<Module> getModules() {
      if (modules == null)
         modules = new HashSet<Module>();
      return modules;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorModules() {
      if (modules == null)
         modules = new HashSet<Module>();
      return modules.iterator();
   }

   /** @pdGenerated default setter
     * @param newModules */
   public void setModules(Collection<Module> newModules) {
      removeAllModules();
      for (Iterator iter = newModules.iterator(); iter.hasNext();)
         addModules((Module)iter.next());
   }

   /** @pdGenerated default add
     * @param newModule */
   public void addModules(Module newModule) {
      if (newModule == null)
         return;
      if (this.modules == null)
         this.modules = new HashSet<Module>();
      if (!this.modules.contains(newModule))
      {
         this.modules.add(newModule);
         newModule.setNiveau(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldModule */
   public void removeModules(Module oldModule) {
      if (oldModule == null)
         return;
      if (this.modules != null)
         if (this.modules.contains(oldModule))
         {
            this.modules.remove(oldModule);
            oldModule.setNiveau((Niveau)null);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllModules() {
      if (modules != null)
      {
         Module oldModule;
         for (Iterator iter = getIteratorModules(); iter.hasNext();)
         {
            oldModule = (Module)iter.next();
            iter.remove();
            oldModule.setNiveau((Niveau)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<Inscription> getNiveau() {
      if (niveau == null)
         niveau = new HashSet<Inscription>();
      return niveau;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorNiveau() {
      if (niveau == null)
         niveau = new HashSet<Inscription>();
      return niveau.iterator();
   }

   /** @pdGenerated default setter
     * @param newNiveau */
   public void setNiveau(Collection<Inscription> newNiveau) {
      removeAllNiveau();
      for (Iterator iter = newNiveau.iterator(); iter.hasNext();)
         addNiveau((Inscription)iter.next());
   }

   /** @pdGenerated default add
     * @param newInscription */
   public void addNiveau(Inscription newInscription) {
      if (newInscription == null)
         return;
      if (this.niveau == null)
         this.niveau = new HashSet<Inscription>();
      if (!this.niveau.contains(newInscription))
      {
         this.niveau.add(newInscription);
         newInscription.setInscriptions(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldInscription */
   public void removeNiveau(Inscription oldInscription) {
      if (oldInscription == null)
         return;
      if (this.niveau != null)
         if (this.niveau.contains(oldInscription))
         {
            this.niveau.remove(oldInscription);
            oldInscription.setInscriptions((Niveau)null);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllNiveau() {
      if (niveau != null)
      {
         Inscription oldInscription;
         for (Iterator iter = getIteratorNiveau(); iter.hasNext();)
         {
            oldInscription = (Inscription)iter.next();
            iter.remove();
            oldInscription.setInscriptions((Niveau)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Filiere getFiliere() {
      return filiere;
   }

   /** @pdGenerated default parent setter
     * @param newFiliere */
   public void setFiliere(Filiere newFiliere) {
      if (this.filiere == null || !this.filiere.equals(newFiliere))
      {
         if (this.filiere != null)
         {
            Filiere oldFiliere = this.filiere;
            this.filiere = null;
            oldFiliere.removeNiveaux(this);
         }
         if (newFiliere != null)
         {
            this.filiere = newFiliere;
            this.filiere.addNiveaux(this);
         }
      }
   }

}
