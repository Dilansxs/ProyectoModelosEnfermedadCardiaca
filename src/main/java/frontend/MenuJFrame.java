package frontend;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author labctr
 */
public class MenuJFrame extends javax.swing.JFrame {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private final Ingresar_Datos datospacientejpanel;
    /**
     * Creates new form MenuJFrame
     */
    public MenuJFrame() {
        try {
            mongoClient = MongoClients.create("mongodb://localhost:27017");
            database = mongoClient.getDatabase("Base_Datos_Paciente");
            collection = database.getCollection("Datos_Paciente");
            initComponents();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error initializing MongoDB client: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // Salir de la aplicación en caso de error grave
        }
        
        
        datospacientejpanel = new Ingresar_Datos(mongoClient, database, collection);
        datospacientejpanel.setSize(jPanelVista.getSize());
        datospacientejpanel.setLocation(0, 0);
        jPanelVista.removeAll();
        jPanelVista.add(datospacientejpanel);
        jPanelVista.revalidate();
        jPanelVista.repaint();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonDatos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonTratamiento = new javax.swing.JButton();
        jButtonDiagnosticarPaciente = new javax.swing.JButton();
        jButtonDetectarPaciente = new javax.swing.JButton();
        jButtonHistorialMedico = new javax.swing.JButton();
        jPanelVista = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setForeground(new java.awt.Color(51, 153, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 45));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSalir.setBackground(new java.awt.Color(255, 0, 0));
        jButtonSalir.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.setPreferredSize(new java.awt.Dimension(85, 45));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 0, -1, 40));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html>Sistema que facilita la detección, prevención y tratamiento de enfermedades cardíacas mediante IA<html>");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 690, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(225, 650));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonDatos.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonDatos.setForeground(new java.awt.Color(51, 153, 255));
        jButtonDatos.setText("Ingresar Datos");
        jButtonDatos.setBorder(null);
        jButtonDatos.setPreferredSize(new java.awt.Dimension(225, 50));
        jButtonDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDatosActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 225, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon("./src/main/java/resources/Fondo.png")
        );
        jLabel2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 230, 350));

        jLabel3.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("Menú");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jButtonTratamiento.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonTratamiento.setForeground(new java.awt.Color(51, 153, 255));
        jButtonTratamiento.setText("Generar Tratamiento");
        jButtonTratamiento.setBorder(null);
        jButtonTratamiento.setPreferredSize(new java.awt.Dimension(225, 50));
        jButtonTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTratamientoActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 225, 50));

        jButtonDiagnosticarPaciente.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonDiagnosticarPaciente.setForeground(new java.awt.Color(51, 153, 255));
        jButtonDiagnosticarPaciente.setText("Diagnosticar Paciente");
        jButtonDiagnosticarPaciente.setBorder(null);
        jButtonDiagnosticarPaciente.setPreferredSize(new java.awt.Dimension(225, 50));
        jButtonDiagnosticarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDiagnosticarPacienteActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonDiagnosticarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 225, 50));

        jButtonDetectarPaciente.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonDetectarPaciente.setForeground(new java.awt.Color(51, 153, 255));
        jButtonDetectarPaciente.setText("Generar Prevención");
        jButtonDetectarPaciente.setBorder(null);
        jButtonDetectarPaciente.setPreferredSize(new java.awt.Dimension(225, 50));
        jButtonDetectarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetectarPacienteActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonDetectarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 225, 50));

        jButtonHistorialMedico.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonHistorialMedico.setForeground(new java.awt.Color(51, 153, 255));
        jButtonHistorialMedico.setText("Visualizar Historial");
        jButtonHistorialMedico.setBorder(null);
        jButtonHistorialMedico.setPreferredSize(new java.awt.Dimension(225, 50));
        jButtonHistorialMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHistorialMedicoActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonHistorialMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 225, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 225, 660));

        jPanelVista.setBackground(new java.awt.Color(255, 255, 255));
        jPanelVista.setPreferredSize(new java.awt.Dimension(570, 660));
        jPanelVista.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanelVistaLayout = new javax.swing.GroupLayout(jPanelVista);
        jPanelVista.setLayout(jPanelVistaLayout);
        jPanelVistaLayout.setHorizontalGroup(
            jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanelVistaLayout.setVerticalGroup(
            jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelVista, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 570, 660));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea salir?", "Confirmar salida",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (mongoClient != null) {
                mongoClient.close();
            }
            System.exit(0);
        }
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jLabel2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2AncestorAdded

    private void jButtonDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDatosActionPerformed
    datospacientejpanel.setSize(jPanelVista.getSize());
    datospacientejpanel.setLocation(0, 0);
    jPanelVista.removeAll();
    jPanelVista.add(datospacientejpanel);
    jPanelVista.revalidate();
    jPanelVista.repaint();
    }//GEN-LAST:event_jButtonDatosActionPerformed

    private void jButtonTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTratamientoActionPerformed
        Generar_Tratamiento tratamiento = new Generar_Tratamiento(mongoClient, database, collection);
        tratamiento.setSize(jPanelVista.getSize());
        tratamiento.setLocation(0, 0);
        jPanelVista.removeAll();
        jPanelVista.add(tratamiento);
        jPanelVista.revalidate();
        jPanelVista.repaint();
    }//GEN-LAST:event_jButtonTratamientoActionPerformed

    private void jButtonDiagnosticarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDiagnosticarPacienteActionPerformed
    Diagnosticar_PEC diagnostico = new Diagnosticar_PEC(mongoClient, database, collection);
    diagnostico.setSize(jPanelVista.getSize());
    diagnostico.setLocation(0, 0);
    jPanelVista.removeAll();
    jPanelVista.add(diagnostico);
    jPanelVista.revalidate();
    jPanelVista.repaint();
    }//GEN-LAST:event_jButtonDiagnosticarPacienteActionPerformed

    private void jButtonDetectarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetectarPacienteActionPerformed
        Generar_Prevencion detectar = new Generar_Prevencion(mongoClient, database, collection);
        detectar.setSize(jPanelVista.getSize());
        detectar.setLocation(0, 0);
        jPanelVista.removeAll();
        jPanelVista.add(detectar);
        jPanelVista.revalidate();
        jPanelVista.repaint();
    }//GEN-LAST:event_jButtonDetectarPacienteActionPerformed

    private void jButtonHistorialMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHistorialMedicoActionPerformed
        Visualizar_Historial historial = new Visualizar_Historial(mongoClient, database, collection);
        historial.setSize(jPanelVista.getSize());
        historial.setLocation(0, 0);
        jPanelVista.removeAll();
        jPanelVista.add(historial);
        jPanelVista.revalidate();
        jPanelVista.repaint();
    }//GEN-LAST:event_jButtonHistorialMedicoActionPerformed

    public void mostrarPanelJVista() {

        // Limpiar el contenido actual (si es necesario)
        getContentPane().removeAll();

        // Agregar el PanelJVista al JFrame
        getContentPane().add(jPanelVista);

        // Revalidar y repintar el JFrame para mostrar el nuevo panel
        revalidate();
        repaint();
    }

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
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDatos;
    private javax.swing.JButton jButtonDetectarPaciente;
    private javax.swing.JButton jButtonDiagnosticarPaciente;
    private javax.swing.JButton jButtonHistorialMedico;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonTratamiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelVista;
    // End of variables declaration//GEN-END:variables
}
