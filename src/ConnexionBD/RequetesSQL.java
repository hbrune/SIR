package ConnexionBD;
    
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RequetesSQL {
/*
* @param conn connexion � la base de donn�es
* @throws SQLException en cas d'erreur d'acc�s � la 
base de donn�es
*/
    public static void authentification(Connection conn, String proId, String password) throws SQLException {
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM LOGIN where proId = '" + proId + "' and password = '" + password + "'") ;
        while(rsTest.next()) { 
            System.out.println(rsTest);
            Modele.Login m = new Modele.Login(rsTest.getString(1),rsTest.getString(2),rsTest.getString(3),rsTest.getString(4),rsTest.getInt(5)); 
            System.out.println("Votre login est correct !");
        }
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
    }
   
    public static void recherchePatient(Connection conn, String lastNameP) throws SQLException {
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT * FROM PATIENT where lastNameP = '" + lastNameP + "'") ;
        while(rsTest.next()) { 
            System.out.println(rsTest);
            System.out.println("Id du patient : " + rsTest.getString(1));
        }
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
    }
}