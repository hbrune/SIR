/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

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
    
    /**
    *Modifier le métier d'un professionnel de santé
    *@param type : métier du professionnel de santé que l'on veut mettre
    */
    TypeUtilisateur(int type) {
        this.type = type;
    }
    
    /**
    *Récupérer le métier d'un professionnel de santé
    *@return : métier du professionnel de santé
    */
    public int type() {
        return type;
    }
}
