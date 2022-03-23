/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Date;

/**
 *
 * @author mikam
 */
public class Demande {
    String demandeId;
    String nomP;
    String prenomP;
    String adresse;
    String sexe;
    Date ddn;
    String typeExam;
    Date datePrescription;
    String commentaire;

    /**
    *Créer une nouvelle demande
    *@param demandeId : identifiant de la demande
    *@param nomP : nom du patient 
    *@param prenomP : prénom du patient
    *@param adresse : adresse du patient
    *@param sexe : sexe du patient
    *@param ddn : date de naissance du patient
    *@param typeExam : type d'examen à réaliser
    *@param datePrescription : date de prescription de l'examen
    *@param commentaire : remarques par rapport à l'examen
    */
    public Demande(String demandeId, String nomP, String prenomP, String adresse, String sexe, Date ddn, String typeExam, Date datePrescription, String commentaire) {
        this.demandeId = demandeId;
        this.nomP = nomP;
        this.prenomP = prenomP;
        this.adresse = adresse;
        this.sexe = sexe;
        this.ddn = ddn;
        this.typeExam = typeExam;
        this.datePrescription = datePrescription;
        this.commentaire = commentaire;
    }

    /**
    *Récupérer l'id d'une demande
    *@return : id de la demande
    */
    public String getDemandeId() {
        return demandeId;
    }

    /**
    *Récupérer le nom du patient d'une demande
    *@return : nom du patient
    */
    public String getNomP() {
        return nomP;
    }

    /**
    *Récupérer le prénom du patient d'une demande
    *@return : prénom du patient
    */
    public String getPrenomP() {
        return prenomP;
    }

    /**
    *Récupérer l'adresse du patient d'une demande
    *@return : adresse du patient
    */
    public String getAdresse() {
        return adresse;
    }

    /**
    *Récupérer le sexe du patient d'une demande
    *@return : sexe du patient
    */
    public String getSexe() {
        return sexe;
    }

    /**
    *Récupérer la date de naissance du patient d'une demande
    *@return : date de naissance du patient
    */
    public Date getDdn() {
        return ddn;
    }

    /**
    *Récupérer le type d'examen à faire
    *@return : type d'examen
    */
    public String getTypeExam() {
        return typeExam;
    }

    /**
    *Récupérer la date de prescription de l'examen 
    *@return : date de prescription de l'examen
    */
    public Date getDatePrescription() {
        return datePrescription;
    }
    
    /**
    *Récupérer les remarques faites par rapport à l'examen à réaliser
    *@return : commentaire par rapport à l'examen
    */
    public String getCommentaire() {
        return commentaire;
    }
   
}