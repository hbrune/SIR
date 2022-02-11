package Controleur;

import ConnexionBD.RequetesSQL;
import Modele.Login;
import Modele.Patient;
import Vue.Dashboard;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
@ -12,9 +17,28 @@ import Modele.Login;
 */
public class ManipAndPhController {
    Login user;
    Dashboard dashboard;
    RequetesSQL sql;
    
    public ManipAndPhController(Login user) throws ClassNotFoundException {
        this.user = user;
        sql = new RequetesSQL();
        dashboard = new Dashboard(user);
        dashboard.setVisible(true);
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