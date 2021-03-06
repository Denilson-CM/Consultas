/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtrAlumno;
import Controlador.CtrLiderProyecto;
import Controlador.CtrMenu;
import Controlador.CtrProyecto;
import Modelo.Alumnos;
import Modelo.Conexion;
import Modelo.ConsultaAlumno;
import Modelo.ConsultaLiderProyecto;
import Modelo.ConsultaMenu;
import Modelo.ConsultaProyecto;
import Modelo.LiderProyecto;
import Modelo.Menu;
import Modelo.Proyecto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Denilson
 */
public class fmLogin extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    Connection con=cc.getConexion();
    
    public fmLogin() {
        initComponents();
        this.setTitle("LOGIN");
        this.setLocationRelativeTo(null);
    }
    
    public void validarAcceso(Menu men) {
        int resultado = 0;
        try {
            String Usuario = txtUsuario.getText();
            String Pass = String.valueOf(txtPass.getPassword());
            

            String sql = "SELECT * FROM login_usuario WHERE usuario = "+"'"+Usuario+"'"+ "AND pass = '"+Pass+"'";
            
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                resultado = 1;
                men.setAccion(rs.getString("accion"));
                men.getAccion();
                if (resultado == 1) {
                    if("menu".equals(men.getAccion())){
                        fmMenu fmP = new fmMenu();
                        Menu mn = new Menu();
                        ConsultaMenu cm = new ConsultaMenu();
                        CtrMenu ctrP = new CtrMenu(fmP, mn, cm);
                        ctrP.iniciar();
                        fmP.setVisible(true);
                        this.dispose();
                    }
                    if("alumno".equals(men.getAccion())){
                        
                        Alumnos modA = new Alumnos();
                        ConsultaAlumno modC = new ConsultaAlumno();
                        fmConsulta fmC = new fmConsulta();
            
                        CtrAlumno ctrA = new CtrAlumno(modA, modC , fmC);
                        ctrA.iniciar();
                        fmC.setVisible(true);
                        this.dispose();
                    }
                    if("proyecto".equals(men.getAccion())){
                        
                        Proyecto pro = new Proyecto();
                        ConsultaProyecto cp = new ConsultaProyecto();
                        fmproyectos fmP = new fmproyectos();
                        CtrProyecto ctrP = new CtrProyecto(pro, cp, fmP);
                        ctrP.iniciar();
                        fmP.setVisible(true);
                        this.dispose();
                    }
                    if("lider".equals(men.getAccion())){
                        
                        LiderProyecto lp = new LiderProyecto();
                        ConsultaLiderProyecto cl = new ConsultaLiderProyecto();
                        fmLider fmL = new fmLider();
                        CtrLiderProyecto ctrl = new CtrLiderProyecto(lp, cl, fmL);
                        ctrl.iniciar();
                        fmL.setVisible(true);
                        this.dispose();
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Error en el Acceso, No se encuaentra el usuario o la contrase??a ");
                }
            }else {
                    JOptionPane.showMessageDialog(null, "Error en el Acceso, No se encuaentra el usuario o la contrase??a ");
                }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el Acceso, No se encuaentra el usuario o la contrase??a "
             +e.getMessage());
        }

    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contrase??a:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 140, -1));
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 140, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/user.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 140, 140));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/blue-2384333_960_720.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 260, 220));

        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu me = new Menu();
        validarAcceso(me);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
