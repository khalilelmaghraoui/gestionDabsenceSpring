package com.ensah.core.bo;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@Entity
public class Module {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int idModule;

   private String titre;

   private String code;

   @OneToMany(mappedBy="module", cascade=CascadeType.ALL)
   public Collection<Matiere> matieres;

   @ManyToOne
   @JoinColumn(name="idNiveau")
   public Niveau niveau;


   public Collection<Matiere> getMatieres() {
      if (matieres == null)
         matieres = new HashSet<Matiere>();
      return matieres;
   }

   public Iterator getIteratorMatieres() {
      if (matieres == null)
         matieres = new HashSet<Matiere>();
      return matieres.iterator();
   }


   public void setMatieres(Collection<Matiere> newMatieres) {
      removeAllMatieres();
      for (Iterator iter = newMatieres.iterator(); iter.hasNext();)
         addMatieres((Matiere)iter.next());
   }


   public void addMatieres(Matiere newMatiere) {
      if (newMatiere == null)
         return;
      if (this.matieres == null)
         this.matieres = new HashSet<Matiere>();
      if (!this.matieres.contains(newMatiere))
      {
         this.matieres.add(newMatiere);
         newMatiere.setModule(this);
      }
   }


   public void removeMatieres(Matiere oldMatiere) {
      if (oldMatiere == null)
         return;
      if (this.matieres != null)
         if (this.matieres.contains(oldMatiere))
         {
            this.matieres.remove(oldMatiere);
            oldMatiere.setModule((Module)null);
         }
   }

   public void removeAllMatieres() {
      if (matieres != null)
      {
         Matiere oldMatiere;
         for (Iterator iter = getIteratorMatieres(); iter.hasNext();)
         {
            oldMatiere = (Matiere)iter.next();
            iter.remove();
            oldMatiere.setModule((Module)null);
         }
      }
   }
   public Niveau getNiveau() {
      return niveau;
   }


   public void setNiveau(Niveau newNiveau) {
      if (this.niveau == null || !this.niveau.equals(newNiveau))
      {
         if (this.niveau != null)
         {
            Niveau oldNiveau = this.niveau;
            this.niveau = null;
            oldNiveau.removeModules(this);
         }
         if (newNiveau != null)
         {
            this.niveau = newNiveau;
            this.niveau.addModules(this);
         }
      }
   }

}
