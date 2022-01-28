package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Denilson
 */
public class ConsultaAlumno extends Conexion{
    
    
    
    //************************* BUSCAR ************************************************
    
    public boolean Buscar(Alumnos Al){
    
        Connection con = getConexion();
        //decalramos variables de trnsaccion
        PreparedStatement ps = null;
        ResultSet rs;
        String sql = "SELECT * FROM alumnos WHERE matricula = ?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, Al.getMatricula());
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                Al.setId(Integer.parseInt(rs.getString("id")));
                Al.setMatricula(rs.getString("matricula"));
                Al.setNombre(rs.getString("nombre"));
                Al.setCarrera(rs.getString("carrera"));
                Al.setSemestre(rs.getString("semestre"));
                Al.setLocalidad(rs.getString("localidad"));
                Al.setTelefono(rs.getString("telefono"));
                Al.setCorreo_electronico(rs.getString("correo_electronico"));
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
    public boolean registrar(Alumnos Al){
    
        Connection con = getConexion();
        //decalramos variables de trnsaccion
        PreparedStatement ps = null;
        
        String sql = "INSERT INTO alumnos (matricula, nombre, carrera, semestre, localidad, telefono, correo_electronico) VALUES(?,?,?,?,?,?,?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, Al.getMatricula());
            ps.setString(2, Al.getNombre());
            ps.setString(3, Al.getCarrera());
            ps.setString(4, Al.getSemestre());
            ps.setString(5, Al.getLocalidad());
            ps.setString(6, Al.getTelefono());
            ps.setString(7, Al.getCorreo_electronico());
            
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
    
//**************************** MODIFICAR ************************************************
    
    public boolean Modificar(Alumnos Al){
    
        Connection con = getConexion();
        //decalramos variables de trnsaccion
        PreparedStatement ps = null;
        
        String sql = "UPDATE alumnos SET matricula = ?, nombre = ?, carrera = ?, semestre = ?, localidad = ?, telefono = ?, correo_electronico = ? WHERE id = ?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, Al.getMatricula());
            ps.setString(2, Al.getNombre());
            ps.setString(3, Al.getCarrera());
            ps.setString(4, Al.getSemestre());
            ps.setString(5, Al.getLocalidad());
            ps.setString(6, Al.getTelefono());
            ps.setString(7, Al.getCorreo_electronico());
            ps.setInt(8, Al.getId());
          
            
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
    
    public boolean Eliminar(Alumnos Al){
    
        Connection con = getConexion();
        //decalramos variables de trnsaccion
        PreparedStatement ps = null;
        
        String sql = "DELETE FROM alumnos WHERE  id= ?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, Al.getId());
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
    
    public ArrayList<String> llenarId() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> listaId = new ArrayList<String>();
        String q = "SELECT * FROM alumnos";
        Connection con = null;
        try {
            con = getConexion();
            ps = con.prepareStatement("SELECT * FROM alumnos");
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error");
        }
        try {
            while (rs.next()) {
                listaId.add(rs.getString("id"));
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return listaId;
    }

    public ArrayList<String> llenarMatricula(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> lista = new ArrayList<String>();
        String q = "SELECT * FROM alumnos";
        Connection con = null;
        try{
            con = getConexion();
            ps = con.prepareStatement("SELECT * FROM alumnos");
            rs = ps.executeQuery();
        }catch(Exception e){
            System.out.println("Error");
        }
        try{
           while(rs.next()){
               lista.add(rs.getString("matricula"));
           } 
        }catch(Exception e){
            System.out.println("Error");
        }
        return lista;
    }
    
    
    
    
}
