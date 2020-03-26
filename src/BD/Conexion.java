
package BD;

import static INICIO.Login.URL_0;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

//hola drtgttSdwed
    public class Conexion {
   
    private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
    private static  String URL="";
    private static  String USER="";
    private static  String PASS="";
    private static Driver driver =null;
    
    public static synchronized Connection getConexion() throws SQLException{
    URL="";
        USER="";
        PASS="";
        //
         Properties prop = new Properties();
	InputStream input = null;
	try {
           
                input = new FileInputStream(URL_0+"config.properties");
          
		// load a properties file
		prop.load(input);
		// get the property value and print it out
		//System.out.println(prop.getProperty("URL"));
		//System.out.println(prop.getProperty("USER"));
		//System.out.println(prop.getProperty("PASS"));              
                URL=prop.getProperty("URL");
                USER=prop.getProperty("USER");
                PASS=prop.getProperty("PASS");
                
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        ////        
        try{
        Class driverClass = Class.forName(DRIVER_CLASS);
        driver = (Driver)driverClass.newInstance();
        DriverManager.registerDriver(driver);        
       
    }catch(Exception ex){
        ex.printStackTrace();
    } 
    
    return DriverManager.getConnection(URL, USER, PASS);
}

    
 public static void close(Connection con){
    try{
        if(con!=null)con.close();
    }catch(SQLException ex){
        ex.printStackTrace();
    }
    
}       
  
public static void close(ResultSet rs){
    try{
        if(rs!=null) rs.close();
    }catch(SQLException ex){
        ex.printStackTrace();
    }
    
}

public static void close(PreparedStatement stmt){
    try{
        if(stmt!=null) stmt.close();
    }catch(SQLException ex){
     ex.printStackTrace();
    }
    
}



}
