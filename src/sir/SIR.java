/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sir;

import ConnexionBD.DatabaseAccessProperties;
import ConnexionBD.RequetesSQL;
import Controleur.HL7_SIR;
import Controleur.LoginController;
import Modele.Login;
import Modele.Patient;
import Modele.Examen;
import Securite.Encryption;
import Securite.Salt;
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
        //rs.getImageFromId("ca7a84e6c6");
        //String uid1 = UUID.randomUUID().toString().replace("-","").substring(0,10);
        //System.out.println("id manip : " + uid1);
        //String uid2 = UUID.randomUUID().toString().replace("-","").substring(0,10);
        //System.out.println(uid2);
        //Login secretaire = new Login(uid1, "roux", "ROUX", "Caitlin", 4);
        // id caitlin : 97740e707f
        //String uid2 = UUID.randomUUID().toString().replace("-","").substring(0,10);
        //System.out.println(uid2);
        //Login manip = new Login(uid2, "roux", "Roux", "Paul", 3);
        //String uid3 = UUID.randomUUID().toString().replace("-","").substring(0,10);
        //System.out.println(uid3);
        //Login manip2 = new Login(uid3, "password", "C", "Mélanie", 3);
        //String uid4 = UUID.randomUUID().toString().replace("-","").substring(0,10);
        //System.out.println(uid4);
        //Login manip3 = new Login(uid4, "random", "Gladieux", "Philippe", 3);
        
        // id manip : bcfc00c134
        // id caitlin : 765a960405
        //String uid2 = UUID.randomUUID().toString().replace("-","").substring(0,10);
        //System.out.println(uid2);
        //Login medecin = new Login(uid2, "mika", "morillon", "mikael", 1);
        //rs.addUser(medecin);
        // id mika : 2a8809b766
        // id melanie : 5200de435d
        // id Philippe : 52b59a2451
        //rs.addUser(secretaire);
        //rs.addUser(medecin);
        //rs.addUser(manip);
        //rs.addUser(manip2);
        //rs.addUser(manip3);
        rs.authentification("52b59a2451", "random");
        
        Date ddn = new Date();
        Patient p1 = new Patient("23","mimi","mimi","5 rue de la Rue","H",ddn);
        //rs.addPatient(p1);
        //rs.verifierPatient(p1);
       
        
        //rs.getPatientById("1");
        
        Examen exam1 = new Examen("1", "1", "1", "1", "IRM", "Le patient va bien", ajd, 1);
        Examen exam2 = new Examen("2", "1", "1", "1",  "IRM", "Le patient va toujours bien", ajd, 1);
        Examen exam3 = new Examen("3", "1", "2", "2",  "Scanner", "Le patient va mal", ajd, 1);
        Examen exam4 = new Examen("4", "1", "2", "2", "Scanner", "Il va mieux", ajd, 1);
        //rs.addExamen(exam4);
        //rs.addReport("1", "Le cr a été modifié");
        //rs.getExamenById("1");
        rs.getListExamenByPatient("1");
        
        ArrayList listPatients = rs.getPatients();
        System.out.println("Nombre de patients enregistrés : " + listPatients.size());
        
        Patient p = rs.getPatientById("1");
        Login m = rs.getProById("c6ecb6cb49");
        
        HL7_SIR testHL7 = new HL7_SIR(4444);
        //testHL7.envoyerDonnees(exam1, p, m);
        //testHL7.recuperationDonnees();
        
        
        LoginController lc = new LoginController(); 
      
     //sir.setVisible(true);
     //Login user = new Login("5", "mika", "MORILLON", "Mikael", 1);
     //rs.addUser(user);
    }
    
}