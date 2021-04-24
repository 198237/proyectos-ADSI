
package Config;

import java.sql.*;


/**
 *
 * @author Estiven
 */
public class Conexion {
    Connection con;
    
    public Conexion(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/copia_proyecto","root","");
            System.out.println("Conectado a la base de datos");
        } catch (Exception e) {
            System.out.println("No se pudo"+e.getMessage());
        }
    
    }
    
    public Connection getConexion(){
    return con;
    }
}
