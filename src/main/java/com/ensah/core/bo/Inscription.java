package com.ensah.core.bo;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Inscription {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int idInscription;

   private int annee;

   private int etat;

   @ManyToOne
   @JoinColumn(name="idNiveau")
   public Niveau inscriptions;

   @ManyToOne
   @JoinColumn(name="idUtilisateur")
   public Etudiant etudiant;

   @OneToMany(mappedBy="inscription", cascade=CascadeType.ALL)
   public Collection<Absence> absences;


   /** @pdGenerated default parent getter */
   public Niveau getInscriptions() {
      return inscriptions;
   }

   /** @pdGenerated default parent setter
     * @param newNiveau */
   public void setInscriptions(Niveau newNiveau) {
      if (this.inscriptions == null || !this.inscriptions.equals(newNiveau))
      {
         if (this.inscriptions != null)
         {
            Niveau oldNiveau = this.inscriptions;
            this.inscriptions = null;
            oldNiveau.removeNiveau(this);
         }
         if (newNiveau != null)
         {
            this.inscriptions = newNiveau;
            this.inscriptions.addNiveau(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Etudiant getEtudiant() {
      return etudiant;
   }

   /** @pdGenerated default parent setter
     * @param newEtudiant */
   public void setEtudiant(Etudiant newEtudiant) {
      if (this.etudiant == null || !this.etudiant.equals(newEtudiant))
      {
         if (this.etudiant != null)
         {
            Etudiant oldEtudiant = this.etudiant;
            this.etudiant = null;
            oldEtudiant.removeInscriptions(this);
         }
         if (newEtudiant != null)
         {
            this.etudiant = newEtudiant;
            this.etudiant.addInscriptions(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<Absence> getAbsences() {
      if (absences == null)
         absences = new HashSet<Absence>();
      return absences;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorAbsences() {
      if (absences == null)
         absences = new HashSet<Absence>();
      return absences.iterator();
   }

   /** @pdGenerated default setter
     * @param newAbsences */
   public void setAbsences(Collection<Absence> newAbsences) {
      removeAllAbsences();
      for (Iterator iter = newAbsences.iterator(); iter.hasNext();)
         addAbsences((Absence)iter.next());
   }

   /** @pdGenerated default add
     * @param newAbsence */
   public void addAbsences(Absence newAbsence) {
      if (newAbsence == null)
         return;
      if (this.absences == null)
         this.absences = new HashSet<Absence>();
      if (!this.absences.contains(newAbsence))
      {
         this.absences.add(newAbsence);
         newAbsence.setInscription(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldAbsence */
   public void removeAbsences(Absence oldAbsence) {
      if (oldAbsence == null)
         return;
      if (this.absences != null)
         if (this.absences.contains(oldAbsence))
         {
            this.absences.remove(oldAbsence);
            oldAbsence.setInscription((Inscription)null);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllAbsences() {
      if (absences != null)
      {
         Absence oldAbsence;
         for (Iterator iter = getIteratorAbsences(); iter.hasNext();)
         {
            oldAbsence = (Absence)iter.next();
            iter.remove();
            oldAbsence.setInscription((Inscription)null);
         }
      }
   }

}
