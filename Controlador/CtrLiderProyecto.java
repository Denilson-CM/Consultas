/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumnos;
import Modelo.ConsultaAlumno;
import Modelo.ConsultaLiderProyecto;
import Modelo.ConsultaMenu;
import Modelo.LiderProyecto;
import Modelo.Menu;
import Vista.fmConsulta;
import Vista.fmLider;
import Vista.fmLogin;
import Vista.fmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Denilson
 */
public class CtrLiderProyecto implements ActionListener{
    
    private LiderProyecto modelLiderProyecto;
    private ConsultaLiderProyecto modelConsultaLiderProyecto;
    private fmLider fmL;

    public CtrLiderProyecto(LiderProyecto modelLiderProyecto, ConsultaLiderProyecto modelConsultaLiderProyecto, fmLider fmL) {
        this.modelLiderProyecto = modelLiderProyecto;
        this.modelConsultaLiderProyecto = modelConsultaLiderProyecto;
        this.fmL = fmL;
        
        this.fmL.btnBuscar.addActionListener(this);
        this.fmL.btnGuardar.addActionListener(this);
        this.fmL.btnRegresar.addActionListener(this);
        
    }
    
    public void iniciar(){
        
        fmL.setTitle("LiderProyecto");
        fmL.setLocationRelativeTo(null);
    }
    
     public void limpiarCajas(){
        fmL.txtId.setText(null);
        
        fmL.txtNombre.setText(null);
        
        fmL.txtApellido.setText(null);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
      
    
        //**********************GUARDAR
        if(e.getSource() == fmL.btnGuardar){
            modelLiderProyecto.setCodigoLider(fmL.txtId.getText());
            modelLiderProyecto.setNombre(fmL.txtNombre.getText());
            modelLiderProyecto.setApellido(fmL.txtApellido.getText());
            
            
            if(modelConsultaLiderProyecto.registrar(modelLiderProyecto)){
                JOptionPane.showMessageDialog(null,"Lider de Proyecto Guardado");
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar Lider de Proyecto");
                limpiarCajas();
            }
        }
        
        
         //**********************Buscar
        if(e.getSource() == fmL.btnBuscar){
            modelLiderProyecto.setCodigoLider(fmL.txtId.getText());
            

            if(modelConsultaLiderProyecto.Buscar(modelLiderProyecto)){
                
                fmL.txtId.setText(modelLiderProyecto.getCodigoLider());
               
                fmL.txtNombre.setText(modelLiderProyecto.getNombre());
                
                fmL.txtApellido.setText(modelLiderProyecto.getApellido());
        
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro al Lider de Proyecto");
                limpiarCajas();
            }
        }
        
        
         //**********************menu
        if(e.getSource() == fmL.btnRegresar){
           
            fmLogin lg = new fmLogin();
            lg.setVisible(true);
            fmL.dispose();
            /*fmMenu fmP = new fmMenu();
            Menu mn = new Menu();
            ConsultaMenu cm = new ConsultaMenu();
            CtrMenu ctrP = new CtrMenu(fmP, mn, cm);
            ctrP.iniciar();
            fmP.setVisible(true);
            fmL.dispose();*/

        }
    }
    
}
