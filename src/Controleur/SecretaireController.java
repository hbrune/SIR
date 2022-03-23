/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controleur;

import ConnexionBD.DatabaseAccessProperties;
import ConnexionBD.RequetesSQL;
import Modele.Login;
import Modele.Patient;
import Vue.AjouterPatient;
import Vue.DashboardSecretaire;
import Vue.RecherchePatientSecretaire;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Brune
 */
public class SecretaireController extends UserController {
    private static RequetesSQL sql;
    DashboardSecretaire dashboard;
    RecherchePatientSecretaire rp;
    String error = "";
    String success = "";
    
    /**
    *Afficher l'interface d'accueil propre aux secrétaires, crée une instance de RequeteSQL permettant les échanges avec la base de données.
    *@param user : utilisateur connecté (secrétaire)
    *@throws ClassNotFoundException 
    */
    public SecretaireController(Login user) throws ClassNotFoundException {
        this.user = user;
        sql = new RequetesSQL();
        dashboard = new DashboardSecretaire(user, this);
        dashboard.setVisible(true);
    }
    
    /**
    Obtenir le message de réussite lors de la création d'un patient
    *@return : chaine de caractère correspondant au message de réussite (vide s'il n'y en a pas)
    */
    public String getSuccess() {
        return success;
    }
    
    // INTERFACES
    /**
    *Afficher l'interface d'accueil propre aux secrétaires
    */
    public void displayDashboard() {
        dashboard = new DashboardSecretaire(user, this);
        dashboard.setVisible(true);
    }
    
    /**
    *Afficher l'interface de recherche patient
    *Recherche en base de données de tous les patients enregistrés en base de données pour les afficher
    */
    public void displayRecherchePatient() throws SQLException {
        ArrayList<Patient> patients = sql.getPatients();
        rp = new RecherchePatientSecretaire(user, this, patients);
        rp.setVisible(true);
    }
    
    /**
    *Afficher l'interface d'ajout patient
    *Génère un identifiant unique et vérifie qu'il n'est pas déjà utilisé
    * @param origine : nom de l'interface d'origine pour revenir sur la bonne page en cas de retour à la page précédente
    */
    public void displayAjoutPatient(String origine) throws SQLException {
        String UID = generateUid();
        if(sql.getPatientById(UID) != null) {
            //Un patient avec cet UID existe déjà, on relance la fonction pour générer un autre UID
            displayAjoutPatient(origine);
        }
        AjouterPatient ap = new AjouterPatient(user, this, origine, UID);
        ap.setVisible(true);
    }
        
    // RECHERCHE ET AJOUT EN BD
    /**
    *Ajouter un patient
    *Vérification que les champs sont bien remplis et vérification que le patient n'est pas déjà enregistré
    * @param p : patient à ajouter
    */
    public void ajouterPatient(Patient p) throws SQLException {
        if(p.getLastNameP().equals("") || p.getFirstNameP().equals("") || p.getAdress().equals("") ) {
            error = "Veuillez remplir tous les champs";
            success = "";
        } else {
            if(!sql.verifierPatient(p)) {
            try {
                sql.addPatient(p);
                error = "";
                success = "Un patient a bien été créé";
            } catch (SQLException e) {
                error = e.getMessage();
            }
            } else {
                //Un patient avec ce nom prénom et adresse existe déjà : message d'erreur
                error = "Ce patient existe déjà";
                success = "";
            }
        }
    }      
}
