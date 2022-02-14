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
    Login user;
    Authentification authView;
    RequetesSQL sql;
    String error = "";
    
    
    public LoginController() throws ClassNotFoundException {
        user = null;
        sql = new RequetesSQL();        
        authView = new Authentification(this);
        authView.setVisible(true);
    }
    
    public void setAuthView(Authentification authView) {
        this.authView = authView;
    }
    
    public String getError() {
        return error;
    }
    
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
    
    public void setUser(Login user){
        this.user = user;
    }
    
    
}
