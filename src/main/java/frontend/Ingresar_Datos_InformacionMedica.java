package frontend;

import backend.MongoDB;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;

public class Ingresar_Datos_InformacionMedica extends javax.swing.JPanel {

    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;
    private final MongoDB informacionmedica;

    public Ingresar_Datos_InformacionMedica(MongoClient mongoClient, MongoDatabase database, MongoCollection<Document> collection) {
        initComponents();
        informacionmedica = new MongoDB();
        this.mongoClient = mongoClient;
        this.database = database;
        this.collection = collection;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldMedicamentos = new javax.swing.JTextField();
        jTextFieldAlergias = new javax.swing.JTextField();
        jTextFieldPeso = new javax.swing.JTextField();
        jTextFieldAltura = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonEliminar = new javax.swing.JButton();
        jButtonSiguiente = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldAntecedentesFamiliares = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldEnfermedadesDiagnosticadas = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxPadecimientos = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxConsumoAlcohol = new javax.swing.JComboBox<>();
        jComboBoxConsumoTabaco = new javax.swing.JComboBox<>();

        jLabel2.setText("jLabel2");

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(570, 660));
        setPreferredSize(new java.awt.Dimension(570, 660));

        jButtonBuscar.setForeground(new java.awt.Color(0, 153, 255));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("INFORMACION MEDICA");

        jTextFieldMedicamentos.setText("Si/No (Describa)");
        jTextFieldMedicamentos.setPreferredSize(new java.awt.Dimension(180, 32));

        jTextFieldAlergias.setText("Si/No (Describa)");
        jTextFieldAlergias.setPreferredSize(new java.awt.Dimension(180, 32));

        jTextFieldPeso.setPreferredSize(new java.awt.Dimension(180, 32));

