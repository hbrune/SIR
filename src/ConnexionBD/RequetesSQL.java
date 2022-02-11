package ConnexionBD;
    
import Modele.Login;
import Modele.Patient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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
    
   /* public static int getLastIdLogin() {
        //Pour ajouter un id qui n'existe pas 
    } */
            
    public void addUser(Login login) throws SQLException {
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("INSERT INTO LOGIN (proId, password, lastName, firstName, function) VALUES ('" + login.getIdLogin() + "', '" + login.getPassword() + "', '" + login.getLastName() + "', '" + login.getFirstName() + "'," + login.getFunction() + ") ");
        
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
                id = rsTest.getString(2);
                password = rsTest.getString(2);
                prenom = rsTest.getString(3);
                nom = rsTest.getString(4);
                fonction = rsTest.getInt(5);
                System.out.println("Votre login est correct ! Bienvenue " + rsTest.getString(3));
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
        String nameP = "";
        String surnameP = "";
        String adressP = "";
        String genderP = "";
        LocalDate ddnP = null;
        
        
        while(rsTest.next()) {
           
            //remplir les infos du patient avec les résultats de la requête
            
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
        /*while() {
            Patient patCourant = null;
            String id = "";
            String name = "";
            String surname = "";
            String adress = "";
            String gender = "";
            LocalDate ddn = null;


            while(rsTest.next()) { 
                System.out.println(rsTest);
                System.out.println("Id du patient : " + rsTest.getString(1));

                //remplir les infos du patient avec les résultats de la requête
            }
            patients.add(patCourant);
        }*/      
          
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return patients;
    }
    
    
    public List<Patient> getPatientByCriteria(String critere, String recherche) throws SQLException {
        ArrayList<Patient> patients = new ArrayList<>();
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PATIENT WHERE " + critere + " = '" + recherche +  "'") ;
        
        //Boucle pour chaque patient
        /*while() {
            Patient patCourant = null;
            String id = "";
            String name = "";
            String surname = "";
            String adress = "";
            String gender = "";
            LocalDate ddn = null;


            while(rsTest.next()) { 
                System.out.println(rsTest);
                System.out.println("Id du patient : " + rsTest.getString(1));

                //remplir les infos du patient avec les résultats de la requête
            }
            patients.add(patCourant);
        }*/      
          
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
        return patients;
    }
}