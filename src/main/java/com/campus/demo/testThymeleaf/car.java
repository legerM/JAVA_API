/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.campus.demo.testThymeleaf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Mickael_L
 */
@Entity
public class Car {
      @Id
    @GeneratedValue
    Integer ID;
    String modele;
    String couleur;
    String marque;
    
    public Car(Integer ID , String modele,String couleur , String marque){
        this.ID=ID;
        this.couleur=couleur;
        this.marque=marque;
        this.modele=modele;
    }

    public Integer getID() {
        return ID;
    }

    public String getModele() {
        return modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getMarque() {
        return marque;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
    
    
    
}
