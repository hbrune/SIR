package Controleur;

import Vue.CompleterExamenListe;
import ConnexionBD.RequetesSQL;
import Modele.Examen;
import Modele.Login;
import Modele.Pacs;
import Modele.Patient;
import Vue.AfficherExamen;
import Vue.AfficherExamenPapier;
import Vue.AjouterExamen;
import Vue.AjouterImagesNumerisees;
import Vue.CompleterExamen;
import Vue.Dashboard;
import Vue.DashboardSecretaire;
import Vue.DossierPatient;
import Vue.RecherchePatientMedecin;
import Vue.TraitementImage;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
@ -12,9 +17,28 @@ import Modele.Login;
 */
public class ManipAndPhController extends UserController {
    Dashboard dashboard;
    AjouterExamen addExam;
    RecherchePatientMedecin rp;
    DossierPatient dp;
    CompleterExamen ce;
    CompleterExamenListe cr;
    AfficherExamen ae;
    AfficherExamenPapier aep;
    AjouterImagesNumerisees ain;
    TraitementImage ti;    
    RequetesSQL sql;
    
    /**
    *Afficher l'interface d'accueil propre à l'utilisateur connecté (manipulateur radio ou praticien hospitalier), crée une instance de RequeteSQL permettant les échanges avec la base de données.
    *@param user : utilisateur connecté (secrétaire)
    *@throws ClassNotFoundException 
    */
    public ManipAndPhController(Login user) throws ClassNotFoundException {
        this.user = user;
        sql = new RequetesSQL();
        dashboard = new Dashboard(user, this);
        dashboard.setVisible(true);
    }

    // DISPLAY VIEWS 
    /**
    *Afficher l'interface d'accueil propre à l'utilisateur connecté (manipulateur radio ou praticien hospitalier)
    */
    public void displayDashboard() {
        dashboard = new Dashboard(user, this);
        dashboard.setVisible(true);
    }
    
    
    /**
    *Afficher l'interface de recherche patient
    *Recherche en base de données de tous les patients enregistrés en base de données pour les afficher
    *@throws SQLException
    */
    public void displayRecherchePatient() throws SQLException {
        ArrayList<Patient> patients = sql.getPatients();
        rp = new RecherchePatientMedecin(user, this, patients);
        rp.setVisible(true);
    }
    
    /**
    * Afficher le dossier du patient sélectionné, identifié par son identifiant
    * Recherche en base de données des examens enregistrés pour ce patient
    * @param idPatient : identifiant du patient pour le rechercher en base de données
    * @throws SQLException
    */
    public void displayDossierPatient(String idPatient) throws SQLException {
        Patient p = sql.getPatientByCriteria("patientId", idPatient).get(0);
        ArrayList<Examen> e = sql.getListExamenByPatient(p.getPatientId());
        dp = new DossierPatient(user, p, this, e);
        dp.setVisible(true);
    }
    
    /**
    * Afficher l'interface d'ajout d'examen
    * Génère un identifiant unique et vérifie qu'il n'est pas déjà utilisé
    * @param p : patient pour lequel un examen est créé
    *Recherche en base de données de tous les patients enregistrés en base de données pour les afficher
    */
    public void displayAddExam(Patient p) {
        String UID = generateUid();
        addExam = new AjouterExamen(p, user, this, UID);
        addExam.setVisible(true);
    }
    
    
    public void displayCompleteExam(String examId) throws SQLException {
        Examen e = sql.getExamenById(examId);
        Patient p = sql.getPatientFromExam(e.getExamId());
        ArrayList<Pacs> images = new ArrayList<>();
        if (sql.isExamenDigital(e)) {
            try {
                images = sql.getImagesFromExam(examId);
                ce = new CompleterExamen(user, p, this, e, images);
            } catch (IOException ex) {
                Logger.getLogger(ManipAndPhController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ce = new CompleterExamen(user, p, this, e);
        }        
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
    
    public void displayExam(String examId) throws SQLException, IOException {
        Examen e = sql.getExamenById(examId);
        Patient p = sql.getPatientFromExam(e.getExamId());
        Login reportMedecin = sql.getProById(e.getProIdReport());
        if (sql.isExamenDigital(e)) {
            try{
                ArrayList<Pacs> images = sql.getImagesFromExam(e.getExamId());
                System.out.println(images.size());
                ae = new AfficherExamen(this, user, e, p, reportMedecin, images);
                ae.setVisible(true);
            } catch(SQLException error) {
                System.out.println(error.getMessage());
            }
            
        } else {
            aep = new AfficherExamenPapier(this, user, e, p, reportMedecin);
            aep.setVisible(true);
        }
    }
    
    public void displayAddImagesToExam(Examen e, Patient p) {
        ain = new AjouterImagesNumerisees(this, user, e, p, new ArrayList<GestionImage.Image>());
        ain.setVisible(true);
    }
    
    public void displayTraiterImage(GestionImage.Image img, AjouterImagesNumerisees ain, boolean status) throws IOException {
        ti = new TraitementImage(this, img, this.ain, status);
        ti.setVisible(true);
    }
    
    public void displayAddImageToExam(Examen e, Patient p, ArrayList<GestionImage.Image> images) throws SQLException {
        ain = new AjouterImagesNumerisees(this, user, e, p, images);
        ain.setVisible(true);
    }
    // RECHERCHE ET AJOUT EN BD    
    

    public void ajouterExam(Examen e) throws SQLException {
        try {
            sql.addExamen(e);
        } catch(SQLException error) {
            this.error = error.getMessage();
        }
    }
  

    //A appeler quand on clique sur le bouton rechercher un patient
    public ArrayList<Patient> afficherListePatientAvecCritere(String critere, String recherche) throws SQLException {
        ArrayList<Patient> liste = new ArrayList<>();
        liste = (ArrayList<Patient>) sql.getPatientByCriteria(critere, recherche);
        return liste;
    }

    
    public void updateExam(Examen e, String report, Login user) throws SQLException {
        sql.addReport(e.getExamId(), report, user);
    }
    
    public ArrayList<Examen> getExams(String type, Patient p) {
        ArrayList<Examen> exams = new ArrayList<>();
        if(type.equals("digital")) {
            try {
                exams = sql.getDigitalExams(p);
            } catch (SQLException ex) {
                Logger.getLogger(ManipAndPhController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                exams = sql.getPaperExams(p);
            } catch (SQLException ex) {
                Logger.getLogger(ManipAndPhController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return exams;
    }
    
    public ArrayList<Pacs> afficherListeImages(String idExam) throws SQLException, IOException {
        return sql.getImagesFromExam(idExam);
        
    }

    public void addImage(Image in, String idExam) throws SQLException, IOException {
        String uid = UUID.randomUUID().toString().replace("-","").substring(0,10);
        Pacs pacs = new Pacs(uid, idExam, in );
        try {
            sql.addImageToPacs(in, pacs);
        } catch (SQLException ex) {
                Logger.getLogger(ManipAndPhController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }   
}