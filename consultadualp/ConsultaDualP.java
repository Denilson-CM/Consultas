/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultadualp;

import Controlador.CtrAlumno;
import Controlador.CtrLiderProyecto;
import Controlador.CtrMenu;
import Controlador.CtrProyecto;
import Modelo.Alumnos;
import Modelo.ConsultaAlumno;
import Modelo.ConsultaLiderProyecto;
import Modelo.ConsultaProyecto;
import Modelo.LiderProyecto;
import Modelo.Proyecto;
import Vista.fmConsulta;
import Vista.fmLider;
import Vista.fmLogin;
import Vista.fmMenu;
import Vista.fmproyectos;
import java.util.HashSet;

/**
 *
 * @author Denilson
 */
public class ConsultaDualP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /*Alumnos modA = new Alumnos();
       ConsultaAlumno modC = new ConsultaAlumno();
       fmConsulta fmC = new fmConsulta();
       
      /* Proyecto pro = new Proyecto();
       ConsultaProyecto cp = new ConsultaProyecto();
       fmproyectos fmP = new fmproyectos();*/
       
       /*CtrAlumno ctrA = new CtrAlumno(modA, modC , fmC);
       ctrA.iniciar();
       fmC.setVisible(true);*/
       /*
       CtrProyecto ctrP = new CtrProyecto(pro, cp , fmP);
       ctrP.iniciar();
       fmP.setVisible(true);*/
       /*LiderProyecto modA = new LiderProyecto();
       ConsultaLiderProyecto modC = new ConsultaLiderProyecto();
       fmLider fmC = new fmLider();
       
       CtrLiderProyecto ctrP = new CtrLiderProyecto(modA, modC , fmC);
       ctrP.iniciar();
       fmC.setVisible(true);*/
        
        fmLogin lg = new fmLogin();
        lg.setVisible(true);
        
        
    }
    
}
