/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controleur;

import ConnexionBD.RequetesSQL;
import Modele.Login;
import Modele.Patient;
import Vue.DashboardSecretaire;
import Vue.RecherchePatientSecretaire;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Brune
 */
public class UserController {
    
    Login user;
    private static RequetesSQL sql;
    String error = "";
    
    
    public UserController() throws ClassNotFoundException {
        this.user = user;
        sql = new RequetesSQL();
    }
    
    public String getError() {
        return error;
    }
        
    // RECHERCHE EN BD
    /**
    *Obtenir la liste de tous les patients enregistrés en base de données
    * @return : liste de patients
    */
    public ArrayList<Patient> listePatient() throws SQLException {
        ArrayList<Patient> liste = new ArrayList<>();
        liste = sql.getPatients();
        return liste;
    }
    
    /**
    *Obtenir la liste des patients selon un critère de recherche : identifiant unique, nom ou prénom
    * @param critere : critère de recherche (nom de l'attribut en base de donnée)
    * @param recherche : identifiant, nom ou prénom recherché
    * @return : liste de patients correspondant à la recherche
    */
    public ArrayList<Patient> recherchePatient(String critere, String recherche) throws SQLException {
        ArrayList<Patient> patients = null;
        if (recherche.equals("recherche selon le critère selectionné") || recherche.equals("")) {
            error = "Veuillez entrer une recherche";
        } else {
            error = "";
            patients = sql.getPatientByCriteria(critere, recherche);
            if (patients.size() == 0) {
                error = "Aucun patient trouvé";
            }      
        }
        return patients;
    }
    
    /**
    *Obtenir la liste des patients né à la date choisie
    * @param ddn : date de naissance recherchée
    * @return : liste de patients correspondant à la recherche
    */
    public ArrayList<Patient> recherchePatient(Date ddn) {
        ArrayList<Patient> patients = null;
        try {
            patients = sql.recherchePatientByDdn(ddn);
        } catch (SQLException ex) {
            error = ex.getMessage();
        }
        return patients;
    }
        
    /**
    *Générer un identifiant unique (10 chiffres et lettres)
    * @return : identifiant généré
    */
    public String generateUid() {
        return UUID.randomUUID().toString().replace("-","").substring(0,10);
    }
}
