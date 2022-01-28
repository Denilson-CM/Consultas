/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Denilson
 */
public class Menu {
    private int alumnos_id;
    private String alumnos_matricula;
    private String lider_proyecto_codigolider;
    private String proyectos_codigoproyecto;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    public int getAlumnos_id() {
        return alumnos_id;
    }

    public void setAlumnos_id(int alumnos_id) {
        this.alumnos_id = alumnos_id;
    }

    public String getAlumnos_matricula() {
        return alumnos_matricula;
    }

    public void setAlumnos_matricula(String alumnos_matricula) {
        this.alumnos_matricula = alumnos_matricula;
    }

    public String getLider_proyecto_codigolider() {
        return lider_proyecto_codigolider;
    }

    public void setLider_proyecto_codigolider(String lider_proyecto_codigolider) {
        this.lider_proyecto_codigolider = lider_proyecto_codigolider;
    }

    public String getProyectos_codigoproyecto() {
        return proyectos_codigoproyecto;
    }

    public void setProyectos_codigoproyecto(String proyectos_codigoproyecto) {
        this.proyectos_codigoproyecto = proyectos_codigoproyecto;
    }
    
    
    
}
