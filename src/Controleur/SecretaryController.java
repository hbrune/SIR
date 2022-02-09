/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controleur;

import ConnexionBD.DatabaseAccessProperties;
import Modele.Login;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

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
    
    public void addPatient(String name, String surname, String adress, String gender, String ddn) {
        //Vérifier infos
        if (!name.equals("") && !surname.equals("") && !adress.equals("")) {
            //Vérifier qu'un patient mêmes infos n'existe pas
        
            //Générer id
            
            
            // transformer ddn en date
        }   
    }
    
    public void recherchePatient(String critere, String recherche) {
    
        recherchePatientByCriteria(critere, recherche);
       
    }
    
    public void recherchePatientFromDdn(Date ddn) {
        
        //Conversion date en date SQL > '05-JAN-2003
        recherchePatientByDdn(recherche);     
           
       
    }
        
    
    
    public static void recherchePatientByCriteria(String critere, String recherche) throws SQLException {
        
        // Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PATIENT where " + critere + "= '" + recherche + "'") ;
        while(rsTest.next()) { 
            System.out.println(rsTest);
            System.out.println("Id du patient : " + rsTest.getString(1));
        }
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
    }

    public static void recherchePatientByDdn(String critere, String recherche) throws SQLException {
        
        // Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PATIENT where birthDate = '" + recherche + "'") ;
        while(rsTest.next()) { 
            System.out.println(rsTest);
            System.out.println("Id du patient : " + rsTest.getString(1));
        }
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
    }
    
}
