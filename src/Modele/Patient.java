/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import java.time.LocalDate;
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

    public Patient(String patientId, String lastNameP, String firstNameP, String adress, String gender, Date ddn) {
        this.patientId = patientId;
        this.lastNameP = lastNameP;
        this.firstNameP = firstNameP;
        this.adress = adress;
        this.gender = gender;
        this.ddn = ddn;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getLastNameP() {
        return lastNameP;
    }

    public String getFirstNameP() {
        return firstNameP;
    }

    public String getAdress() {
        return adress;
    }

    public String getGender() {
        return gender;
    }

    public Date getDdn() {
        return ddn;
    }
    
    
    
}
