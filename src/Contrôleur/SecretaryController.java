/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contrôleur;

import Modèle.Login;
import sir.DbConnection;

/**
 *
 * @author Brune
 */
public class SecretaryController {
    Login user;
    DbConnection coDB;
    
    public SecretaryController(Login user) {
        this.user = user;
    }
    
}
