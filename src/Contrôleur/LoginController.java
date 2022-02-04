/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contrôleur;

import Modèle.Login;
import Modèle.TypeUtilisateur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sir.DbConnection;

/**
 *
 * @author Brune
 */
public class LoginController {
    Login user;
    DbConnection coDB;
    
    public LoginController() {
        user = null;
        coDB = new DbConnection();
    }
    
    public void login(String login, String pwd) throws SQLException {
        //Tests en attendant la BD
        if (login.equals("login") && pwd.equals("mdp")){    
            System.out.println("connecté");
        }


        //Requete
        String request = "select * from login where username = " + login; 
        try {
            //Appel a la DB qui retourne les infos de l'utilisateur
            Statement st = coDB.getConnexion().createStatement();
            ResultSet res = st.executeQuery(request);
            
            
            if (res.next()) {
                //Verif password
                
                //On récupère les infos
                //A remplacer par les infos récupérées
                String idLogin = "";
                String password = "";
                String name = "";
                String surname = "";
                TypeUtilisateur type = TypeUtilisateur.PH;


                //On crée un user à partir des infos récupérées (on vérifie qu'il est valide
                Login user = new Login ("", "", "", "", type);
                if (user.isUserValid()) {
                    setUser(user);
                }

                //Vue page d'accueil secrétaire
                
                
                //Vue page d'accueil autre utilisateur
                
                
            } else {
                System.out.println("Username incorrect");
            }
            
           
            
        } catch(SQLException e) {
            System.out.println("erreur"); 
        }
        
        
        
        
        
    }
    
    public void setUser(Login user){
        this.user = user;
    }
    
    
}
