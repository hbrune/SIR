/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controleur;

import ConnexionBD.DatabaseAccessProperties;
import Modele.Login;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Brune
 */
public class SecretaryController {
    Login user;
    private static DatabaseAccessProperties dap;
    
    public SecretaryController(Login user) {
        this.user = user;
    }
    
    public void recherchePatient(String critere, String recherche) {
    
        //recherchePatientByCriteria(critere, recherche);
       
    }
    
    public void recherchePatientFromDdn(Date ddn) {
        
        //Conversion date en date SQL > '05-JAN-2003
        //recherchePatientByDdn(recherche);     
           
       
    }
    
}
