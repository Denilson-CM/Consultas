package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Denilson
 */
public class ConsultaProyecto extends Conexion{
    
     //************************* BUSCAR ************************************************
    
    public boolean Buscar(Proyecto pro){
    
        Connection con = getConexion();
        //decalramos variables de trnsaccion
        PreparedStatement ps = null;
        ResultSet rs;
        String sql = "SELECT * FROM proyectos WHERE idproyecto = ?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigoproyecto());
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                pro.setNombreproyecto(rs.getString("nombreproyecto"));
                
               return true; 
            }
            
            return false;
            
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
    
   //************************* INSERTAR ************************************************
    public boolean registrar(Proyecto pro){
    
        Connection con = getConexion();
        //decalramos variables de trnsaccion
        PreparedStatement ps = null;
        
        String sql = "INSERT INTO proyectos (codigoproyecto, nombreproyecto) VALUES(?, ?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigoproyecto());
            ps.setString(2, pro.getNombreproyecto());
            
            
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

    

    public ArrayList<String> llenarProyecto(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> listaP = new ArrayList<String>();
        String q = "SELECT * FROM proyectos";
        Connection con = null;
        try{
            con = getConexion();
            ps = con.prepareStatement("SELECT * FROM proyectos");
            rs = ps.executeQuery();
        }catch(Exception e){
            System.out.println("Error");
        }
        try{
           while(rs.next()){
               listaP.add(rs.getString("codigoproyecto"));
           } 
        }catch(Exception e){
            System.out.println("Error");
        }
        return listaP;
    }
}
