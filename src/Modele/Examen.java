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
public class Examen {
    String examId;
    String patientId;
    String proId;
    String type;
    String report;
    Date date;
    int status;  
    
    public Examen(String examId, String patientId, String proId, String type, String report, Date date, int status) {
        this.examId = examId;
        this.patientId = patientId;
        this.proId = proId;
        this.type = type;
        this.report = report;
        this.date = date;
        this.status = status;
    }

    public String getExamId() {
        return examId;
    }
 
    public String getPatientId() {
        return patientId;
    }
    
    public String getProId() {
        return proId;
    }
    
    public String getType() {
        return type;
    }
    
    public String getReport() {
        return report;
    }
    
    public Date getDate() {
        return date;
    }
    
    public int getStatus() {
        return status;
    }
    
}
