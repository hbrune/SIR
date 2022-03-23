package ConnexionBD;
    
import Modele.Demande;
import Modele.Login;
import Modele.Patient;
import Modele.Examen;
import Securite.Encryption;
import Securite.Salt;
import Modele.Pacs;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class RequetesSQL {
    //ajouter attribut connexion pour éviter de le mettre en paramètre à chaque fois
    //TUTORAT : Plusieurs controleurs, est-ce qu'on crée une nouvelle connexion à chaque fois, ou on peut créer un objet requeteSQL (qui crée une connexion) 
    //au début qui va être utilisé dans chaque controleur ? 
    DatabaseAccessProperties dap;
    static Connection conn;
   
    public RequetesSQL() throws ClassNotFoundException {
        dap = new DatabaseAccessProperties();
        conn = dap.getConn();
    }
    
    /**
    *Vérifier l'existence d'un patient dans la base de données
    *@param p : patient dont l'existence veut être vérifiée
    *@throws SQLException 
    *@return : boolean true si patient existe déjà et boolean false s'il n'existe pas
    */
    public boolean verifierPatient(Patient p) throws SQLException {
        //Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        
        //Execute the query
        java.sql.Date ddnSql = new java.sql.Date(p.getDdn().getTime());
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PATIENT where lastNameP = '" + gestionApostrophe(p.getLastNameP().toLowerCase()) + "' and firstNameP = '" + p.getFirstNameP().toLowerCase() + "' and birthDate = TO_DATE('" + ddnSql + "', 'YYYY-MM-DD')");
        
        Patient patient = null;
        String patientId = "";
        String lastNameP = "";
        String firstNameP = "";
        String address = "";
        String gender = "";
        Date birthDate;
        boolean verifPatient = false;
         
        while(rsTest.next()) { 
            patientId = rsTest.getString(1);
            lastNameP = rsTest.getString(2);
            firstNameP = rsTest.getString(3);
            address = rsTest.getString(4);
            gender = rsTest.getString(5);
            birthDate = rsTest.getDate(6);   
            patient = new Patient(patientId, lastNameP, firstNameP, address, gender, birthDate);  
        }
        if(patient != null) {
            verifPatient = true;
        }   
         
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        
        return verifPatient;
    }
    
    /**
    *Ajouter un patient dans la base de données
    *@param p : patient que l'on veut ajouter
    *@throws SQLException 
    */
    public void addPatient(Patient patient) throws SQLException {
        //Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        //Execute the query
        String id = patient.getPatientId().toLowerCase();
        String nom = gestionApostrophe(patient.getLastNameP().toLowerCase());
        String prenom = gestionApostrophe(patient.getFirstNameP().toLowerCase());  
        String adresse = gestionApostrophe(patient.getAdress().toLowerCase());
        String sexe = patient.getGender();
        java.sql.Date ddnSql = new java.sql.Date(patient.getDdn().getTime());
        ResultSet rsTest = stmt.executeQuery("INSERT INTO PATIENT VALUES ('" + id + "', '" + nom + "', '" + prenom + "', '" + adresse + "', '" + sexe + "', TO_DATE('" + ddnSql + "', 'YYYY-MM-DD'))");
        rsTest.close() ;
        stmt.close() ;
    }
      
    /**
    *Ajouter un professionnel de santé dans la base de données
    *@param login : professionnel de santé que l'on veut ajouter
    *@throws SQLException 
    */
    public void addUser(Login login) throws SQLException {
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("INSERT INTO LOGIN (proId, password, lastName, firstName, function) VALUES ('" + login.getIdLogin() + "', '" + login.getPassword() + "', '" + login.getLastName() + "', '" + login.getFirstName() + "', " + login.getFunction() + ")");
        
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
    }
    
    /**
    *Vérifier l'id et mot de passe du professionel de santé
    *@param proId : id du professionnel de santé
    *@param password : mot de passe du professionnel de santé
    *@throws SQLException 
    *@return : Login non null si id et mot de passe sont valides et login null si id et mot de passe ne sont pas valides
    */
    public Login authentification(String proId, String password) throws SQLException {
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM LOGIN where proId = '" + proId + "'") ;
        
        // Préparation des résultats
        String id = "";
        String key = "";
        boolean pwd;
        String nom = "";
        String prenom = "";
        int fonction;
        Login user = null;
        
        
        while(rsTest.next()) {
            id = rsTest.getString(1);
            key = rsTest.getString(2).trim();
            pwd = Encryption.verifyPassword(password, key, Salt.salt);
            System.out.println(password);
            System.out.println(pwd);
            nom = rsTest.getString(3);
            prenom = rsTest.getString(4);
            fonction = rsTest.getInt(5);
            if(pwd == false) {
                System.out.println("Votre login est incorrect...");
            }
            else{
                user = new Login(id, password, nom, prenom, fonction);
                System.out.println("Votre login est correct ! Bienvenue " + rsTest.getString(4));
            }
        }  
        
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        
        return user;
    }
   
    /**
    *Récupérer un patient grâce à son id
    *@param id : id du patient
    *@throws SQLException 
    *@return : patient possédant l'id mis en paramètre
    */
    public Patient getPatientById(String id) throws SQLException {    
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PATIENT where patientId = '" + id + "'") ;
        
        Patient pat = null;
        String idP = "";
        String lastNameP = "";
        String firstNameP = "";
        String adressP = "";
        String genderP = "";
        Date ddnP = null;
        
        
        while(rsTest.next()) {
            //remplir les infos du patient avec les résultats de la requête
                idP = rsTest.getString(1);
                lastNameP = rsTest.getString(2);
                firstNameP = rsTest.getString(3);
                adressP = rsTest.getString(4);
                genderP = rsTest.getString(5);
                ddnP = rsTest.getDate(6);             
                pat = new Patient(idP, lastNameP, firstNameP, adressP, genderP, ddnP);
        }
        
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return pat;
    }
    
    /**
    *Récupérer tous les patients
    *@throws SQLException 
    *@return : liste de patients
    */
    public ArrayList<Patient> getPatients() throws SQLException {
        ArrayList<Patient> patients = new ArrayList<>();
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PATIENT") ;
        
        //Boucle pour chaque patient
        while(rsTest.next()) {
            Patient patCourant = null;
            String id = rsTest.getString(1);
            String name = rsTest.getString(2);
            String surname = rsTest.getString(3);
            String adress = rsTest.getString(4);
            String gender = rsTest.getString(5);
            Date ddn = rsTest.getDate(6);
            
            patCourant = new Patient(id, name, surname, adress, gender, ddn);
            
            //Ajouter le patient à la liste
            patients.add(patCourant);
        }      
          
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return patients;
    }
    
    /**
    *Récupérer tous les patients qui remplissent un critère précis
    *@param critere : nom de l'attribut correspondant au critère de recherche
    *@param recherche : valeur de l'attibut correspondant au critère de recherche
    *@throws SQLException 
    *@return : liste de patients remplissant un critère
    */
    public ArrayList<Patient> getPatientByCriteria(String critere, String recherche) throws SQLException {
        ArrayList<Patient> patients = new ArrayList<>();
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PATIENT WHERE " + critere + " = '" + recherche +  "'") ;
        
        //Boucle pour chaque patient
        while(rsTest.next()) {
            Patient patCourant = null;
            String id = rsTest.getString(1);
            String name = rsTest.getString(2);
            String surname = rsTest.getString(3);
            String adress = rsTest.getString(4);
            String gender = rsTest.getString(5);
            Date ddn = rsTest.getDate(6);
            
            patCourant = new Patient(id, name, surname, adress, gender, ddn);
            
            //Ajouter le patient à la liste
            patients.add(patCourant);
        }       
          
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return patients;
    }

    /**
    *Récupérer tous les patients qui ont une date de naissance précise
    *@param ddn : date de naissance 
    *@throws SQLException 
    *@return : liste de patients ayant une même date de naissance
    */
    public ArrayList<Patient> recherchePatientByDdn(Date ddn) throws SQLException {
        ArrayList<Patient> patients = new ArrayList<>();
        Statement stmt = dap.getConn().createStatement();
        java.sql.Date ddnSql = new java.sql.Date(ddn.getTime());
        System.out.println(ddnSql);
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PATIENT where birthDate = TO_DATE('" + ddnSql + "', 'YYYY-MM-DD')") ;
        while(rsTest.next()) { 
            Patient patCourant = null;
            String id = rsTest.getString(1);
            String name = rsTest.getString(2);
            String surname = rsTest.getString(3);
            String adress = rsTest.getString(4);
            String gender = rsTest.getString(5);
            Date date = rsTest.getDate(6);
            System.out.println(date);
            patCourant = new Patient(id, name, surname, adress, gender, ddn);
            //Ajouter le patient à la liste
            if(patCourant != null) {
                patients.add(patCourant);   
            }
        }
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return patients;
    }
    
    // USERS
    
    /**
    *Récupérer un professionnel de santé grâce à son id
    *@param id : id du professionnel de santé
    *@throws SQLException 
    *@return : professionnel de santé possédant l'id mis en paramètre
    */
    public Login getProById(String id) throws SQLException {    
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM LOGIN where proId = '" + id + "'") ;
        
        Login user = null;
        String idU = "";
        String lastNameU = "";
        String firstNameU = "";
        String password = "";
        int role = 0;
        
        
        while(rsTest.next()) {
            //remplir les infos du patient avec les résultats de la requête
                idU = rsTest.getString(1);
                password = rsTest.getString(2);
                lastNameU = rsTest.getString(3);
                firstNameU = rsTest.getString(4);
                role = rsTest.getInt(5);             
                user = new Login(idU, password, lastNameU, firstNameU, role);
        }
        
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return user;
    }
    
    //EXAMENS
    
    /**
    *Ajouter un examen à la base de données
    *@param e : examen
    *@throws SQLException 
    */
    public void addExamen(Examen e) throws SQLException {
        
        //Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        
        //Execute the query
        java.sql.Timestamp ddnSql = new java.sql.Timestamp(e.getDate().getTime());
        String report = gestionApostrophe(e.getReport());
        System.out.println(report);
        ResultSet rsTest = stmt.executeQuery("INSERT INTO EXAM VALUES ('" + e.getExamId() + "', '" + e.getPatientId() + "', '" + e.getProId() + "', '" + e.getProId() +  "', '" + e.getType() + "', '" + report + "', CURRENT_TIMESTAMP, " + e.getStatus() +")");

        rsTest.close() ;
        stmt.close() ;
        
    }
    
    /**
    *Récupérer un examen grâce à son id
    *@param id : id de l'examen
    *@throws SQLException 
    *@return : examen possédant l'id mis en paramètre
    */
    public Examen getExamenById(String id) throws SQLException {    
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;

        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM EXAM where examId = '" + id + "'") ;

        Examen e = null;
        String examId = "";
        String patientId = "";
        String proId = "";
        String proIdReport = "";
        String type;
        String report = "";
        Date date = null;
        int status;

        while(rsTest.next()) {
                examId = rsTest.getString(1);
                patientId = rsTest.getString(2);
                proId = rsTest.getString(3);
                proIdReport = rsTest.getString(4);
                type = rsTest.getString(5);
                report = rsTest.getString(6);
                date = rsTest.getDate(7);    
                status = rsTest.getInt(8);
                e = new Examen(examId, patientId, proId, proIdReport, type, report, date, status);
        }

        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return e;
    }
    
    /**
    *Récupérer tous les examens d'un patient précis à l'aide de son id
    *@param idP : id d'un patient
    *@throws SQLException 
    *@return : liste d'examens du patient identifié 
    */
    public ArrayList<Examen> getListExamenByPatient(String idP) throws SQLException {    
        
        ArrayList<Examen> examsP = new ArrayList<>();
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM EXAM where status = 1 and patientId = '" + idP + "'") ;
        
        Examen e = null;
        String examId = "";
        String patientId = "";
        String proId = "";
        String proIdReport = "";
        String type;
        String report = "";
        Date date = null;
        int status;
        
        while(rsTest.next()) {
                examId = rsTest.getString(1);
                patientId = rsTest.getString(2);
                proId = rsTest.getString(3);
                proIdReport = rsTest.getString(4);
                type = rsTest.getString(5);
                report = rsTest.getString(6);
                date =  rsTest.getDate(7);    
                status = rsTest.getInt(8);
                e = new Examen(examId, patientId, proId, proIdReport, type, report, date, status);
                examsP.add(e);
        }
        
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return examsP;
    }
    
    /**
    *Vérifier si un patie
    *@param ddn : date de naissance 
    *@throws SQLException 
    *@return : liste de patients ayant une même date de naissance
    */
    //examens numérique et non numériques
    public boolean isExamenDigital(Examen e) throws SQLException {
        boolean digital = false;
        //Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        
        //Execute the query
        java.sql.Timestamp ddnSql = new java.sql.Timestamp(e.getDate().getTime());
        System.out.println(ddnSql);
        ResultSet rsTest = stmt.executeQuery("SELECT COUNT(*) FROM PACS WHERE EXAMID = '" + e.getExamId() + "'");
        while(rsTest.next()) { 
            if (rsTest.getInt(1)>0) {
                digital = true;
            }
        }     
        rsTest.close() ;
        stmt.close() ;
        return digital;
    }
    
   
    public ArrayList<Examen> getDigitalExams(Patient p) throws SQLException {
        ArrayList<Examen> exams = new ArrayList<>();
        String idPatient = p.getPatientId();
        //Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        
        //Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM EXAM WHERE STATUS = 1 and PATIENTID = '" + idPatient + "' AND EXAMID IN (SELECT EXAMID FROM PACS)");
        Examen e = null;
        String examId = "";
        String patientId = "";
        String proId = "";
        String proIdReport = "";
        String type;
        String report = "";
        Date date = null;
        int status;
        
        while(rsTest.next()) {
                examId = rsTest.getString(1);
                patientId = rsTest.getString(2);
                proId = rsTest.getString(3);
                proIdReport = rsTest.getString(4);
                type = rsTest.getString(5);
                report = rsTest.getString(6);
                date =  rsTest.getDate(7);    
                status = rsTest.getInt(8);
                e = new Examen(examId, patientId, proId, proIdReport, type, report, date, status);
                exams.add(e);
        }
            
        rsTest.close() ;
        stmt.close() ;
        return exams;
    }
    
    public ArrayList<Examen> getPaperExams(Patient p) throws SQLException {
        ArrayList<Examen> exams = new ArrayList<>();
        String idPatient = p.getPatientId();
        //Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        
        //Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM EXAM WHERE STATUS = 1 AND PATIENTID = '" + idPatient + "' AND EXAMID NOT IN (SELECT EXAMID FROM PACS)");
        Examen e = null;
        String examId = "";
        String patientId = "";
        String proId = "";
        String proIdReport = "";
        String type;
        String report = "";
        Date date = null;
        int status;
        
        while(rsTest.next()) {
                examId = rsTest.getString(1);
                patientId = rsTest.getString(2);
                proId = rsTest.getString(3);
                proIdReport = rsTest.getString(4);
                type = rsTest.getString(5);
                report = rsTest.getString(6);
                date =  rsTest.getDate(7);    
                status = rsTest.getInt(8);
                e = new Examen(examId, patientId, proId, proIdReport, type, report, date, status);
                exams.add(e);
        }
            
        rsTest.close() ;
        stmt.close() ;
        return exams;
    }
    
    public void addReport(String examId, String report, Login user) throws SQLException {
        
        //Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        
        //Execute the query
        report = gestionApostrophe(report);
        System.out.println(report);
        ResultSet rsTest = stmt.executeQuery("UPDATE EXAM SET report = '" + report + "', proidreport = '" + user.getIdLogin() + "' , status = 1 WHERE examId = '" + examId +"'") ;
        
        rsTest.close() ;
        stmt.close() ;
        
    }
    

    
    public ArrayList<Examen> getExamensIncomplete() throws SQLException {    
        
        ArrayList<Examen> examsP = new ArrayList<>();
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM EXAM WHERE status = 0");
        Examen e = null;
        String examId = "";
        String patientId = "";
        String proId = "";
        String proIdReport = "";
        String type;
        String report = "";
        Date date = null;
        int status;
        
        while(rsTest.next()) {
                examId = rsTest.getString(1);
                patientId = rsTest.getString(2);
                proId = rsTest.getString(3);
                proIdReport = rsTest.getString(4);
                type = rsTest.getString(5);
                report = rsTest.getString(6);
                date =  rsTest.getDate(7);    
                status = rsTest.getInt(8);
                e = new Examen(examId, patientId, proId, proIdReport, type, report, date, status);
                examsP.add(e);
        }
        
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return examsP;
    }

    public Patient getPatientFromExam(String idExam) throws SQLException {
        Patient p = null;
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT PATIENTID, LASTNAMEP, FIRSTNAMEP, ADRESS, GENDER, BIRTHDATE FROM PATIENT NATURAL JOIN EXAM WHERE EXAMID = '" + idExam + "'") ;

        String idP = "";
        String lastNameP = "";
        String firstNameP = "";
        String adressP = "";
        String genderP = "";
        Date ddnP = null;
        
        while(rsTest.next()) {
                idP = rsTest.getString(1);
                lastNameP = rsTest.getString(2);
                firstNameP = rsTest.getString(3);
                adressP = rsTest.getString(4);
                genderP = rsTest.getString(5);
                ddnP = rsTest.getDate(6);             
                p = new Patient(idP, lastNameP, firstNameP, adressP, genderP, ddnP);
        }
        
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return p;
    }
    
    //GESTION D'IMAGES
    public void addImageToPacs(Image img, Pacs pacs) throws SQLException, IOException {
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO PACS VALUES(?, ?, ?)");
        pstmt.setString(1, pacs.getIdPacs());
        pstmt.setString(2, pacs.getIdExam());
        
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage) img,"png", os); 
        InputStream in = new ByteArrayInputStream(os.toByteArray());
        
        pstmt.setBlob(3, in);
        pstmt.execute();
    }
    
    public ArrayList<Pacs> getImagesFromExam(String idExam) throws SQLException, IOException {
        ArrayList<Pacs> imagesE = new ArrayList<>();
        Pacs p = null;
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PACS WHERE EXAMID = '" + idExam + "'") ;
        System.out.println(rsTest.getRow());
        String idPacs = "";
        InputStream is = null;
        
        while(rsTest.next()) {
            idPacs = rsTest.getString(1);
            System.out.println(idPacs);
            is = rsTest.getBlob(3).getBinaryStream();
            Image img = ImageIO.read(is);
            p = new Pacs(idPacs, idExam, img);
            imagesE.add(p);
        }        
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return imagesE;
    }
    
    public Pacs getImageFromId(String idPacs) throws SQLException, FileNotFoundException, IOException {
        Pacs p = null;
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest ;
        String idExam = "";
        //Blob img = null;
        
        try {
            rsTest = stmt.executeQuery("SELECT * FROM PACS WHERE PACSID = '" + idPacs + "'");
            while(rsTest.next()) {
                idPacs = rsTest.getString(1);
                idExam = rsTest.getString(2);
                InputStream is = rsTest.getBinaryStream(3);
                
                Image im = ImageIO.read(is);
                
                p = new Pacs(idPacs, idExam, im);
                
                
            }
            rsTest.close() ;
            stmt.close() ;
        } catch (SQLException ex) {
            Logger.getLogger(RequetesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
        
    }
    
    public void addDemande(Demande d) throws SQLException {
        //Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        //Execute the query
        java.sql.Date ddnSql = new java.sql.Date(d.getDdn().getTime());
        java.sql.Date dateSql = new java.sql.Date(d.getDdn().getTime());
        try {
            ResultSet rsTest = stmt.executeQuery("INSERT INTO DEMANDE VALUES ('" + d.getDemandeId().toLowerCase() + "', '" + d.getNomP().toLowerCase() + "', '" + d.getPrenomP().toLowerCase() + "', '" + d.getAdresse().toLowerCase() + "', '" + d.getSexe() + "', TO_DATE('" + ddnSql + "', 'YYYY-MM-DD'), '" + d.getTypeExam() + "', TO_DATE('" + dateSql + "', 'YYYY-MM-DD'), '" + d.getCommentaire() + "')");
            rsTest.close() ;
            stmt.close() ;
        } catch (SQLException ex) {
            Logger.getLogger(RequetesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public Demande getDemandeById(String id) throws SQLException {    
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;

        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM DEMANDE WHERE demandeId = '" + id + "'") ;

        Demande d = null;
        String demandeId = "";
        String nomP = "";
        String prenomP = "";
        String adresse = "";
        String sexe = "";
        Date ddn = null;
        String typeExam = "";
        Date dateP = null;
        String comment = "";

        while(rsTest.next()) {
                demandeId = rsTest.getString(1);
                nomP = rsTest.getString(2);
                prenomP = rsTest.getString(3);
                adresse = rsTest.getString(4);
                sexe = rsTest.getString(5);
                ddn = rsTest.getDate(6);
                typeExam = rsTest.getString(7);
                dateP = rsTest.getDate(8);    
                comment = rsTest.getString(9);
                d = new Demande(demandeId, nomP, prenomP, adresse, sexe, ddn, typeExam, dateP, comment);
        }
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return d;
    }
    
    public ArrayList<Demande> getDemandes() throws SQLException {
        ArrayList<Demande> demandes = new ArrayList<>();
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM DEMANDE") ;
        
        Demande dCourante = null;
        String demandeId = "";
        String nomP = "";
        String prenomP = "";
        String adresse = "";
        String sexe = "";
        Date ddn = null;
        String typeExam = "";
        Date dateP = null;
        String comment = "";
        
        //Boucle pour chaque patient
        while(rsTest.next()) {
            demandeId = rsTest.getString(1);
            nomP = rsTest.getString(2);
            prenomP = rsTest.getString(3);
            adresse = rsTest.getString(4);
            sexe = rsTest.getString(5);
            ddn = rsTest.getDate(6);
            typeExam = rsTest.getString(7);
            dateP = rsTest.getDate(8);    
            comment = rsTest.getString(9);
            dCourante = new Demande(demandeId, nomP, prenomP, adresse, sexe, ddn, typeExam, dateP, comment);
            
            //Ajouter le patient à la liste
            demandes.add(dCourante);
        }      
          
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return demandes;
    }
    
    public String gestionApostrophe(String string) {
        String[] tmp = string.split("'");
        String finalString = tmp[0];
        if(tmp.length > 1) {
            for (int i = 1 ; i < tmp.length ; i++) {
                finalString += "''" + tmp[i];
            }
        }
        //System.out.println("originale : " + string + " modifiée : " + finalString);
        return finalString;
    }
}