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
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Brune
 */
public class SecretaireController {
    Login user;
    private static RequetesSQL sql;
    DashboardSecretaire dashboard;
    String error = "";
    
    public SecretaireController(Login user) throws ClassNotFoundException {
        this.user = user;
        RequetesSQL sql = new RequetesSQL();
        dashboard = new DashboardSecretaire(user, this);
        dashboard.setVisible(true);
    }
    
    public void displayDashboard() {
        dashboard = new DashboardSecretaire(user, this);
        dashboard.setVisible(true);
    }
    
    public void displayRecherchePatient() {
        RecherchePatientSecretaire rp = new RecherchePatientSecretaire(user, this);
        rp.setVisible(true);
    }
    
    public void displayAjoutPatient(String origine) throws SQLException {
        String UID = UUID.randomUUID().toString();
        System.out.println(UID);
        /*if(sql.getPatientById(UID) != null) {
            //Un patient avec cet UID existe déjà, on relance la fonction pour générer un autre UID
            displayAjoutPatient(origine);
        }*/
        AjouterPatient ap = new AjouterPatient(user, this, origine, UID);
        ap.setVisible(true);
    }
        
    public void recherchePatient(String critere, String recherche) {
    
        //recherchePatientByCriteria(critere, recherche);
       
    }
    
    public void ajouterPatient(String lastNameP, String firstNameP, String adress, String gender, Date ddn) throws SQLException {
        /*if(!sql.verifierPatient(lastNameP, firstNameP, adress)) {
           //On génère un UID
           String UID = UUID.randomUUID().toString();
           if(sql.getPatientById(UID) == null) {
               //Un patient avec cet UID existe déjà
           }
           Patient newP = new Patient(UID, lastNameP, firstNameP, adress, gender, ddn);
           
        } else {
            //Un patient avec ce nom prénom et adresse existe déjà : message d'erreur
            error = "Ce patient existe déjà";
        }*/
    }
    
    public void recherchePatientFromDdn(Date ddn) {
        
        //Conversion date en date SQL > '05-JAN-2003
        //recherchePatientByDdn(recherche);     
           
       
    }    
}
