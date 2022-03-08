package ConnexionBD;
    
import Modele.Login;
import Modele.Patient;
import Modele.Examen;
import Modele.Pacs;
import java.io.FileInputStream;
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


public class RequetesSQL {
    //ajouter attribut connexion pour éviter de le mettre en paramètre à chaque fois
    //TUTORAT : Plusieurs controleurs, est-ce qu'on crée une nouvelle connexion à chaque fois, ou on peut créer un objet requeteSQL (qui crée une connexion) 
    //au début qui va être utilisé dans chaque controleur ? 
    DatabaseAccessProperties dap;
    static Connection conn;
/*
* @param conn connexion � la base de donn�es
* @throws SQLException en cas d'erreur d'acc�s � la 
base de donn�es
*/
    
    public RequetesSQL() throws ClassNotFoundException {
        dap = new DatabaseAccessProperties();
        conn = dap.getConn();
    }
    
    public boolean verifierPatient(Patient p) throws SQLException {
        //Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        
        //Execute the query
        java.sql.Date ddnSql = new java.sql.Date(p.getDdn().getTime());
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PATIENT where lastNameP = '" + p.getLastNameP().toLowerCase() + "' and firstNameP = '" + p.getFirstNameP().toLowerCase() + "' and birthDate = TO_DATE('" + ddnSql + "', 'YYYY-MM-DD')");
        
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
    
    public void addPatient(Patient patient) throws SQLException {
        //Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        //Execute the query
        java.sql.Date ddnSql = new java.sql.Date(patient.getDdn().getTime());
        ResultSet rsTest = stmt.executeQuery("INSERT INTO PATIENT VALUES ('" + patient.getPatientId().toLowerCase() + "', '" + patient.getLastNameP().toLowerCase() + "', '" + patient.getFirstNameP().toLowerCase() + "', '" + patient.getAdress().toLowerCase() + "', '" + patient.getGender() + "', TO_DATE('" + ddnSql + "', 'YYYY-MM-DD'))");
        rsTest.close() ;
        stmt.close() ;
    }
            
    public void addUser(Login login) throws SQLException {
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("INSERT INTO LOGIN (proId, password, lastName, firstName, function) VALUES ('" + login.getIdLogin() + "', '" + login.getPassword() + "', '" + login.getLastName() + "', '" + login.getFirstName() + "', " + login.getFunction() + ")");
        
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
    }
    
    public Login authentification(String proId, String password) throws SQLException {
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM LOGIN where proId = '" + proId + "' and password = '" + password + "'") ;
        // Préparation des résultats
        Login user = null;
        String id = "";
        String pwd = "";
        String nom = "";
        String prenom = "";
        int fonction;
        
        try {
            while(rsTest.next()) { 
                id = rsTest.getString(1);
                password = rsTest.getString(2);
                nom = rsTest.getString(3);
                prenom = rsTest.getString(4);
                fonction = rsTest.getInt(5);
                System.out.println("Votre login est correct ! Bienvenue " + rsTest.getString(4));
                user = new Login(id, pwd, nom, prenom, fonction);
                
            }
        }
        finally {
            if(user == null) {
                System.out.println("Votre login est incorrect...");
            }
        }
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        //On retourne l'utilisateur qui se connecte
        return user;
    }
   
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
    
    //Récupérer TOUS les patients
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
    
    public void recherchePatientByCriteria(String critere, String recherche) throws SQLException {
        
        // Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PATIENT where " + critere + "= '" + recherche + "'") ;
        while(rsTest.next()) { 
            System.out.println(rsTest);
            System.out.println("Id du patient : " + rsTest.getString(1));
        }
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
    }

    public void recherchePatientByDdn(String critere, String recherche) throws SQLException {
        
        // Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PATIENT where birthDate = '" + recherche + "'") ;
        while(rsTest.next()) { 
            System.out.println(rsTest);
            System.out.println("Id du patient : " + rsTest.getString(1));
        }
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
    }
    
    public void addExamen(Examen e) throws SQLException {
        
        //Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        
        //Execute the query
        java.sql.Timestamp ddnSql = new java.sql.Timestamp(e.getDate().getTime());
        System.out.println(ddnSql);
        ResultSet rsTest = stmt.executeQuery("INSERT INTO EXAM VALUES ('" + e.getExamId() + "', '" + e.getPatientId() + "', '" + e.getProId() + "', '" + e.getProIdReport() +  "', '" + e.getType() + "', '" + e.getReport() + "', CURRENT_TIMESTAMP, " + e.getStatus() +")");

        rsTest.close() ;
        stmt.close() ;
        
    }
    
    public void addReport(String examId, String report) throws SQLException {
        
        //Get a statement from the connection
        Statement stmt = dap.getConn().createStatement() ;
        
        //Execute the query
        ResultSet rsTest = stmt.executeQuery("UPDATE EXAM SET report = '" + report + "', status = 1 WHERE examId = '" + examId +"'") ;
        
        rsTest.close() ;
        stmt.close() ;
        
    }
    
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
    
    public ArrayList<Examen> getListExamenByPatient(String idP) throws SQLException {    
        
        ArrayList<Examen> examsP = new ArrayList<>();
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM EXAM where patientId = '" + idP + "'") ;
        
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
    public void addImageToPacs(FileInputStream img, Pacs pacs) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO PACS VALUES(?, ?, ?)");
        pstmt.setString(1, pacs.getIdPacs());
        pstmt.setString(2, pacs.getIdExam());
        pstmt.setBlob(3, img);
        pstmt.execute();
    }
    
    public ArrayList<Pacs> getImagesFromExam(String idExam) throws SQLException {
        ArrayList<Pacs> imagesE = new ArrayList<>();
        Pacs p = null;
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PACS WHERE EXAMID = '" + idExam + "'") ;
        String idPacs = "";
        String img = "";
        
        while(rsTest.next()) {
            if(idExam.equals(rsTest.getString(2).trim())) {
                idPacs = rsTest.getString(1);
                img = rsTest.getBlob(3).toString();
                p = new Pacs(idPacs, idExam, img);
                imagesE.add(p);
            }
        }        
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return imagesE;
    }
}