        jTextFieldAltura.setPreferredSize(new java.awt.Dimension(180, 32));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setText("Medicación actual del Paciente:");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 204));
        jLabel6.setText("Alergias del Paciente:");

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 204));
        jLabel7.setText("Altura (en cm):");

        jButtonEliminar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(0, 153, 204));
        jButtonEliminar.setText("Eliminar Datos");
        jButtonEliminar.setPreferredSize(new java.awt.Dimension(180, 32));
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonSiguiente.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonSiguiente.setForeground(new java.awt.Color(0, 153, 204));
        jButtonSiguiente.setText("Siguiente");
        jButtonSiguiente.setPreferredSize(new java.awt.Dimension(180, 32));
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 204));
        jLabel12.setText("Padecimientos:");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 204));
        jLabel8.setText("Enfermedades Cardíacas Diagnosticadas:");

        jTextFieldAntecedentesFamiliares.setText("Si/No (Describa)");
        jTextFieldAntecedentesFamiliares.setPreferredSize(new java.awt.Dimension(180, 32));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 204));
        jLabel14.setText("Antecedentes Familiares Enfermedad Cardíaca:");

        jTextFieldEnfermedadesDiagnosticadas.setText("Si/No (Describa)");
        jTextFieldEnfermedadesDiagnosticadas.setPreferredSize(new java.awt.Dimension(180, 32));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 204));
        jLabel13.setText("Peso (en Kg):");

        jComboBoxPadecimientos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Ninguna", "Diabétes", "Coresterol Alto", "Hipertension", "Otro", " ", " " }));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 204));
        jLabel15.setText("Consumo de Alcohol (Dia x Semana):");

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 204));
        jLabel16.setText("Consumo de Tabaco (Dia x Semana):");

        jComboBoxConsumoAlcohol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "0 días", "1 a 3 días", "3 a 5 días", "5 a 7 días" }));

        jComboBoxConsumoTabaco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "0 días", "1 a 3 días", "3 a 5 días", "5 a 7 días" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addGap(25, 25, 25)
                        .addComponent(jTextFieldAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel13)
                        .addGap(17, 17, 17)
                        .addComponent(jTextFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel7)
                        .addGap(13, 13, 13)
                        .addComponent(jTextFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addGap(11, 11, 11)
                        .addComponent(jTextFieldMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jTextFieldEnfermedadesDiagnosticadas, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jTextFieldAntecedentesFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel12)
                        .addGap(9, 9, 9)
                        .addComponent(jComboBoxPadecimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel15))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jComboBoxConsumoTabaco, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxConsumoAlcohol, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6))
                    .addComponent(jTextFieldAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4))
                    .addComponent(jTextFieldMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(14, 14, 14)
                .addComponent(jTextFieldEnfermedadesDiagnosticadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(14, 14, 14)
                .addComponent(jTextFieldAntecedentesFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxPadecimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxConsumoTabaco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxConsumoAlcohol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String cedula = jTextFieldBuscar.getText();
        if (cedula.length() != 10 || !cedula.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cédula debe contener 10 dígitos numéricos", "Cédula Inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de cédula válido.");
            return;
        }

        Document doc = informacionmedica.buscarInformacionMedicaPorCedula(cedula);

        if (doc == null) {
            JOptionPane.showMessageDialog(this, "No se encontró un paciente con la cédula proporcionada.");
            return;
        }

        // Actualizar los campos de texto con la información del documento
        jTextFieldAlergias.setText(doc.getString("alergias"));
        jTextFieldPeso.setText(doc.getString("peso"));
        jTextFieldAltura.setText(doc.getString("altura"));
        jTextFieldMedicamentos.setText(doc.getString("medicacion"));
        jTextFieldEnfermedadesDiagnosticadas.setText(doc.getString("enfermedadesCardiacas"));
        jTextFieldAntecedentesFamiliares.setText(doc.getString("antecedentesFamiliares"));
        jComboBoxPadecimientos.setSelectedItem(doc.getString("padecimientos"));
        jComboBoxConsumoTabaco.setSelectedItem(doc.getString("consumoTabaco"));
        jComboBoxConsumoAlcohol.setSelectedItem(doc.getString("consumoAlcohol"));

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar los datos del paciente?", "Eliminar Datos", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Eliminar el documento correspondiente en MongoDB
            collection.deleteOne(new Document("cedula", jTextFieldBuscar.getText().trim()));

            // Limpiar los campos del formulario
            jTextFieldBuscar.setText("");
            jTextFieldAlergias.setText("");
            jTextFieldMedicamentos.setText("");
            jTextFieldPeso.setText("");
            jTextFieldAltura.setText("");
            jTextFieldEnfermedadesDiagnosticadas.setText("");
            jTextFieldAntecedentesFamiliares.setText("");
            jComboBoxPadecimientos.setSelectedIndex(0);
            jComboBoxConsumoTabaco.setSelectedIndex(0);
            jComboBoxConsumoAlcohol.setSelectedIndex(0);

            JOptionPane.showMessageDialog(null, "Datos del paciente eliminados correctamente.");
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed

// Obtener los valores de los campos de texto y combobox
        String cedula = jTextFieldBuscar.getText().trim();
        String alergias = jTextFieldAlergias.getText().trim();
        String peso = jTextFieldPeso.getText().trim();
        String altura = jTextFieldAltura.getText().trim();
        String medicamentos = jTextFieldMedicamentos.getText().trim();
        String enfermedadesDiagnosticadas = jTextFieldEnfermedadesDiagnosticadas.getText().trim();
        String antecedentesFamiliares = jTextFieldAntecedentesFamiliares.getText().trim();
        String padecimientos = (String) jComboBoxPadecimientos.getSelectedItem().toString();
        String consumoTabaco = (String) jComboBoxConsumoTabaco.getSelectedItem().toString();
        String consumoAlcohol = (String) jComboBoxConsumoAlcohol.getSelectedItem().toString();
        boolean insertado = informacionmedica.insertarInformacionMedica(cedula, alergias, peso, altura, medicamentos, enfermedadesDiagnosticadas, antecedentesFamiliares, padecimientos, consumoTabaco, consumoAlcohol);

// Validaciones
    if (peso.length() > 3 || !peso.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "El registro debe contener un máximo de 3 dígitos numéricos", "Peso Inválido", JOptionPane.WARNING_MESSAGE);
        return;
    }
    if (altura.length() > 3 || !altura.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "El registro debe contener un máximo de 3 dígitos numéricos", "Altura Inválida", JOptionPane.WARNING_MESSAGE);
        return;
    }


    // Limpiar campos después de guardar
    limpiarCampos();

    // Cambiar al panel de Estilo de Vida
    JPanel jVistaPanel = (JPanel) this.getParent();
    Ingresar_Datos_EstiloVida estiloVidaPanel = new Ingresar_Datos_EstiloVida(mongoClient, database, collection);
    jVistaPanel.remove(this);
    jVistaPanel.add(estiloVidaPanel);
    jVistaPanel.revalidate();
    jVistaPanel.repaint();
    estiloVidaPanel.setSize(jVistaPanel.getSize());
    estiloVidaPanel.setLocation(0, 0);
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

    // Método para limpiar campos después de guardar
    private void limpiarCampos() {
        jTextFieldBuscar.setText("");
        jTextFieldAlergias.setText("Si/No (Describa)");
        jTextFieldMedicamentos.setText("Si/No (Describa)");
        jTextFieldPeso.setText("");
        jTextFieldAltura.setText("");
        jTextFieldEnfermedadesDiagnosticadas.setText("Si/No (Describa)");
        jTextFieldAntecedentesFamiliares.setText("Si/No (Describa)");
        jComboBoxPadecimientos.setSelectedIndex(0);
        jComboBoxConsumoAlcohol.setSelectedIndex(0);
        jComboBoxConsumoTabaco.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JComboBox<String> jComboBoxConsumoAlcohol;
    private javax.swing.JComboBox<String> jComboBoxConsumoTabaco;
    private javax.swing.JComboBox<String> jComboBoxPadecimientos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextFieldAlergias;
    private javax.swing.JTextField jTextFieldAltura;
    private javax.swing.JTextField jTextFieldAntecedentesFamiliares;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldEnfermedadesDiagnosticadas;
    private javax.swing.JTextField jTextFieldMedicamentos;
    private javax.swing.JTextField jTextFieldPeso;
    // End of variables declaration//GEN-END:variables
}
