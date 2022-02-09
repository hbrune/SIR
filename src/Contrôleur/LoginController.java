/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contrôleur;

import ConnexionBD.DatabaseAccessProperties;
import Modèle.Login;
import Modèle.TypeUtilisateur;
import Vue.Accueil;
import Vue.Authentification;
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
    Authentification authView;
    Accueil accueilView;
    DatabaseAccessProperties dap;
    
    
    public LoginController() throws ClassNotFoundException {
        user = null;
        dap = new DatabaseAccessProperties();
        this.authView = authView;
    }
    
    public void setAuthView(Authentification authView) {
        this.authView = authView;
    }
    
    public void login(String login, String pwd) throws SQLException {
        //Tests en attendant la BD
        if (login.equals("login") && pwd.equals("mdp")){    
            System.out.println("connecté");
            authView.dispose();
            authView = null;
            accueilView = new Accueil();
            accueilView.setUser(user);
            accueilView.setVisible(true);
        }

/*
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
                while (res.next()) {
                    
                    Login user = new Login ();
                    user.setIdLogin(res.getNString("loginID"));
                    user.setSurname(res.getNString("surname"));
                    user.setName(res.getNString("name"));
                    user.setFunction(res.getInt("function"));
                }
                


                //On crée un user à partir des infos récupérées (on vérifie qu'il est valide
                
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
        
        
        
        */
        
    }
    
    public void setUser(Login user){
        this.user = user;
    }
    
    
}
