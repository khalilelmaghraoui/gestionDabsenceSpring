package com.ensah.core.bo;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@Entity
public class Enseignant extends Utilisateur {

   private String specialite;

   @OneToMany(mappedBy="utilisateur", cascade=CascadeType.ALL)
   public Collection<Absence> absencesMarquees;



   public Collection<Absence> getAbsencesMarquees() {
      if (absencesMarquees == null)
         absencesMarquees = new HashSet<Absence>();
      return absencesMarquees;
   }


   public Iterator getIteratorAbsencesMarquees() {
      if (absencesMarquees == null)
         absencesMarquees = new HashSet<Absence>();
      return absencesMarquees.iterator();
   }



   public void setAbsencesMarquees(Collection<Absence> newAbsencesMarquees) {
      removeAllAbsencesMarquees();
      for (Iterator iter = newAbsencesMarquees.iterator(); iter.hasNext();)
         addAbsencesMarquees((Absence)iter.next());
   }

   /** @pdGenerated default add
     * @param newAbsence */
   public void addAbsencesMarquees(Absence newAbsence) {
      if (newAbsence == null)
         return;
      if (this.absencesMarquees == null)
         this.absencesMarquees = new HashSet<Absence>();
      if (!this.absencesMarquees.contains(newAbsence))
      {
         this.absencesMarquees.add(newAbsence);
         newAbsence.setObservateur(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldAbsence */
   public void removeAbsencesMarquees(Absence oldAbsence) {
      if (oldAbsence == null)
         return;
      if (this.absencesMarquees != null)
         if (this.absencesMarquees.contains(oldAbsence))
         {
            this.absencesMarquees.remove(oldAbsence);
            oldAbsence.setObservateur((Enseignant)null);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllAbsencesMarquees() {
      if (absencesMarquees != null)
      {
         Absence oldAbsence;
         for (Iterator iter = getIteratorAbsencesMarquees(); iter.hasNext();)
         {
            oldAbsence = (Absence)iter.next();
            iter.remove();
            oldAbsence.setObservateur((Enseignant)null);
         }
      }
   }

}
