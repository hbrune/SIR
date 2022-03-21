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
    
    public Pacs(String idPacs, String idExam, Image image) {
        this.idExam = idExam;
        this.idPacs = idPacs;
        this.image = image;
    }
    
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
