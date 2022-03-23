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
    String proIdReport;
    String type;
    String report;
    Date date;
    int status;  
    
    /**
    *Créer une nouveau examen
    *@param examId : identifiant de l'examen
    *@param patientId : identifiant du patient 
    *@param proId : identifiant du professionnel de santé
    *@param proIdReport : identifiant du professionnel de santé ayant rédigé le compte-rendu
    *@param type : type d'examen (IRM, scanner, radio)
    *@param report : compt-rendu
    *@param date : date de réalisation de l'examen
    *@param status : état de l'examen (terminé ou pas terminé)
    */
    public Examen(String examId, String patientId, String proId, String proIdReport, String type, String report, Date date, int status) {
        this.examId = examId;
        this.patientId = patientId;
        this.proId = proId;
        this.proIdReport = proIdReport;
        this.type = type;
        this.report = report;
        this.date = date;
        this.status = status;
    }

    /**
    *Récupérer l'id d'un examen
    *@return : id de l'examen
    */
    public String getExamId() {
        return examId;
    }
 
    /**
    *Récupérer l'id du patient passant l'examen
    *@return : id du patient
    */
    public String getPatientId() {
        return patientId;
    }
    
    /**
    *Récupérer l'id du professionnel de santé effectuant l'examen
    *@return : id du professionnel de santé
    */
    public String getProId() {
        return proId;
    }
    
    /**
    *Récupérer l'id du professionnel de santé ayant rempli le compte-rendu de l'examen
    *@return : id du professionnel de santé
    */
    public String getProIdReport() {
        return proIdReport;
    }
    
    /**
    *Récupérer le type d'examen
    *@return : type d'examen
    */
    public String getType() {
        return type;
    }
    
    /**
    *Récupérer le compte-rendu de l'examen
    *@return : compte-rendu
    */
    public String getReport() {
        return report;
    }
    
    /**
    *Récupérer la date de réalisation de l'examen
    *@return : date de réalisation de l'examen
    */
    public Date getDate() {
        return date;
    }
    
    /**
    *Récupérer l'état de l'examen (terminé ou non terminé)
    *@return : état de l'examen
    */
    public int getStatus() {
        return status;
    }
    
}
