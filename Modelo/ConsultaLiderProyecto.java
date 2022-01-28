/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Denilson
 */
public class ConsultaLiderProyecto extends Conexion{
    
    //************************* BUSCAR ************************************************
    
    public boolean Buscar(LiderProyecto lp){
    
        Connection con = getConexion();
        //decalramos variables de trnsaccion
        PreparedStatement ps = null;
        ResultSet rs;
        String sql = "SELECT * FROM lider_proyecto WHERE codigoLider = ?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, lp.getCodigoLider());
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                lp.setNombre(rs.getString("nombre"));
                lp.setApellido(rs.getString("apellido"));
                
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
    public boolean registrar(LiderProyecto lp){
    
        Connection con = getConexion();
        //decalramos variables de trnsaccion
        PreparedStatement ps = null;
        
        String sql = "INSERT INTO lider_proyecto (codigoLider, nombre, apellido) VALUES(?, ?, ?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, lp.getCodigoLider());
            ps.setString(2, lp.getNombre());
            ps.setString(3, lp.getApellido());
            
            
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
    
    
     public ArrayList<String> llenarLider(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> listaL = new ArrayList<String>();
        String q = "SELECT * FROM lider_proyecto";
        Connection con = null;
        try{
            con = getConexion();
            ps = con.prepareStatement("SELECT * FROM lider_proyecto");
            rs = ps.executeQuery();
        }catch(Exception e){
            System.out.println("Error");
        }
        try{
           while(rs.next()){
               listaL.add(rs.getString("codigolider"));
           } 
        }catch(Exception e){
            System.out.println("Error");
        }
        return listaL;
    }
}
