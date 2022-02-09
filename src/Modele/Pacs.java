/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author Brune
 */
public class Pacs {
    String idExam;
    String idPacs;
    String image;
    
    public Pacs(String idExam, String idPacs, String image) {
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
    
    public String getImage() {
        return image;
    }
}
