package Controleur;

import ConnexionBD.RequetesSQL;
import Modele.Examen;
import Modele.Login;
import Modele.Patient;
import Vue.AjouterExamen;
import Vue.Dashboard;
import Vue.DashboardSecretaire;
import Vue.DossierPatient;
import Vue.RecherchePatientMedecin;
import java.sql.SQLException;
import java.util.ArrayList;

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
        dp = new DossierPatient(user, p, this);
        dp.setVisible(true);
    }

    // RECHERCHE ET AJOUT EN BD
    
    public void recherchePatient(String critere, String recherche) throws SQLException {
    
        if (recherche.equals("recherche selon le critère selectionné") || recherche.equals("")) {
            error = "Veuillez entrer une recherche";
        } else {
            error = "";
            ArrayList<Patient> patients = sql.getPatientByCriteria(critere, recherche);
            rp.updatePatients(patients);
        }
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


}