/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sir;

import ConnexionBD.DatabaseAccessProperties;
import ConnexionBD.RequetesSQL;
import Controleur.LoginController;
import Modele.Login;
import Vue.Authentification;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Brune
 */
public class SIR extends JFrame {
    DatabaseAccessProperties dap;
    static Connection conn;
    
    public SIR() throws ClassNotFoundException {
        super("Hôpital Princeton Plainsborough");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.setSize(1000,600);
        //this.setLocationRelativeTo(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //  UIManager.setLookAndFeel( new NimbusLookAndFeel());
        Date ajd = new Date();
        System.out.println(ajd.toString());
        
        java.sql.Date ajdSql = new java.sql.Date(ajd.getTime());
        System.out.println(ajdSql);
        
        
        RequetesSQL rs = new RequetesSQL();
        String uid1 = UUID.randomUUID().toString().replace("-","").substring(0,10);
        System.out.println(uid1);
        String uid2 = UUID.randomUUID().toString().replace("-","").substring(0,10);
        System.out.println(uid2);
        Login secretaire = new Login(uid1, "roux", "ROUX", "Caitlin", 4);
        // id caitlin : 97740e707f
        Login medecin = new Login(uid2, "mika", "morillon", "mikael", 1);
        // id mika : c6ecb6cb49
        //rs.addUser(secretaire);
        //rs.addUser(medecin);
        ArrayList listPatients = rs.getPatients();
        System.out.println("Nombre de patients enregistrés : " + listPatients.size());
        
        LoginController lc = new LoginController(); 
      
     //sir.setVisible(true);
     //Login user = new Login("5", "mika", "MORILLON", "Mikael", 1);
     //rs.addUser(user);
    }
    
}
