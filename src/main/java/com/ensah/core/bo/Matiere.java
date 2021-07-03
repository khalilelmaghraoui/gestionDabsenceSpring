package com.ensah.core.bo;

import javax.persistence.*;

@Entity
public class Matiere {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int idMatiere;

   private String nom;

   private String code;

   @ManyToOne
   @JoinColumn(name="idModule")
   public Module module;


   /** @pdGenerated default parent getter */
   public Module getModule() {
      return module;
   }

   /** @pdGenerated default parent setter
     * @param newModule */
   public void setModule(Module newModule) {
      if (this.module == null || !this.module.equals(newModule))
      {
         if (this.module != null)
         {
            Module oldModule = this.module;
            this.module = null;
            oldModule.removeMatieres(this);
         }
         if (newModule != null)
         {
            this.module = newModule;
            this.module.addMatieres(this);
         }
      }
   }

}
