package Controlador;

import Modelo.Alumnos;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Denilson
 */
public class CtrAlumno implements ActionListener{
    
    private Alumnos modA;
    private ConsultaAlumno modC;
    private fmConsulta fmC;

    public CtrAlumno(Alumnos modA, ConsultaAlumno modC, fmConsulta fmC) {
        this.modA = modA;
        this.modC = modC;
        this.fmC = fmC;
        
        this.fmC.btnBuscar.addActionListener(this);
        this.fmC.btnGuardar.addActionListener(this);
        this.fmC.btnModificar.addActionListener(this);
        this.fmC.btnEliminar.addActionListener(this);
        this.fmC.btnLimpiar.addActionListener(this);
        this.fmC.btnRegresar.addActionListener(this);
    }
    
    public void iniciar(){
        
        fmC.setTitle("Alumnos");
        fmC.setLocationRelativeTo(null);
        fmC.txtId.setVisible(false);
    }
    
     public void limpiarCajas(){
        fmC.txtId.setText(null);
        fmC.txtMatricula.setText(null);
        fmC.txtNombre.setText(null);
        //se utiliza como arreglo y lo posicionamos en 0 para seleccionar
        fmC.cbxCarrera.setSelectedIndex(0);
        fmC.txtSemestre.setText(null);
        fmC.txtLocalidad.setText(null);
        fmC.txtTelefono.setText(null);
        fmC.txtCorreo.setText(null);
    }
    
    public void actionPerformed(ActionEvent e){
      
         
        
        //**********************GUARDAR
        if(e.getSource() == fmC.btnGuardar){
            modA.setMatricula(fmC.txtMatricula.getText());
            modA.setNombre(fmC.txtNombre.getText());
            modA.setCarrera(fmC.cbxCarrera.getSelectedItem().toString());
            modA.setSemestre(fmC.txtSemestre.getText());
            modA.setLocalidad(fmC.txtLocalidad.getText());
            modA.setTelefono(fmC.txtTelefono.getText());
            modA.setCorreo_electronico(fmC.txtCorreo.getText());
            
            if(modC.registrar(modA)){
                JOptionPane.showMessageDialog(null,"Alumno Guardado");
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar Alumno");
                limpiarCajas();
            }
        }
        
        //**********************Modificar
        if(e.getSource() == fmC.btnModificar){
            
            modA.setId(Integer.parseInt(fmC.txtId.getText()));
            modA.setMatricula(fmC.txtMatricula.getText());
            modA.setNombre(fmC.txtNombre.getText());
            modA.setCarrera(fmC.cbxCarrera.getSelectedItem().toString());
            modA.setSemestre(fmC.txtSemestre.getText());
            modA.setLocalidad(fmC.txtLocalidad.getText());
            modA.setTelefono(fmC.txtTelefono.getText());
            modA.setCorreo_electronico(fmC.txtCorreo.getText());
            
            if(modC.Modificar(modA)){
                JOptionPane.showMessageDialog(null,"Alumno Modificado");
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Modificar Alumno");
                limpiarCajas();
            }
        }
        
         //**********************ELIMINAR
        if(e.getSource() == fmC.btnEliminar){
            
            modA.setId(Integer.parseInt(fmC.txtId.getText()));
            
            if(modC.Eliminar(modA)){
                JOptionPane.showMessageDialog(null,"Alumno Eliminado");
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar Alumno");
                limpiarCajas();
            }
        }
        
         //**********************Buscar
        if(e.getSource() == fmC.btnBuscar){
            modA.setMatricula(fmC.txtMatricula.getText());

            if(modC.Buscar(modA)){
                
                fmC.txtId.setText(String.valueOf(modA.getId()));
                fmC.txtMatricula.setText(modA.getMatricula());
                fmC.txtNombre.setText(modA.getNombre());
                fmC.cbxCarrera.setSelectedItem(String.valueOf(modA.getCarrera()));
                fmC.txtSemestre.setText(modA.getSemestre());
                fmC.txtLocalidad.setText(modA.getLocalidad());
                fmC.txtTelefono.setText(modA.getTelefono());
                fmC.txtCorreo.setText(modA.getCorreo_electronico());
                
                
                
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro al Alumno");
                limpiarCajas();
            }
        }
        if(e.getSource() == fmC.btnLimpiar){
            limpiarCajas();
        }
        
         //**********************menu
        if(e.getSource() == fmC.btnRegresar){
           
            fmLogin lg = new fmLogin();
            lg.setVisible(true);
            fmC.dispose();
            /*fmMenu fmP = new fmMenu();
            Menu mn = new Menu();
            ConsultaMenu cm = new ConsultaMenu();
            CtrMenu ctrP = new CtrMenu(fmP, mn, cm);
            ctrP.iniciar();
            fmP.setVisible(true);
            fmC.dispose();*/

        }
    }
    
}
