/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import java.time.LocalDateTime;

/**
 *
 * @author Brune
 */
public class Examen {
    LocalDateTime date;
    String patientId;
    TypeExamen type;
    String proId;
    String report;
    
    public Examen(LocalDateTime date, String patientId, TypeExamen type, String proId, String report) {
        this.date = date;
        this.patientId = patientId;
        this.type = type;
        this.proId = proId;
        this.report = report;
    }
    
    public LocalDateTime getDate() {
        return date;
    }
    
    public TypeExamen getType() {
        return type;
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public String getProId() {
        return proId;
    }
    
    public String getCompteRendu() {
        return report;
    }
    
    
}
