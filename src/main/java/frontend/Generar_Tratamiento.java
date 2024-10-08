/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
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
public class Generar_Tratamiento extends javax.swing.JPanel {
    private final MongoCollection<Document> collection;
    private final DefaultTableModel tableModel;
    /**
     * Creates new form TratamientoPacienteJPanel
     * @param mongoClient
     * @param database
     * @param collection
     */
    public Generar_Tratamiento(MongoClient mongoClient, MongoDatabase database, MongoCollection<Document> collection) {
        this.collection = collection;  
        initComponents();
        
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
    jScrollPaneTratamiento.setViewportView(textArea);
}
    
    
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTratamientoPaciente = new javax.swing.JLabel();
        jTextFieldBuscarTratamiento = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPaneTratamiento = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistorialPaciente = new javax.swing.JTable();
        jButtonBuscar1 = new javax.swing.JButton();
        jButtonTratamiento = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTratamientoPaciente.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabelTratamientoPaciente.setForeground(new java.awt.Color(0, 153, 204));
        jLabelTratamientoPaciente.setText("TRATAMIENTO PACIENTE");
        add(jLabelTratamientoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jTextFieldBuscarTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarTratamientoActionPerformed(evt);
            }
        });
        add(jTextFieldBuscarTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 162, 30));

        jPanel1.setBackground(new java.awt.Color(228, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jScrollPaneTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 330));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 510, 350));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 510, 110));

        jButtonBuscar1.setForeground(new java.awt.Color(0, 153, 255));
        jButtonBuscar1.setText("Buscar");
        jButtonBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscar1ActionPerformed(evt);
            }
        });
        add(jButtonBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 70, 30));

        jButtonTratamiento.setForeground(new java.awt.Color(0, 153, 255));
        jButtonTratamiento.setText("Tratamiento");
        jButtonTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTratamientoActionPerformed(evt);
            }
        });
        add(jButtonTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 600, 140, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscar1ActionPerformed
        String cedula = jTextFieldBuscarTratamiento.getText();
        if (cedula.length() != 10 || !cedula.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cédula debe contener 10 dígitos numéricos", "Cédula Inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cedula.isEmpty()) {
            loadHistoriales(); // Reload all data if no search term
        } else {
            searchHistoriales(cedula);
        }
    }//GEN-LAST:event_jButtonBuscar1ActionPerformed
    
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
    
    
    private void jButtonTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTratamientoActionPerformed
        String cedula = jTextFieldBuscarTratamiento.getText().trim();
    if (!cedula.isEmpty()) {
        String filePath = "C:\\Users\\xpro3\\Documents\\PROYECT MODELOS\\paciente_" + cedula + "\\tratamiento_" + cedula + ".txt";
        loadDiagnosticoFromFile(filePath);
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese una cédula.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jButtonTratamientoActionPerformed

    private void jTextFieldBuscarTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarTratamientoActionPerformed
        String cedula = jTextFieldBuscarTratamiento.getText();
        if (cedula.isEmpty()) {
            loadHistoriales(); // Reload all data if no search term
        } else {
            searchHistoriales(cedula);
        }
    }//GEN-LAST:event_jTextFieldBuscarTratamientoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar1;
    private javax.swing.JButton jButtonTratamiento;
    private javax.swing.JLabel jLabelTratamientoPaciente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneTratamiento;
    private javax.swing.JTable jTableHistorialPaciente;
    private javax.swing.JTextField jTextFieldBuscarTratamiento;
    // End of variables declaration//GEN-END:variables
}
