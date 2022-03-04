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

    public String getDemandeId() {
        return demandeId;
    }

    public String getNomP() {
        return nomP;
    }

    public String getPrenomP() {
        return prenomP;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getSexe() {
        return sexe;
    }

    public Date getDdn() {
        return ddn;
    }

    public String getTypeExam() {
        return typeExam;
    }

    public Date getDatePrescription() {
        return datePrescription;
    }
    
    public String getCommentaire() {
        return commentaire;
    }
   
}