package Controleur;

import Vue.CompleterExamenListe;
import ConnexionBD.RequetesSQL;
import Modele.Examen;
import Modele.Login;
import Modele.Pacs;
import Modele.Patient;
import Vue.AfficherExamen;
import Vue.AjouterExamen;
import Vue.CompleterExamen;
import Vue.Dashboard;
import Vue.DashboardSecretaire;
import Vue.DossierPatient;
import Vue.RecherchePatientMedecin;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
@ -12,9 +17,28 @@ import Modele.Login;
 */
public class ManipAndPhController extends UserController {
    Login user;
    Dashboard dashboard;
    AjouterExamen addExam;
    RecherchePatientMedecin rp;
    DossierPatient dp;
    CompleterExamen ce;
    CompleterExamenListe cr;
    AfficherExamen ae;
    RequetesSQL sql;
    String error = "";
    String success = "";
    
    public ManipAndPhController(Login user) throws ClassNotFoundException {
        this.user = user;
        sql = new RequetesSQL();
        dashboard = new Dashboard(user, this);
        dashboard.setVisible(true);
    }

    // GETTERS ET SETTERS
    
    public String getError() {
        return error;
    }
    
    public String getSuccess() {
        return success;
    }
    
    // DISPLAY VIEWS 
    
    public void displayRecherchePatient() throws SQLException {
        ArrayList<Patient> patients = sql.getPatients();
        rp = new RecherchePatientMedecin(user, this, patients);
        rp.setVisible(true);
    }
    
    public void displayDashboard() {
        dashboard = new Dashboard(user, this);
        dashboard.setVisible(true);
    }
    
    public void displayAddExam(Patient p) {
        String UID = generateUid();
        addExam = new AjouterExamen(p, user, this, UID);
        addExam.setVisible(true);
    }
    
    public void displayDossierPatient(String idPatient) throws SQLException {
        Patient p = sql.getPatientByCriteria("patientId", idPatient).get(0);
        ArrayList<Examen> e = sql.getListExamenByPatient(p.getPatientId());
        dp = new DossierPatient(user, p, this, e);
        dp.setVisible(true);
    }
    
    public void displayCompleteExam(String examId) throws SQLException {
        Examen e = sql.getExamenById(examId);
        Patient p = sql.getPatientFromExam(e.getExamId());
        ce = new CompleterExamen(user, p, this, e);
        ce.setVisible(true);
    }

    public void displayListExamToComplete() throws SQLException {
        ArrayList<Examen> exams = sql.getExamensIncomplete();
        ArrayList<Patient> patients = new ArrayList<>();
        for(int i = 0; i< exams.size(); i++) {
            patients.add(sql.getPatientFromExam(exams.get(i).getExamId()));
        }
        cr = new CompleterExamenListe(this, user, exams, patients);
        cr.setVisible(true);
    }
    
    public void displayExam(String examId) throws SQLException {
        Examen e = sql.getExamenById(examId);
        Patient p = sql.getPatientFromExam(e.getExamId());
        ae = new AfficherExamen(this, user, e, p);
        ce.setVisible(true);
    }
    
    // RECHERCHE ET AJOUT EN BD    
    public ArrayList<Patient> recherchePatient(String critere, String recherche) throws SQLException {
    
        ArrayList<Patient> patients = null;
        if (recherche.equals("recherche selon le critère selectionné") || recherche.equals("")) {
            error = "Veuillez entrer une recherche";
        } else {
            error = "";
            patients = sql.getPatientByCriteria(critere, recherche);
        }
        return patients;
    }
    
    public void ajouterExam(Examen e) throws SQLException {
        try {
            sql.addExamen(e);
            success = "Examen enregistré";
        } catch(SQLException error) {
            this.error = error.getMessage();
        }
    }
    
    //A appeler dans le constructeur de l'interface chercher patient
    public ArrayList<Patient> afficherListePatient() throws SQLException {
        ArrayList<Patient> liste = new ArrayList<>();
        liste = sql.getPatients();
        return liste;
    }

    //A appeler quand on clique sur le bouton rechercher un patient
    public ArrayList<Patient> afficherListePatientAvecCritere(String critere, String recherche) throws SQLException {
        ArrayList<Patient> liste = new ArrayList<>();
        liste = (ArrayList<Patient>) sql.getPatientByCriteria(critere, recherche);
        return liste;
    }

    public void updateExam(Examen e, String report) throws SQLException {
        sql.addReport(e.getExamId(), report);
    }
    
    public ArrayList<Pacs> afficherListeImages(String idExam) throws SQLException {
        return sql.getImagesFromExam(idExam);
        
    }

    public void addImage(FileInputStream in, String idExam) throws SQLException {
        String uid = UUID.randomUUID().toString().replace("-","").substring(0,10);
        Pacs pacs = new Pacs(uid, idExam, "image" );
        sql.addImageToPacs(in, pacs);
    }
    

    




}