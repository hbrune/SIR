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
import java.util.UUID;

/**
 *
 * @author Brune
 */
public class UserController {
    
    Login user;
    private static RequetesSQL sql;
    String error = "";
    String success = "";
    
    
    public UserController() throws ClassNotFoundException {
        this.user = user;
        sql = new RequetesSQL();
    }
    
    
    // RECHERCHE ET AJOUT EN BD
    
    public void recherchePatient(String critere, String recherche) throws SQLException {
    
        //recherchePatientByCriteria(critere, recherche);
        if (recherche.equals("recherche selon le critère selectionné") || recherche.equals("")) {
            error = "Veuillez entrer une recherche";
        } else {
            error = "";
            ArrayList<Patient> patients = sql.getPatientByCriteria(critere, recherche);
         //   rp.updatePatients(patients);
            System.out.println(patients.size());
        }
    }
    
    public String generateUid() {
        return UUID.randomUUID().toString().replace("-","").substring(0,10);
    }
    //public abstract void updatePatients(ArrayList<Patient> patients);
}
