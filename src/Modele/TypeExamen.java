/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author Brune
 */
public enum TypeExamen {
    RADIO (1),
    SCANNER (2),
    IRM (3);

    int type;
    
    private TypeExamen(int type) {
        this.type = type;
    }
    
    private int type() {
        return type;
    }
}
