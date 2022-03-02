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
    Login user;
    private static RequetesSQL sql;
    DashboardSecretaire dashboard;
    RecherchePatientSecretaire rp;
    String error = "";
    String success = "";
    
    
    public SecretaireController(Login user) throws ClassNotFoundException {
        this.user = user;
        sql = new RequetesSQL();
        dashboard = new DashboardSecretaire(user, this);
        dashboard.setVisible(true);
    }
    
    // GETTERS ET SETTERS
    
    public String getError() {
        return error;
    }
    
    public String getSuccess() {
        return success;
    }
    
    // INTERFACES
    
    public void displayDashboard() {
        dashboard = new DashboardSecretaire(user, this);
        dashboard.setVisible(true);
    }
    
    public void displayRecherchePatient() throws SQLException {
        ArrayList<Patient> patients = sql.getPatients();
        rp = new RecherchePatientSecretaire(user, this, patients);
        rp.setVisible(true);
    }
    
    public void displayAjoutPatient(String origine) throws SQLException {
        String UID = generateUid();
        /*if(sql.getPatientById(UID) != null) {
            //Un patient avec cet UID existe déjà, on relance la fonction pour générer un autre UID
            displayAjoutPatient(origine);
        }*/
        AjouterPatient ap = new AjouterPatient(user, this, origine, UID);
        ap.setVisible(true);
    }
    
    public String generateUid() {
        return UUID.randomUUID().toString().replace("-","").substring(0,10);
    }
        
    // RECHERCHE ET AJOUT EN BD
    
    public void recherchePatient(String critere, String recherche) throws SQLException {
    
        //recherchePatientByCriteria(critere, recherche);
        if (recherche.equals("recherche selon le critère selectionné") || recherche.equals("")) {
            error = "Veuillez entrer une recherche";
        } else {
            error = "";
            ArrayList<Patient> patients = sql.getPatientByCriteria(critere, recherche.toLowerCase());
            rp.updatePatients(patients);
            
            System.out.println(patients.size());
            
        }
       
    }
    
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
    
    public void recherchePatientFromDdn(Date ddn) {
        
        //Conversion date en date SQL > '05-JAN-2003
        //recherchePatientByDdn(recherche);     
           
    }    
}
