package ConnexionBD;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
* The BenchmarkProperties class describes the properties of 
the benchmark to
* run.
*/
public class DatabaseAccessProperties {

    private Properties prop = new Properties();
    private String jdbcDriver;
    private String dbUrl;
    private String username, password;
    private static final String configurationFile = "BD.properties";
    private Connection conn;
    
    public DatabaseAccessProperties() throws ClassNotFoundException {
        
        try {    
            prop = new Properties();
            prop.load(new FileInputStream(configurationFile));
        } 
        catch (FileNotFoundException e) {
            System.err.println( "FileNotFoundException: " + e.getMessage()) ;
            e.printStackTrace();
            return;
        } 
        catch (IOException e) {
            System.err.println( "IOException: " + e.getMessage()) ;
            e.printStackTrace();
            return;
        }
        jdbcDriver = prop.getProperty("jdbc.driver");
        dbUrl = prop.getProperty("database.url");
        username = prop.getProperty("database.username");
        password = prop.getProperty("database.password");
        
        try {
            // Load the database driver
            Class.forName(jdbcDriver) ;
            // Get a connection to the database
            conn = DriverManager.getConnection(dbUrl, username, password);
            RequetesSQL.recherchePatient(conn,"momo");
            RequetesSQL.authentification(conn,"1","1");
            
        }catch( SQLException se ) {

        // Print information about SQL exceptions
        SQLWarningsExceptions.printExceptions(se);

        return;
        }
    }
    
    public String getJdbcDriver() {
        return jdbcDriver;
    }
    public String getDatabaseUrl() {
        return dbUrl;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    
    public Connection getConn() {
        return conn;
    }
}

