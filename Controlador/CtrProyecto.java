/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumnos;
import Modelo.ConsultaAlumno;
import Modelo.ConsultaMenu;
import Modelo.ConsultaProyecto;
import Modelo.Menu;
import Modelo.Proyecto;
import Vista.fmConsulta;
import Vista.fmLogin;
import Vista.fmMenu;
import Vista.fmproyectos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Denilson
 */
public class CtrProyecto implements ActionListener{
    
    private Proyecto modelProyecto;
    private ConsultaProyecto modelConsultaProyecto;
    private fmproyectos fmP;

    public CtrProyecto(Proyecto modelProyecto, ConsultaProyecto modelConsultaProyecto, fmproyectos fmP) {
        this.modelProyecto = modelProyecto;
        this.modelConsultaProyecto = modelConsultaProyecto;
        this.fmP = fmP;
        
        this.fmP.btnBuscar.addActionListener(this);
        this.fmP.btnGuardar.addActionListener(this);
        this.fmP.btnRegresar.addActionListener(this);
    }
    
    public void iniciar(){
        
        fmP.setTitle("Proyecto");
        fmP.setLocationRelativeTo(null);
    }
    
     public void limpiarCajas(){
        fmP.txtCodigoProyecto.setText(null);
        
        fmP.txtNombreProyecto.setText(null);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        
        
        
         //**********************Buscar
        if(e.getSource() == fmP.btnBuscar){
            modelProyecto.setCodigoproyecto(fmP.txtCodigoProyecto.getText());
            

            if(modelConsultaProyecto.Buscar(modelProyecto)){
                
                fmP.txtCodigoProyecto.setText(modelProyecto.getCodigoproyecto());
               
                fmP.txtNombreProyecto.setText(modelProyecto.getNombreproyecto());
        
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro al Proyecto");
                limpiarCajas();
            }
        }
        
        //**********************GUARDAR
        if(e.getSource() == fmP.btnGuardar){
            modelProyecto.setCodigoproyecto(fmP.txtCodigoProyecto.getText());
            modelProyecto.setNombreproyecto(fmP.txtNombreProyecto.getText());
            
            
            
            if(modelConsultaProyecto.registrar(modelProyecto)){
                JOptionPane.showMessageDialog(null,"Proyecto Guardado");
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar Proyecto");
                limpiarCajas();
            }
        }
        
         //**********************menu
        if(e.getSource() == fmP.btnRegresar){
           
            fmLogin lg = new fmLogin();
            lg.setVisible(true);
            fmP.dispose();
            
            /*fmMenu fmM = new fmMenu();
            Menu mn = new Menu();
            ConsultaMenu cm = new ConsultaMenu();
            CtrMenu ctrP = new CtrMenu(fmM, mn, cm);
            ctrP.iniciar();
            fmM.setVisible(true);
            fmP.dispose();*/

        }
        
    }
    
}
