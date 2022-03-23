/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import java.awt.FlowLayout;
import java.awt.Image;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Brune
 */
public class Pacs {
    String idExam;
    String idPacs;
    Image image;
    
    /**
    *Créer une nouvelle image stockée dans le PACS
    *@param idPacs : identifiant de l'image dans le PACS
    *@param idExam : id de l'examen dans lequel on veut mettre l'image
    *@param image : image
    */
    public Pacs(String idPacs, String idExam, Image image) {
        this.idExam = idExam;
        this.idPacs = idPacs;
        this.image = image;
    }
    
    /**
    *Visualiser une image dans une fenêtre à part
    */
    public void displayImage() {        
        ImageIcon icon1=new ImageIcon(image);
        Image newImg = image.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon im = new ImageIcon(image);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(600,600);
        JLabel lbl2=new JLabel();
        lbl2.setIcon(im);
        frame.add(lbl2);
        frame.setVisible(true);
    }
    
    /**
    *Récupérer l'id d'un examen 
    *@return : id de l'examen
    */
    public String getIdExam() {
        return idExam;
    }
    
    /**
    *Récupérer l'id d'une image dans le PACS
    *@return : id de l'image
    */
    public String getIdPacs() {
        return idPacs;
    }
    
    /**
    *Récupérer une image
    *@return : image
    */
    public Image getImage() {
        return image;
    }
}
