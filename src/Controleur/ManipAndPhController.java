package Controleur;

import ConnexionBD.RequetesSQL;
import Modele.Login;
import Modele.Patient;
import Vue.Dashboard;
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
    RequetesSQL sql;
    String error = "";
    String success = "";
    RecherchePatientMedecin rp;
    
    public ManipAndPhController(Login user) throws ClassNotFoundException {
        this.user = user;
        sql = new RequetesSQL();
        dashboard = new Dashboard(user);
        dashboard.setVisible(true);
    }

    // GETTERS ET SETTERS
    
    public String getError() {
        return error;
    }
    
    public String getSuccess() {
        return success;
    }
    
    // RECHERCHE ET AJOUT EN BD
    
    public void recherchePatient(String critere, String recherche) throws SQLException {
    
        //recherchePatientByCriteria(critere, recherche);
        if (recherche.equals("recherche selon le critère selectionné") || recherche.equals("")) {
            error = "Veuillez entrer une recherche";
        } else {
            error = "";
            ArrayList<Patient> patients = sql.getPatientByCriteria(critere, recherche);
            rp.updatePatients(patients);
            
            System.out.println(patients.size());
            
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