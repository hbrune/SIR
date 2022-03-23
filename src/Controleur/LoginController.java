/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controleur;

import ConnexionBD.DatabaseAccessProperties;
import ConnexionBD.RequetesSQL;
import Modele.Login;
import Modele.TypeUtilisateur;
import Vue.Authentification;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Brune
 */
public class LoginController {
    Authentification authView;
    RequetesSQL sql;
    String error = "";
    
    /**
    *Ouvre une page de connexion commune à tout type d'utilisateur et crée une instance de RequeteSQL permettant les échanges avec la base de données.
    *@throws ClassNotFoundException 
    */
    public LoginController() throws ClassNotFoundException {
        sql = new RequetesSQL();        
        authView = new Authentification(this);
        authView.setVisible(true);
    }
    
    /**
    *Lie l'interface d'authentification
    *@param authView : interface d'authentification 
    */
    public void setAuthView(Authentification authView) {
        this.authView = authView;
    }
    
    /**
    *Obtenir l'erreur éventuelle lors de la connexion
    *@return : chaine de caractère correspondant à l'erreur (vide s'il n'y en a pas)
    */
    public String getError() {
        return error;
    }
    
    
    /**
    *Se connecter sur le logiciel 
    * Vérification en base de donnée de la combinaison identifiant/mot de passe et affichage de la page d'accueil selon le type d'utilisateur. Affiche un message d'erreur si la combinaison est fausse ou si un champ n'est pas rempli.
    *@param login : identifiant entré par l'utilisateur 
    *@param pwd : mot de passe entré par l'utilisateur
    *@throws SQLException, ClassNotFoundException 
    */
    public void login(String login, String pwd) throws SQLException, ClassNotFoundException {
        
        try {
            if (!login.equals("") && !pwd.equals("")) {
                Login user = sql.authentification(login, pwd);            
                if (user != null){    
                    authView.dispose();
                    authView = null;
                    if(user.getFunction() == 4) {
                        SecretaireController sc = new SecretaireController(user);
                    } else {
                        ManipAndPhController mp = new ManipAndPhController(user);
                    }
                } else {
                    error = "Identifiant ou mot de passe incorrect";
                } 
                } else {
                    error = "Veuillez entrer vos informations de connexion";
                    authView.repaint();
            }  
        } catch(SQLException e) {
            error = e.getMessage();
        }
    }   
}
