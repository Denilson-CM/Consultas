package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Denilson
 */
public class ConsultaMenu extends Conexion {
    
     //************************* INSERTAR ************************************************
    public boolean registrar(Menu mn){
    
        Connection con = getConexion();
        //decalramos variables de trnsaccion
        PreparedStatement ps = null;
        
        String sql = "INSERT INTO alproyectos (alumnos_id, alumnos_matricula, lider_proyecto_codigoLider, proyectos_codigoproyecto) VALUES(?, ?, ?, ?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1,mn.getAlumnos_id());
            ps.setString(2, mn.getAlumnos_matricula());
            ps.setString(3, mn.getLider_proyecto_codigolider());
            ps.setString(4, mn.getProyectos_codigoproyecto());
            
            
            ps.execute();
            return true;
            
        }catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }finally{
            try{
                con.close();
            }catch(Exception e2){
                System.err.println(e2.getMessage());
            }
        }
    }
    
    //**************************** ELIMINAR ************************************************
    
    public boolean Eliminar(Menu mn){
    
        Connection con = getConexion();
        //decalramos variables de trnsaccion
        PreparedStatement ps = null;
        
        String sql = "DELETE FROM alproyectos WHERE  alumnos_matricula= ?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, mn.getAlumnos_matricula());
            ps.execute();
            return true;
            
        }catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }finally{
            try{
                con.close();
            }catch(Exception e2){
                System.err.println(e2.getMessage());
            }
        }
    }
    
}
