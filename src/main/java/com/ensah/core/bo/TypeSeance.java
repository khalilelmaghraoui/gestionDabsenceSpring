package com.ensah.core.bo;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="typeseance")
public class TypeSeance {

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int idTypeSeance;
   private String intitule;
   private String alias;

   @OneToMany(mappedBy="typeseance", cascade = CascadeType.ALL)
   public Collection<Absence> absences;


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
         newAbsence.setTypeSeance(this);
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
            oldAbsence.setTypeSeance((TypeSeance)null);
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
            oldAbsence.setTypeSeance((TypeSeance)null);
         }
      }
   }

}
