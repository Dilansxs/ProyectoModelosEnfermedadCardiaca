package frontend;

import backend.MongoDB;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import javax.swing.JOptionPane;

/**
 *
 * @autor toapa
 */
public class Ingresar_Datos_EstiloVida extends javax.swing.JPanel {

    private final MongoDB datosPaciente;
    private final MongoCollection<Document> collection;

    /**
     * Creates new form EstiloVidaJPanel
     * @param mongoClient
     * @param database
     * @param collection
     */
    public Ingresar_Datos_EstiloVida(MongoClient mongoClient, MongoDatabase database, MongoCollection<Document> collection) {
        this.collection = collection;        
        initComponents();
        datosPaciente = new MongoDB();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonEliminar = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxSufresMareos = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxNivelEstres = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jComboBoxHorasSuenio = new javax.swing.JComboBox<>();
        jComboBoxActividadFisica = new javax.swing.JComboBox<>();
        jComboBoxAlimentacion = new javax.swing.JComboBox<>();
        jComboBoxCalidadSuenio = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jComboBoxDificultadRespirar = new javax.swing.JComboBox<>();
        jComboBoxDolorPecho = new javax.swing.JComboBox<>();

        jLabel2.setText("jLabel2");

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(570, 660));
        setPreferredSize(new java.awt.Dimension(570, 660));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 162, 30));

        jButtonBuscar.setForeground(new java.awt.Color(0, 153, 255));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 70, 30));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("SÍNTOMAS ACTUALES");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        jButtonEliminar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(0, 153, 204));
        jButtonEliminar.setText("Eliminar Datos");
        jButtonEliminar.setPreferredSize(new java.awt.Dimension(180, 32));
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, -1, -1));

        jButtonRegistrar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(0, 153, 204));
        jButtonRegistrar.setText("Registrar Paciente");
        jButtonRegistrar.setPreferredSize(new java.awt.Dimension(180, 32));
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 204));
        jLabel12.setText("¿Sientes dolor en el pecho?");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, -1, -1));

        jComboBoxSufresMareos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "No", "Si" }));
        add(jComboBoxSufresMareos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, 50, 20));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 204));
        jLabel15.setText("(Bajo 0 -  Alto 5):");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 204));
        jLabel16.setText("Actividad Física (Dia x Semana):");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 204));
        jLabel17.setText("Horas de sueño (Horas):");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 204));
        jLabel18.setText("Calidad de sueño");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setText("ESTILO DE VIDA");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 204));
        jLabel19.setText("Nivel de estrés");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 90, -1));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 204));
        jLabel13.setText("¿Tienes dificultades para respirar?");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, -1, -1));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 204));
        jLabel14.setText("¿Sufres de mareos o desmayos?");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, -1, -1));

        jComboBoxNivelEstres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "0", "1", "2", "3", "4", "5" }));
        add(jComboBoxNivelEstres, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 120, 30));

        jLabel20.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 204));
        jLabel20.setText("Alimentación adecuada ");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        jComboBoxHorasSuenio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "0 horas", "1 a 3 horas", "3 a 5 horas", "5 a 7 horas", "7 a 10 horas", "más de 10 horas" }));
        add(jComboBoxHorasSuenio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 120, 30));

        jComboBoxActividadFisica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "0 días", "1 a 3 días", "3 a 5 días", "5 a 7 días" }));
        add(jComboBoxActividadFisica, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 120, 30));

        jComboBoxAlimentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "1", "2", "3", "4", "5" }));
        add(jComboBoxAlimentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 120, 30));

        jComboBoxCalidadSuenio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "1", "2", "3", "4", "5" }));
        add(jComboBoxCalidadSuenio, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 120, 30));

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 153, 204));
        jLabel21.setText("(Mala 1 -  Adecuada 5):");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        jLabel22.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 204));
        jLabel22.setText("(Mala 1 -  Excelente 5):");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, -1, -1));

        jComboBoxDificultadRespirar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "No", "Si" }));
        add(jComboBoxDificultadRespirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 50, 20));

        jComboBoxDolorPecho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "No", "Si" }));
        add(jComboBoxDolorPecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 50, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
// Perform search
        String cedula = jTextFieldBuscar.getText();
        if (cedula.length() != 10 || !cedula.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cédula debe contener 10 dígitos numéricos", "Cédula Inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Document paciente = datosPaciente.buscarEstiloVidaPorCedula(cedula);

        if (paciente != null) {
            // Populate input fields with patient data
            jComboBoxActividadFisica.setSelectedItem(paciente.getString("actividadFisica"));
            jComboBoxAlimentacion.setSelectedItem(paciente.getString("alimentacion"));
            jComboBoxHorasSuenio.setSelectedItem(paciente.getString("horasSuenio"));
            jComboBoxCalidadSuenio.setSelectedItem(paciente.getString("calidadSuenio"));
            jComboBoxNivelEstres.setSelectedItem(paciente.getString("nivelEstres"));
            jComboBoxDolorPecho.setSelectedItem(paciente.getString("dolorPecho"));
            jComboBoxDificultadRespirar.setSelectedItem(paciente.getString("dificultadRespirar"));
            jComboBoxSufresMareos.setSelectedItem(paciente.getString("mareosDesmayos"));
            JOptionPane.showMessageDialog(this, "Datos del paciente encontrados.");
        } else {
            JOptionPane.showMessageDialog(this, "Paciente no encontrado.");
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
       int option = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar los datos del paciente?", "Eliminar Datos", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Eliminar el documento correspondiente en MongoDB
            collection.deleteOne(new Document("cedula", jTextFieldBuscar.getText().trim()));

            // Limpiar los campos del formulario
            jTextFieldBuscar.setText("");
            jComboBoxActividadFisica.setSelectedIndex(0);
            jComboBoxHorasSuenio.setSelectedIndex(0);
            jComboBoxCalidadSuenio.setSelectedIndex(0);
            jComboBoxAlimentacion.setSelectedIndex(0);
            jComboBoxNivelEstres.setSelectedIndex(0);
            jComboBoxDolorPecho.setSelectedIndex(0);
            jComboBoxDificultadRespirar.setSelectedIndex(0);
            jComboBoxSufresMareos.setSelectedIndex(0);

            JOptionPane.showMessageDialog(null, "Datos del paciente eliminados correctamente.");
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        String cedula = jTextFieldBuscar.getText().trim();
        String actividad_fisica = (String) jComboBoxActividadFisica.getSelectedItem();
        String horas_suenio = (String) jComboBoxHorasSuenio.getSelectedItem();
        String calidad_suenio = (String) jComboBoxCalidadSuenio.getSelectedItem();
        String alimentacion_adecuada = (String) jComboBoxAlimentacion.getSelectedItem();
        String nivel_estres = (String) jComboBoxNivelEstres.getSelectedItem();
        String dolor_pecho = (String) jComboBoxDolorPecho.getSelectedItem();
        String dificultades_respirar = (String) jComboBoxDificultadRespirar.getSelectedItem();
        String mareos_desmayos = (String) jComboBoxSufresMareos.getSelectedItem();
        // Create a Document to store data

        // Insert data into the database
        datosPaciente.insertarEstiloVida(cedula,actividad_fisica, alimentacion_adecuada, horas_suenio, calidad_suenio, nivel_estres, dolor_pecho, dificultades_respirar, mareos_desmayos);
        JOptionPane.showMessageDialog(this, "Datos del paciente registrados exitosamente.");

    }//GEN-LAST:event_jButtonRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JComboBox<String> jComboBoxActividadFisica;
    private javax.swing.JComboBox<String> jComboBoxAlimentacion;
    private javax.swing.JComboBox<String> jComboBoxCalidadSuenio;
    private javax.swing.JComboBox<String> jComboBoxDificultadRespirar;
    private javax.swing.JComboBox<String> jComboBoxDolorPecho;
    private javax.swing.JComboBox<String> jComboBoxHorasSuenio;
    private javax.swing.JComboBox<String> jComboBoxNivelEstres;
    private javax.swing.JComboBox<String> jComboBoxSufresMareos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
