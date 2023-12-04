package Views;

import Cita.FrmCitas;
import Revision.FrmRevisiones;
import Tecnico.FrmTecnicos;
import Vehiculo.FrmVehiculos;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrmMenu extends javax.swing.JFrame {

    public FrmMenu() {
        initComponents();
        View.maximize(this);
        setTitle("Sistema Riteve");
        setDefaultCloseOperation(FrmMenu.DO_NOTHING_ON_CLOSE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopMenu = new javax.swing.JDesktopPane();
        menu = new javax.swing.JMenuBar();
        menuManage = new javax.swing.JMenu();
        menuVehiculos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuCitas = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopMenuLayout = new javax.swing.GroupLayout(desktopMenu);
        desktopMenu.setLayout(desktopMenuLayout);
        desktopMenuLayout.setHorizontalGroup(
            desktopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1005, Short.MAX_VALUE)
        );
        desktopMenuLayout.setVerticalGroup(
            desktopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );

        menu.setToolTipText("");
        menu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        menuManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/ICON/computer.png"))); // NOI18N
        menuManage.setText("Gestion");
        menuManage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        menuVehiculos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuVehiculos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/ICON/seguro-de-coche.png"))); // NOI18N
        menuVehiculos.setText("Vehiculos");
        menuVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVehiculosActionPerformed(evt);
            }
        });
        menuManage.add(menuVehiculos);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/ICON/user_identity (3).png"))); // NOI18N
        jMenuItem1.setText("Técnicos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuManage.add(jMenuItem1);

        menuCitas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuCitas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/ICON/calendario.png"))); // NOI18N
        menuCitas.setText("Citas");
        menuCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCitasActionPerformed(evt);
            }
        });
        menuManage.add(menuCitas);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/ICON/accessories_text_editor (3).png"))); // NOI18N
        jMenuItem2.setText("Reviciones");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuManage.add(jMenuItem2);

        jCheckBoxMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jCheckBoxMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Cerrar Sesión");
        jCheckBoxMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/ICON/gnome-session-halt.png"))); // NOI18N
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        menuManage.add(jCheckBoxMenuItem1);

        menu.add(menuManage);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopMenu, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVehiculosActionPerformed
        FrmVehiculos frm = new FrmVehiculos();
        View.showInternalVehiculos(desktopMenu, frm);
    }//GEN-LAST:event_menuVehiculosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmTecnicos frm = new FrmTecnicos();
        View.showInternalTecnicos(desktopMenu, frm);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCitasActionPerformed
        FrmCitas frm = new FrmCitas();
        View.showInternalCitas(desktopMenu, frm);
    }//GEN-LAST:event_menuCitasActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FrmRevisiones frm = new FrmRevisiones();
        View.showInternalRevisiones(desktopMenu, frm);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        boolean autenticado = false;

        while (!autenticado) {
            JPasswordField passwordField = new JPasswordField();
            JTextField userField = new JTextField();
            Object[] message = {"Usuario:", userField, "Contraseña:", passwordField};

            int option = JOptionPane.showConfirmDialog(null, message, "Inicio de Sesión", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                String usuario = userField.getText();
                String contrasena = new String(passwordField.getPassword());

                if (autenticarUsuario(usuario, contrasena)) {
                    autenticado = true;
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new FrmMenu().setVisible(true);
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Inténtelo nuevamente.");
                }
            } else {
                autenticado = true;
            }
        }
    }

    private static boolean autenticarUsuario(String usuario, String contrasena) {
        return usuario.equals("Administrador") && contrasena.equals("6F19R4D");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktopMenu;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem menuCitas;
    private javax.swing.JMenu menuManage;
    private javax.swing.JMenuItem menuVehiculos;
    // End of variables declaration//GEN-END:variables
}
