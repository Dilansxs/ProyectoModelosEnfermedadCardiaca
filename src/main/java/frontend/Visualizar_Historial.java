package frontend;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author xpro3
 */
public class Visualizar_Historial extends javax.swing.JPanel {

    private final MongoCollection<Document> collection;
    private final DefaultTableModel tableModel;

    public Visualizar_Historial(MongoClient mongoClient, MongoDatabase database, MongoCollection<Document> collection) {
        this.collection = collection;
        initComponents();
        // Inicializar tableModel
        tableModel = (DefaultTableModel) jTableHistorialPaciente.getModel();
        // Cargar datos iniciales
        loadHistoriales();
    }

    private void loadDiagnosticoFromFile(String filePath) {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Hacer el JTextArea no editable
        textArea.setLineWrap(true);  // Ajustar el texto al ancho del JTextArea
        textArea.setWrapStyleWord(true); // Ajustar palabras completas

        try {
            // Leer el archivo con codificación UTF-8
            String content = Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
            textArea.setText(content); // Establecer el texto completo en el JTextArea
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar el diagnóstico desde el archivo: " + filePath, "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Ajustar el JTextArea al JScrollPane
        jScrollPaneHistorial.setViewportView(textArea);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldBuscarHistorial = new javax.swing.JTextField();
        jButtonBuscarHistorial = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistorialPaciente = new javax.swing.JTable();
        jButtonGenerarHistorial = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPaneHistorial = new javax.swing.JScrollPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jTextFieldBuscarHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 162, 30));

        jButtonBuscarHistorial.setForeground(new java.awt.Color(0, 153, 255));
        jButtonBuscarHistorial.setText("Buscar");
        jButtonBuscarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarHistorialActionPerformed(evt);
            }
        });
        add(jButtonBuscarHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 70, 30));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("Visualizar Historial Paciente");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jTableHistorialPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cédula", "Nombres y Apellidos", "Detección P/N"
            }
        ));
        jScrollPane1.setViewportView(jTableHistorialPaciente);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 510, 130));

        jButtonGenerarHistorial.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonGenerarHistorial.setForeground(new java.awt.Color(0, 153, 204));
        jButtonGenerarHistorial.setText("Generar Historial");
        jButtonGenerarHistorial.setPreferredSize(new java.awt.Dimension(180, 32));
        jButtonGenerarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarHistorialActionPerformed(evt);
            }
        });
        add(jButtonGenerarHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 610, -1, -1));

        jPanel1.setBackground(new java.awt.Color(228, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jScrollPaneHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 330));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 510, 350));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarHistorialActionPerformed
        String cedula = jTextFieldBuscarHistorial.getText();
        if (cedula.length() != 10 || !cedula.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cédula debe contener 10 dígitos numéricos", "Cédula Inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cedula.isEmpty()) {
            loadHistoriales(); // Reload all data if no search term
        } else {
            searchHistoriales(cedula);
        }
    }//GEN-LAST:event_jButtonBuscarHistorialActionPerformed

    private void jButtonGenerarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarHistorialActionPerformed
        String cedula = jTextFieldBuscarHistorial.getText().trim();
        if (!cedula.isEmpty()) {
            String filePath = "C:\\Users\\xpro3\\Documents\\PROYECT MODELOS\\paciente_" + cedula + "\\datos_" + cedula + ".txt";
            loadDiagnosticoFromFile(filePath);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cédula.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGenerarHistorialActionPerformed

    private void loadHistoriales() {
     List<Document> historiales = collection.find().into(new ArrayList<>());
    tableModel.setRowCount(0);
    int count = 1;

    for (Document historial : historiales) {
        String cedula = historial.getString("cedula");
        String diagnostico = "";
        String filePath = "C:\\Users\\xpro3\\Documents\\PROYECT MODELOS\\paciente_" + cedula + "\\diagnostico_" + cedula + ".txt";
        try {
            diagnostico = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8).trim();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de diagnóstico para la cédula " + cedula + ": " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            continue; // Saltar al siguiente historial si ocurre un error
        }

        // Determinar el valor para la columna "Detección P/N"
        String deteccion = "P/N";
        if (diagnostico.contains("SANO")) {
            deteccion = "Negativo";
        } else if (diagnostico.contains("MODERADA")) {
            deteccion = "En Observación";
        } else if (diagnostico.contains("GRAVE")) {
            deteccion = "Positivo";
        }

        tableModel.addRow(new Object[]{
            cedula,
            historial.getString("nombres"),
            deteccion
        });

        count++;
    }
    }

    private void searchHistoriales(String cedula) {
    Document historial = collection.find(Filters.eq("cedula", cedula)).first();
    tableModel.setRowCount(0); // Limpiar datos existentes
    if (historial != null) {
        // Leer el contenido del archivo de diagnóstico
        String diagnostico = "";
        String filePath = "C:\\Users\\xpro3\\Documents\\PROYECT MODELOS\\paciente_" + cedula + "\\diagnostico_" + cedula + ".txt";
        try {
            diagnostico = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8).trim();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de diagnóstico: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Determinar el valor para la columna "Detección P/N"
        String deteccion = "P/N";
        if (diagnostico.contains("SANO")) {
            deteccion = "Negativo";
        } else if (diagnostico.contains("MODERADA")) {
            deteccion = "En Observación";
        } else if (diagnostico.contains("GRAVE")) {
            deteccion = "Positivo";
        }

        tableModel.addRow(new Object[]{
            historial.getString("cedula"),
            historial.getString("nombres"),
            deteccion
        });
    } else {
        JOptionPane.showMessageDialog(this, "No se encontró historial para la cédula: " + cedula, "Error", JOptionPane.WARNING_MESSAGE);
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarHistorial;
    private javax.swing.JButton jButtonGenerarHistorial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneHistorial;
    private javax.swing.JTable jTableHistorialPaciente;
    private javax.swing.JTextField jTextFieldBuscarHistorial;
    // End of variables declaration//GEN-END:variables
}
