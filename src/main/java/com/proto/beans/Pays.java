package com.proto.beans;

import javax.persistence.*;

@Entity
public class Pays  {

      public Pays() { }

      public Pays(String code, String nom, String langue) {
            this.code = code;
            this.nom = nom;
            this.langue = langue;
      }

      @Id
      private String code;
      public void setCode(String c) {code = c;}
      public String getCode() {return code ;}

      @Column(nullable = false, unique = true)
      private String nom;
      public void setNom(String n) {nom = n;}
      public String getNom() {return nom;}

      private String langue;
      public void setLangue(String l) {langue = l;}
      public String getLangue() {return langue;}

      @Transient
      private String nonPersistant;
      public String getNonPersistant() { return nonPersistant; }
      public void setNonPersistant(String nonPersistant) { this.nonPersistant = nonPersistant; }
}