/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controleur;

import ConnexionBD.RequetesSQL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import Controleur.*;
import Modele.Demande;
import Modele.Examen;
import Modele.Login;
import javax.swing.JLabel;
import java.sql.Connection;
import java.awt.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import library.interfaces.Action;
import library.interfaces.ClientHL7;
import library.interfaces.MessageInterface;
import library.interfaces.Patient;
import library.interfaces.PatientLocation;
import library.interfaces.ServeurHL7;
import library.structure.groupe.messages.Message;

/**
 *
 * @author Brune
 */
public class HL7_SIR {
    private Patient patient; //HL7
    private Action action; // HL7
    private int nbr; // HL7
    private Message message; //Recep HL7
    final ServeurHL7 c; // Connexion HL7
    RequetesSQL sql;

    /**
     * Creates new form HL7_SIS
     */
    public HL7_SIR(int port) throws ClassNotFoundException, SQLException {
        this.patient = null;
        this.message = null;
        sql = new RequetesSQL();
        c = new ServeurHL7();
        c.connection(port);
    }

    public void envoyerDonnees(Examen e, Modele.Patient p, Login m) {
        //Infos patient
        creerPatient(p);
        setValPatient(p);
        
        setInfosExamen(e, m);
        
        // insertion du code du bouton connexion
        ClientHL7 c = new ClientHL7();
        c.connexion("localhost", 4445);
        switch (this.nbr) {
            case 0: {
                c.admit(patient);
                break;
            }
            case 1: {
                c.transPat(patient);
                break;
            }
            case 2: {
                c.endPat(patient);
                break;
            }
        }
        MessageInterface messageAck = c.getMsg();
        c = new ClientHL7();
        
    }
    
    //met les infos de l'examen dans HL7
    private void setInfosExamen(Examen e, Login m) {
        PatientLocation assignedLocation = new PatientLocation(this.patient);
        this.patient.setAssignedPatLocation(assignedLocation);
        //Lit => Type d'examen
        if (e.getType().equals("Radio")) {
            assignedLocation.setBed("Radiologie");
        } else {
            assignedLocation.setBed(e.getType().trim());
        } 
        //Room --> Nom médecin
        assignedLocation.setRoom(m.getLastName());

        //Status --> CR
        String cr = e.getReport();
        cr = cr.replaceAll("\n","*");
        assignedLocation.setStatus(cr);
        
        //Floor --> date/heure
        assignedLocation.setFloor(e.getDate().toString());
    }

    //creer le patient dans HL7
    private void creerPatient(Modele.Patient p) { // peut etre une erreur ici
        Integer id = 1;
        this.patient = new Patient(id, p.getLastNameP(), 'U');
    }

    //rentre les infos du patient dans HL7
    private void setValPatient(Modele.Patient p) {
        //prenom
        this.patient.setFirstName(p.getFirstNameP());
        //Sexe
        if (p.getGender() == "F") {
            this.patient.setSex('F');
        } else if (p.getGender() == "H") {
            this.patient.setSex('M');
        }
        //Date de naissance
        this.patient.setBirth(p.getDdn());
        //locPat.setBed(""); //voir comment ajouter type examen
        //locPat.setStatus(""); //voir comment ajouter l'observation
    }

    public static java.sql.Date convertDateJavaEnSQL(Date d) {
        Date dateReelle = new Date(d.getYear() - 1900, d.getMonth() - 1, d.getDate());
        java.sql.Date dateSQL = new java.sql.Date(dateReelle.getTime());
        return dateSQL;
    }

    public void recuperationDonnees() {
        c.ecoute();
        String messageHL7 = c.protocole();

        System.out.println("Reçu :" + messageHL7);
        /*Timer t = new Timer();
        TimerTask task = new TimerTask() {
            int i = 1;
            private Patient patient;
            private Message message;

            public void run() {

                c.ecoute();
                String messageHL7 = c.protocole();

                System.out.println("Reçu :" + messageHL7);
                this.patient = c.getPatient();
                this.message = c.getMessage();

                //Attention, ici il y avait un if sur la condition  du sexe cf doc donné
                PatientLocation locPat = patient.getAssignedPatLocation();

                //Création de la demande
                String NomOK = patient.getFamillyName();
                String PrenomOK = patient.getFirstName();
                String IdPatOK = String.valueOf(patient.getID());
                String GenderOK = patient.getSex();
                Date DdnOK = convertirStringtoDate(patient.getBirth().toString());
                String ExamOK = locPat.getBed(); //type examen
                String CommentOK = locPat.getStatus(); //CR
                String AdressOK = locPat.getFloor();
                Date DateOK = convertirStringtoDate(locPat.getRoom());
                String sexe;
                if (GenderOK == "F") {
                    GenderOK= "F";
                }
                if (GenderOK == "M") {
                    GenderOK= "H";
                } else {
                    GenderOK= "A";
                }

                ////////////////////////////////CREER EXAMEN //////////////////
                String te = "";
                if (ExamOK.equals("Radiologie")) {
                    ExamOK = "Radio";
                } else {
                    ExamOK = ExamOK;
                } 
                
                //Générer un id demande
                String IdOK = UUID.randomUUID().toString().replace("-","").substring(0,10);

                Demande demande = new Demande(IdOK, NomOK, PrenomOK, AdressOK, GenderOK, DdnOK, ExamOK, DateOK, CommentOK);
                try {
                    sql.addDemande(demande);
                    Demande d = sql.getDemandeById(IdOK);
                    System.out.println(d.getPrenomP() + " : " + d.getTypeExam());
                } catch (SQLException ex) {
                    System.out.println("Problème lors de l'ajout en BD");
                }
                
                // Fin ajout BD 
                this.patient = null;
                this.message = null;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (i == 5) {
                    t.cancel();
                }
                i = i + 1;
            }

            
        };

        //System.out.println("Current time: " + new Date());
        // temps de lecture = 1 min ou 2, il faut le changer pour que ce soit permanent
        t.schedule(task, 5000, 1000);*/
    }
    
    private Date convertirStringtoDate(String dateString) {
        String[] split = dateString.split(" ");
        String[] date = split[0].split("/");
        String[] h = split[1].split(":");
        int jour = Integer.parseInt(date[0]);
        int mois = Integer.parseInt(date[1]);
        int annee = Integer.parseInt(date[2]);
        int heure = Integer.parseInt(h[0]);
        int minutes = Integer.parseInt(h[1]);
        Date dh = new Date(annee,mois,jour,heure,minutes);
        return dh;
    }
}
