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
    public static void maBD(Connection conn) throws SQLException {
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        
        // Execute the query
        ResultSet rsTest = stmt.executeQuery("SELECT count(*) FROM LOGIN") ;
        while(rsTest.next()) { 
            System.out.println(rsTest);
            System.out.println("id des professionnels : " + rsTest.getInt(1));
        }
        // Close the result set, statement and the connection
        rsTest.close() ;
        stmt.close() ;
    }
}