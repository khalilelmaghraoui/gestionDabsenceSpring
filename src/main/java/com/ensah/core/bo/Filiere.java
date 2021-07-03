package com.ensah.core.bo;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Filiere {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private String idFiliere;

   private String titreFiliere;

   private String codeFiliere;

   private int anneeaccreditation;

   private int anneeFinaccreditation;

   @OneToMany(mappedBy="filiere", cascade=CascadeType.ALL)
   public Collection<Niveau> niveaux;

   @OneToMany(cascade=CascadeType.ALL)
   @JoinColumn(name="idUtilisateur")
   public Collection<Coordination> periodeCoordination;


   /** @pdGenerated default getter */
   public Collection<Niveau> getNiveaux() {
      if (niveaux == null)
         niveaux = new HashSet<Niveau>();
      return niveaux;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorNiveaux() {
      if (niveaux == null)
         niveaux = new HashSet<Niveau>();
      return niveaux.iterator();
   }

   /** @pdGenerated default setter
     * @param newNiveaux */
   public void setNiveaux(Collection<Niveau> newNiveaux) {
      removeAllNiveaux();
      for (Iterator iter = newNiveaux.iterator(); iter.hasNext();)
         addNiveaux((Niveau)iter.next());
   }

   /** @pdGenerated default add
     * @param newNiveau */
   public void addNiveaux(Niveau newNiveau) {
      if (newNiveau == null)
         return;
      if (this.niveaux == null)
         this.niveaux = new HashSet<Niveau>();
      if (!this.niveaux.contains(newNiveau))
      {
         this.niveaux.add(newNiveau);
         newNiveau.setFiliere(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldNiveau */
   public void removeNiveaux(Niveau oldNiveau) {
      if (oldNiveau == null)
         return;
      if (this.niveaux != null)
         if (this.niveaux.contains(oldNiveau))
         {
            this.niveaux.remove(oldNiveau);
            oldNiveau.setFiliere((Filiere)null);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllNiveaux() {
      if (niveaux != null)
      {
         Niveau oldNiveau;
         for (Iterator iter = getIteratorNiveaux(); iter.hasNext();)
         {
            oldNiveau = (Niveau)iter.next();
            iter.remove();
            oldNiveau.setFiliere((Filiere)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<Coordination> getPeriodeCoordination() {
      if (periodeCoordination == null)
         periodeCoordination = new HashSet<Coordination>();
      return periodeCoordination;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorPeriodeCoordination() {
      if (periodeCoordination == null)
         periodeCoordination = new HashSet<Coordination>();
      return periodeCoordination.iterator();
   }

   /** @pdGenerated default setter
     * @param newPeriodeCoordination */
   public void setPeriodeCoordination(Collection<Coordination> newPeriodeCoordination) {
      removeAllPeriodeCoordination();
      for (Iterator iter = newPeriodeCoordination.iterator(); iter.hasNext();)
         addPeriodeCoordination((Coordination)iter.next());
   }

   /** @pdGenerated default add
     * @param newCoordination */
   public void addPeriodeCoordination(Coordination newCoordination) {
      if (newCoordination == null)
         return;
      if (this.periodeCoordination == null)
         this.periodeCoordination = new HashSet<Coordination>();
      if (!this.periodeCoordination.contains(newCoordination))
         this.periodeCoordination.add(newCoordination);
   }

   /** @pdGenerated default remove
     * @param oldCoordination */
   public void removePeriodeCoordination(Coordination oldCoordination) {
      if (oldCoordination == null)
         return;
      if (this.periodeCoordination != null)
         if (this.periodeCoordination.contains(oldCoordination))
            this.periodeCoordination.remove(oldCoordination);
   }

   /** @pdGenerated default removeAll */
   public void removeAllPeriodeCoordination() {
      if (periodeCoordination != null)
         periodeCoordination.clear();
   }

}
