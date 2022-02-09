/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modèle;

/**
 *
 * @author Brune
 */
public enum TypeUtilisateur {
    PHR (1),
    PH (2),
    MR (3),
    SECR (4);

    int type;
    
    TypeUtilisateur(int type) {
        this.type = type;
    }
    
    public int type() {
        return type;
    }
}
