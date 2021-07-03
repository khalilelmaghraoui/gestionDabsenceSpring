package com.ensah.core.bo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

@Entity
@Table(name="pieceJustificative")
public class PieceJustificative {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int idPieceJustificative;

   private String cheminFichier;

   private String intitule;

   private Date dateLivraison;

   private int etat;

   private String source;

   @ManyToMany
   @JoinTable(name="Absence_PieceJustificative",
		   	  joinColumns = @JoinColumn(name="idPieceJustificative"),
		   	  inverseJoinColumns = @JoinColumn(name="idAbsence")
		   )
   public Collection<Absence> absence;


   /** @pdGenerated default getter */
   public Collection<Absence> getAbsence() {
      if (absence == null)
         absence = new HashSet<Absence>();
      return absence;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorAbsence() {
      if (absence == null)
         absence = new HashSet<Absence>();
      return absence.iterator();
   }

   /** @pdGenerated default setter
     * @param newAbsence */
   public void setAbsence(Collection<Absence> newAbsence) {
      removeAllAbsence();
      for (Iterator iter = newAbsence.iterator(); iter.hasNext();)
         addAbsence((Absence)iter.next());
   }

   /** @pdGenerated default add
     * @param newAbsence */
   public void addAbsence(Absence newAbsence) {
      if (newAbsence == null)
         return;
      if (this.absence == null)
         this.absence = new HashSet<Absence>();
      if (!this.absence.contains(newAbsence))
      {
         this.absence.add(newAbsence);
         newAbsence.addPieceJustificative(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldAbsence */
   public void removeAbsence(Absence oldAbsence) {
      if (oldAbsence == null)
         return;
      if (this.absence != null)
         if (this.absence.contains(oldAbsence))
         {
            this.absence.remove(oldAbsence);
            oldAbsence.removePieceJustificative(this);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllAbsence() {
      if (absence != null)
      {
         Absence oldAbsence;
         for (Iterator iter = getIteratorAbsence(); iter.hasNext();)
         {
            oldAbsence = (Absence)iter.next();
            iter.remove();
            oldAbsence.removePieceJustificative(this);
         }
      }
   }

}
