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
public class Generar_Prevencion extends javax.swing.JPanel {
    private final MongoCollection<Document> collection;
    private final DefaultTableModel tableModel;
    /**
     * Creates new form DetectarPacienteJPanel
     * @param mongoClient
     * @param database
     * @param collection
     */
    public Generar_Prevencion(MongoClient mongoClient, MongoDatabase database, MongoCollection<Document> collection) {
        this.collection = collection;  
        initComponents();
        
        tableModel = (DefaultTableModel) jTableDetectar.getModel();
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
    jScrollPaneDetectar.setViewportView(textArea);
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDetectarPaciente = new javax.swing.JLabel();
        jTextFieldBuscarDetectar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPaneDetectar = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetectar = new javax.swing.JTable();
        jButtonBuscarDetectar = new javax.swing.JButton();
        jButtonDetectar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabelDetectarPaciente.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabelDetectarPaciente.setForeground(new java.awt.Color(0, 153, 204));
        jLabelDetectarPaciente.setText("PREVENCIÓN PACIENTE");

        jPanel1.setBackground(new java.awt.Color(228, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jScrollPaneDetectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 330));

        jTableDetectar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableDetectar);

        jButtonBuscarDetectar.setForeground(new java.awt.Color(0, 153, 255));
        jButtonBuscarDetectar.setText("Buscar");
        jButtonBuscarDetectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarDetectarActionPerformed(evt);
            }
        });

        jButtonDetectar.setForeground(new java.awt.Color(0, 153, 255));
        jButtonDetectar.setText("Prevención");
        jButtonDetectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabelDetectarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButtonBuscarDetectar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldBuscarDetectar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jButtonDetectar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonBuscarDetectar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBuscarDetectar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabelDetectarPaciente)))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonDetectar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarDetectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarDetectarActionPerformed
                String cedula = jTextFieldBuscarDetectar.getText();
                if (cedula.length() != 10 || !cedula.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cédula debe contener 10 dígitos numéricos", "Cédula Inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cedula.isEmpty()) {
            loadHistoriales(); // Reload all data if no search term
        } else {
            searchHistoriales(cedula);
        }
    }//GEN-LAST:event_jButtonBuscarDetectarActionPerformed

    private void jButtonDetectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetectarActionPerformed
        String cedula = jTextFieldBuscarDetectar.getText().trim();
    if (!cedula.isEmpty()) {
        String filePath = "C:\\Users\\xpro3\\Documents\\PROYECT MODELOS\\paciente_" + cedula + "\\prevencion_" + cedula + ".txt";
        loadDiagnosticoFromFile(filePath);
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese una cédula.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jButtonDetectarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarDetectar;
    private javax.swing.JButton jButtonDetectar;
    private javax.swing.JLabel jLabelDetectarPaciente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneDetectar;
    private javax.swing.JTable jTableDetectar;
    private javax.swing.JTextField jTextFieldBuscarDetectar;
    // End of variables declaration//GEN-END:variables
}
