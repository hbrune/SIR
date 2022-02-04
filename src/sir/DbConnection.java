/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Brune
 */
public class DbConnection {
    Connection cn;
    String urlPilot = ""; //chemin pour charger le pilote
    String urlBDD = ""; //chemin de connexion à la base de données
    
    public DbConnection() {
        //Chargement du pilote
        try {
            Class.forName(urlPilot);
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        
        //Connexion à la base de données
        try {
            cn = (Connection) DriverManager.getConnection(urlBDD, "mdp", "");
            System.out.println("Connexion réussie");
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public Connection getConnexion() {
        return cn;
    }
    
}


