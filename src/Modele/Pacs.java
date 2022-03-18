/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import java.awt.Image;
import java.io.InputStream;

/**
 *
 * @author Brune
 */
public class Pacs {
    String idExam;
    String idPacs;
    Image image;
    
    public Pacs(String idPacs, String idExam, Image image) {
        this.idExam = idExam;
        this.idPacs = idPacs;
        this.image = image;
    }
    
    public String getIdExam() {
        return idExam;
    }
    
    public String getIdPacs() {
        return idPacs;
    }
    
    public Image getImage() {
        return image;
    }
}
