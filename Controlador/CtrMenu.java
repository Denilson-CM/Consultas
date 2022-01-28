/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumnos;
import Modelo.Conexion;
import Modelo.ConsultaAlumno;
import Modelo.ConsultaLiderProyecto;
import Modelo.ConsultaMenu;
import Modelo.ConsultaProyecto;
import Modelo.LiderProyecto;
import Modelo.Menu;
import Modelo.Proyecto;
import Vista.fmConsulta;
import Vista.fmLider;
import Vista.fmLogin;
import Vista.fmMenu;
import Vista.fmproyectos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Denilson
 */
public class CtrMenu extends Conexion implements ActionListener{
    
   
    private ConsultaProyecto cp = new ConsultaProyecto();
    private ConsultaLiderProyecto clp = new ConsultaLiderProyecto();
    private ConsultaAlumno ca = new ConsultaAlumno();
    
    private Menu modelMenu;
    private ConsultaMenu modelConsultaMenu;
    private fmMenu fmM;
    
   
    public CtrMenu(fmMenu fmM, Menu modelMenu, ConsultaMenu modelConsultaMenu) {
        
        this.fmM = fmM;
        this.modelMenu = modelMenu;
        this.modelConsultaMenu = modelConsultaMenu;
       

        this.fmM.btnGuardar.addActionListener(this);
        this.fmM.btnEliminar.addActionListener(this);
        this.fmM.btnAlumno.addActionListener(this);
        this.fmM.btnProyecto.addActionListener(this);
        this.fmM.btnLider.addActionListener(this);
        
        //PROYECTO
        ArrayList<String> listaP = new ArrayList<String>();
        listaP = cp.llenarProyecto();
        for(int i = 0; i<listaP.size(); i++){
            this.fmM.cbxCodigoProyecto.addItem(listaP.get(i));
        }
        
       //LIDER
        ArrayList<String> listaL = new ArrayList<String>();
        listaL = clp.llenarLider();
        for(int i = 0; i<listaL.size(); i++){
            this.fmM.cbxCodigoLider.addItem(listaL.get(i));
        }
        
         //ID
        ArrayList<String> listaId = new ArrayList<String>();
        listaId = ca.llenarId();
        for(int i = 0; i<listaId.size(); i++){
            this.fmM.cbxIdAlumno.addItem(listaId.get(i));
        }
        
        
        //MATRICULA
        ArrayList<String> lista = new ArrayList<String>();
        lista = ca.llenarMatricula();
        for(int i = 0; i<lista.size(); i++){
            this.fmM.cbxMatriculaAlumno.addItem(lista.get(i));
        }
        
    }
    
    public void iniciar(){
        
        fmM.setTitle("MENU");
        fmM.setLocationRelativeTo(null);
    }

     public void limpiarCajas(){
    
        fmM.cbxCodigoProyecto.setSelectedIndex(0);
        fmM.cbxCodigoLider.setSelectedIndex(0);
        fmM.cbxIdAlumno.setSelectedIndex(0);
        fmM.cbxMatriculaAlumno.setSelectedIndex(0);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        fmLogin lg = new fmLogin();
        //**********************MostrarProyectos
        if(e.getSource() == fmM.btnProyecto){
            
            lg.setVisible(true);
            fmM.dispose();
        }
         //**********************Mostrarlider
        if(e.getSource() == fmM.btnLider){
            
           lg.setVisible(true);
           fmM.dispose();
        }
        
        //**********************MostrarConsulat
        if(e.getSource() == fmM.btnAlumno){
            
            lg.setVisible(true);
            fmM.dispose();
        }
    
        //**********************GUARDAR
        if(e.getSource() == fmM.btnGuardar){
            modelMenu.setAlumnos_id(Integer.parseInt(fmM.cbxIdAlumno.getSelectedItem().toString()));
            modelMenu.setAlumnos_matricula(fmM.cbxMatriculaAlumno.getSelectedItem().toString());
            modelMenu.setLider_proyecto_codigolider(fmM.cbxCodigoLider.getSelectedItem().toString());
            modelMenu.setProyectos_codigoproyecto(fmM.cbxCodigoProyecto.getSelectedItem().toString());
            
            
            
            if(modelConsultaMenu.registrar(modelMenu)){
                JOptionPane.showMessageDialog(null,"Asignado");
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Asignar");
                limpiarCajas();
            }
        }
        
        //**********************ELIMINAR
        if(e.getSource() == fmM.btnEliminar){
            
            modelMenu.setAlumnos_matricula(fmM.cbxMatriculaAlumno.getSelectedItem().toString());
            
            if(modelConsultaMenu.Eliminar(modelMenu)){
                JOptionPane.showMessageDialog(null,"Eliminado");
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiarCajas();
            }
        }
    }
}
