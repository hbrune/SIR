/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import java.util.Date;
/**
 *
 * @author Brune
 */
public class Patient {
    String patientId;
    String lastNameP;
    String firstNameP;
    String adress;
    String gender;
    Date ddn;

    /**
    *Créer un nouveau patient
    *@param patientId : identifiant du patient
    *@param lastNameP : nom du patient 
    *@param firstNameP : prénom du patient
    *@param adress : adresse du patient
    *@param gender : sexe du patient
    *@param ddn : date de naissance du patient
    */
    public Patient(String patientId, String lastNameP, String firstNameP, String adress, String gender, Date ddn) {
        this.patientId = patientId;
        this.lastNameP = lastNameP;
        this.firstNameP = firstNameP;
        this.adress = adress;
        this.gender = gender;
        this.ddn = ddn;
    }

    /**
    *Récupérer l'id d'un patient
    *@return : id du patient
    */
    public String getPatientId() {
        return patientId;
    }

    /**
    *Récupérer le nom d'un patient
    *@return : nom du patient
    */
    public String getLastNameP() {
        return lastNameP;
    }

    /**
    *Récupérer le prénom d'un patient
    *@return : prénom du patient
    */
    public String getFirstNameP() {
        return firstNameP;
    }

    /**
    *Récupérer l'adresse d'un patient
    *@return : adresse du patient
    */
    public String getAdress() {
        return adress;
    }

    /**
    *Récupérer le sexe d'un patient
    *@return : sexe du patient
    */
    public String getGender() {
        return gender;
    }

    /**
    *Récupérer la date de naissance d'un patient
    *@return : date de naissance du patient
    */
    public Date getDdn() {
        return ddn;
    }
    
    
    
}
