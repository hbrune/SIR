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
public class ManipAndPhController {
    Login user;
    DbConnection coDB;
    
    public ManipAndPhController(Login user) {
        this.user = user;
    }
    
}
