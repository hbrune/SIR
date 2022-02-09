/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import java.time.LocalDate;

/**
 *
 * @author Brune
 */
public class Patient {
    String patientId;
    String name;
    String surname;
    String adress;
    String gender;
    LocalDate ddn;

    public Patient(String name, String surname, String adress, String gender, LocalDate ddn) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.gender = gender;
        this.ddn = ddn;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAdress() {
        return adress;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDdn() {
        return ddn;
    }
    
    
    
}
