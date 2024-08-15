/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author xpro3
 */
public class Diagnosticar_PEC extends javax.swing.JPanel {

    private final MongoCollection<Document> collection;
    private final DefaultTableModel tableModel;

    /**
     * Creates new form DiagnosticoPacienteJPanel
     *
     * @param mongoClient
     * @param database
     * @param collection
     */
    public Diagnosticar_PEC(MongoClient mongoClient, MongoDatabase database, MongoCollection<Document> collection) {
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
        jScrollPaneDiagnostico.setViewportView(textArea);
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

        jLabel1 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPaneDiagnostico = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistorialPaciente = new javax.swing.JTable();
        jButtonBuscar1 = new javax.swing.JButton();
        jButtonDiagnostico = new javax.swing.JButton();
        jLabelResonancia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(570, 660));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("Resonancia Magnética del Paciente (Ejemplo Simulado)");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));
        add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 162, 30));

        jPanel1.setBackground(new java.awt.Color(228, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPaneDiagnostico.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneDiagnostico.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPaneDiagnostico.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jPanel1.add(jScrollPaneDiagnostico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 170));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 510, 190));

        jTableHistorialPaciente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 510, 110));

        jButtonBuscar1.setForeground(new java.awt.Color(0, 153, 255));
        jButtonBuscar1.setText("Buscar");
        jButtonBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscar1ActionPerformed(evt);
            }
        });
        add(jButtonBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 70, 30));

        jButtonDiagnostico.setForeground(new java.awt.Color(0, 153, 255));
        jButtonDiagnostico.setText("Diagnóstico");
        jButtonDiagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDiagnosticoActionPerformed(evt);
            }
        });
        add(jButtonDiagnostico, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 620, 140, 30));
        add(jLabelResonancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 210, 200));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 204));
        jLabel2.setText("DIAGNÓSTICO DEL PACIENTE");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDiagnosticoActionPerformed
    String cedula = jTextFieldBuscar.getText().trim();
    if (!cedula.isEmpty()) {
        String filePath = "C:\\Users\\xpro3\\Documents\\PROYECT MODELOS\\paciente_" + cedula + "\\diagnostico_" + cedula + ".txt";
        loadDiagnosticoFromFile(filePath);
        // Leer el contenido del archivo
        String diagnostico = "";
        try {
            diagnostico = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8).trim();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de diagnóstico: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Definir el path de la imagen basado en el diagnóstico
        String imagePath = "";
        if (diagnostico.contains("MODERADA")) {
            imagePath = "C:\\Users\\xpro3\\Documents\\PROYECT MODELOS\\machineZ\\src\\main\\java\\resonancias\\MODERADA.png";
        } else if (diagnostico.contains("GRAVE")) {
            imagePath = "C:\\Users\\xpro3\\Documents\\PROYECT MODELOS\\machineZ\\src\\main\\java\\resonancias\\GRAVE.png";
        } else if (diagnostico.contains("SANO")) {
            imagePath = "C:\\Users\\xpro3\\Documents\\PROYECT MODELOS\\machineZ\\src\\main\\java\\resonancias\\SANO.png";
        } else {
            JOptionPane.showMessageDialog(this, "El diagnóstico no contiene una palabra válida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Cargar la imagen en jLabelResonancia
        try {
            File file = new File(imagePath);
            if (!file.exists()) {
                throw new FileNotFoundException("Archivo de imagen no encontrado: " + imagePath);
            }
            
            ImageIcon imageIcon = new ImageIcon(imagePath);
            
            // Redimensionar la imagen para ajustarla a la etiqueta si es necesario
            Image image = imageIcon.getImage();
            Image newImg = image.getScaledInstance(jLabelResonancia.getWidth(), jLabelResonancia.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newImg);
            
            // Establecer la imagen en la etiqueta
            jLabelResonancia.setIcon(imageIcon);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar la imagen: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    } else {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese una cédula.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    }//GEN-LAST:event_jButtonDiagnosticoActionPerformed

    private void jButtonBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscar1ActionPerformed
        String cedula = jTextFieldBuscar.getText().trim();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar1;
    private javax.swing.JButton jButtonDiagnostico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelResonancia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneDiagnostico;
    private javax.swing.JTable jTableHistorialPaciente;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
