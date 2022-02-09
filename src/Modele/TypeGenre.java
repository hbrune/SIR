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
    F (2);

    int type;
    
    private TypeGenre(int type) {
        this.type = type;
    }
    
    private int type() {
        return type;
    }
}
