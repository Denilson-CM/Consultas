package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denilson
 */
public class Conexion {
    
    public final String BASE = "equipodual";
    public final String URL = "jdbc:mysql://localhost:3306/"+BASE;
    public final String USERNAME = "root";
    public final String PASSWORD = "denilson2.33";
    Connection con = null;
    
    //metodo de tipo conexion para regresar la conexion y se llamara getConnection
    //que no resivira ningun parametro
    public Connection getConexion(){
        try {
            //nombre de espacio que trae el conector
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection)DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
            //JOptionPane.showMessageDialog(null, "conexion exitosa");

        } catch (SQLException e) {
            System.out.println(e);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
