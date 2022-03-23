/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author Brune
 */
public enum TypeGenre {
    H (1),
    F (2),
    A (3);

    int type;
    
    /**
    *Modifier le genre d'un patient
    *@param type : genre du patient que l'on veut mettre
    */
    private TypeGenre(int type) {
        this.type = type;
    }
    
    /**
    *Récupérer le genre d'un patient
    *@return : genre du patient
    */
    private int type() {
        return type;
    }
}
