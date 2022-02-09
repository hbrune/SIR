/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controleur;

import Modele.Login;
import java.time.LocalDate;

/**
 *
 * @author Brune
 */
public class SecretaryController {
    Login user;
    
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
}
