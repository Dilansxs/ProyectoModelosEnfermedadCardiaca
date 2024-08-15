package frontend;

import backend.MongoDB;
import javax.swing.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bson.Document;


public class Ingresar_Datos extends javax.swing.JPanel {
    public String getFechaNacimiento() {
        return jTextFieldFechaNacimiento.getText();
    }

    public void setFechaNacimiento(String fecha) {
        jTextFieldFechaNacimiento.setText(fecha);
    }
    private final MongoDB datosPaciente;
    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public Ingresar_Datos(MongoClient mongoClient, MongoDatabase database, MongoCollection<Document> collection) {
        initComponents();
        datosPaciente = new MongoDB();
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
        jTextFieldCarrera = new javax.swing.JTextField();
        jTextFieldNombres = new javax.swing.JTextField();
        jTextFieldCedula = new javax.swing.JTextField();
        jTextFieldIdEstudiante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButtonEliminar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxEtnia = new javax.swing.JComboBox<>();
        jTextFieldFechaNacimiento = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxGenero = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButtonSiguiente2 = new javax.swing.JButton();
        jButtonCalendar = new javax.swing.JButton();

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
        jLabel1.setText("DATOS DEL PACIENTE");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jTextFieldCarrera.setPreferredSize(new java.awt.Dimension(180, 32));
        add(jTextFieldCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 200, -1));

        jTextFieldNombres.setPreferredSize(new java.awt.Dimension(180, 32));
        add(jTextFieldNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 200, -1));

        jTextFieldCedula.setPreferredSize(new java.awt.Dimension(180, 32));
        add(jTextFieldCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 200, -1));

        jTextFieldIdEstudiante.setPreferredSize(new java.awt.Dimension(180, 32));
        add(jTextFieldIdEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 200, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setText("Carrera:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 204));
        jLabel6.setText("Nombres Completos (Nombres/Apellidos):");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 204));
        jLabel7.setText("ID del Estudiante:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 204));
        jLabel9.setText("Etnia:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 40, -1));

        jButtonEliminar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(0, 153, 204));
        jButtonEliminar.setText("Eliminar Datos");
        jButtonEliminar.setPreferredSize(new java.awt.Dimension(180, 32));
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 204));
        jLabel12.setText("Cédula:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        jComboBoxEtnia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Mestizo", "Afrodescendiente", "Blanco", "Indígena", "Otros" }));
        add(jComboBoxEtnia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, 100, -1));

        jTextFieldFechaNacimiento.setText("00-00-0000");
        add(jTextFieldFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 90, -1));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 204));
        jLabel15.setText("Género:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 60, -1));

        jComboBoxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Masculino", "Femenino", " " }));
        add(jComboBoxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 100, 20));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 204));
        jLabel8.setText("Dirección:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, -1, -1));

        jTextFieldDireccion.setPreferredSize(new java.awt.Dimension(180, 32));
        add(jTextFieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 200, -1));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 204));
        jLabel14.setText("Número de Teléfono:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, -1, -1));

        jTextFieldTelefono.setPreferredSize(new java.awt.Dimension(180, 32));
        add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 200, -1));

        jTextFieldEmail.setPreferredSize(new java.awt.Dimension(180, 32));
        add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 200, 32));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 204));
        jLabel10.setText("Email:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        jButtonSiguiente2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButtonSiguiente2.setForeground(new java.awt.Color(0, 153, 204));
        jButtonSiguiente2.setText("Siguiente");
        jButtonSiguiente2.setPreferredSize(new java.awt.Dimension(180, 32));
        jButtonSiguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguiente2ActionPerformed(evt);
            }
        });
        add(jButtonSiguiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 580, -1, -1));

        jButtonCalendar.setForeground(new java.awt.Color(0, 153, 204));
        jButtonCalendar.setText("Fecha Nacimiento:");
        jButtonCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalendarActionPerformed(evt);
            }
        });
        add(jButtonCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String cedula = jTextFieldBuscar.getText().trim();
        if (cedula.length() != 10 || !cedula.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cédula debe contener 10 dígitos numéricos", "Cédula Inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!cedula.isEmpty()) {
            // Realizar búsqueda por cédula utilizando la clase MongoDB
            Document paciente = datosPaciente.buscarPacientePorCedula(cedula);
            if (paciente != null) {
                // Mostrar datos del paciente encontrado en los campos correspondientes
                jTextFieldEmail.setText(paciente.getString("email"));
                jTextFieldNombres.setText(paciente.getString("nombres"));
                jTextFieldCedula.setText(paciente.getString("cedula"));
                jTextFieldIdEstudiante.setText(paciente.getString("idEstudiante"));
                jTextFieldCarrera.setText(paciente.getString("carrera"));
                jTextFieldFechaNacimiento.setText(paciente.getString("fechaNacimiento"));
                jComboBoxGenero.setSelectedItem(paciente.getString("genero"));
                jComboBoxEtnia.setSelectedItem(paciente.getString("etnia"));
                jTextFieldDireccion.setText(paciente.getString("direccion"));
                jTextFieldTelefono.setText(paciente.getString("telefono"));
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún paciente con esa cédula.", "Búsqueda de Paciente", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese la cédula del paciente.", "Búsqueda de Paciente", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        String cedula = jTextFieldBuscar.getText().trim();
        if (!cedula.isEmpty()) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar los datos del paciente?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Realizar eliminación por cédula utilizando la clase MongoDB
                boolean eliminado = datosPaciente.eliminarPacientePorCedula(cedula);
                if (eliminado) {
                    JOptionPane.showMessageDialog(this, "Los datos del paciente han sido eliminados correctamente.", "Eliminación de Paciente", JOptionPane.INFORMATION_MESSAGE);
                    // Limpiar los campos después de eliminar
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún paciente con esa cédula para eliminar.", "Eliminación de Paciente", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese la cédula del paciente para eliminar.", "Eliminación de Paciente", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonSiguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguiente2ActionPerformed
// Obtener datos del formulario
        String email = jTextFieldEmail.getText().trim();
        String nombres = jTextFieldNombres.getText().trim().toUpperCase();
        String cedula = jTextFieldCedula.getText().trim();
        String idEstudiante = jTextFieldIdEstudiante.getText().trim().toUpperCase();
        String carrera = jTextFieldCarrera.getText().trim().toUpperCase();
        String fechaNacimiento = jTextFieldFechaNacimiento.getText().trim();
        String genero = jComboBoxGenero.getSelectedItem().toString();
        String etnia = jComboBoxEtnia.getSelectedItem().toString();
        String direccion = jTextFieldDireccion.getText().trim().toUpperCase();
        String telefono = jTextFieldTelefono.getText().trim();
           
        
// Validar correo institucional
        if (!email.endsWith("@espe.edu.ec")) {
            JOptionPane.showMessageDialog(this, "Ingrese su correo.espe.edu.ec", "Correo Inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }

// Validar longitud y contenido de la cédula
        if (cedula.length() != 10 || !cedula.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El registro debe contener 10 dígitos numéricos", "Cédula Inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }

// Validar longitud y contenido del ID de estudiante
        if (idEstudiante.length() != 9 || !idEstudiante.matches("[A-Z0-9]+")) {
            JOptionPane.showMessageDialog(this, "El registro debe contener 9 dígitos numéricos", "ID de Estudiante Inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }

// Validar longitud y contenido del número de teléfono
        if (telefono.length() != 10 || !telefono.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El registro debe contener 10 dígitos numéricos", "Número de Teléfono Inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }

// Validar que todos los campos obligatorios estén llenos
        if (email.isEmpty() || nombres.isEmpty() || cedula.isEmpty() || idEstudiante.isEmpty() || carrera.isEmpty()
                || fechaNacimiento.isEmpty() || genero.isEmpty() || etnia.isEmpty()
                || direccion.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Guardar Paciente", JOptionPane.WARNING_MESSAGE);
            return;
        }

// Verificar si el paciente ya existe en la base de datos
        Document pacienteExistente = datosPaciente.buscarPacientePorCedula(cedula);
        if (pacienteExistente == null) {
            // Insertar los datos del paciente en MongoDB utilizando MongoDB
            boolean insertado = datosPaciente.insertarPaciente(email, nombres, cedula, idEstudiante, carrera, fechaNacimiento, genero, etnia, direccion, telefono);
            if (insertado) {
                JOptionPane.showMessageDialog(this, "Los datos del paciente han sido guardados correctamente.", "Guardar Paciente", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al guardar los datos del paciente.", "Guardar Paciente", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "El paciente con esta cédula ya existe. Continuando con la información médica.", "Guardar Paciente", JOptionPane.INFORMATION_MESSAGE);
        }

        limpiarCampos();
// Obtener el MenuJFrame padre que contiene jVistaPanel


// Obtener el jVistaPanel que contiene Ingresar_Datos
        JPanel jVistaPanel = (JPanel) this.getParent();

// Crear una instancia del panel Ingresar_Datos_InformacionMedica
        Ingresar_Datos_InformacionMedica informacionMedicaPanel = new Ingresar_Datos_InformacionMedica(mongoClient, database, collection);

// Remover este panel (Ingresar_Datos) del jVistaPanel
        jVistaPanel.remove(this);

// Agregar el nuevo panel (Ingresar_Datos_InformacionMedica) al jVistaPanel
        jVistaPanel.add(informacionMedicaPanel);

// Validar y repintar el jVistaPanel para mostrar el nuevo panel
        jVistaPanel.revalidate();
        jVistaPanel.repaint();

// Ajustar el tamaño y la posición del nuevo panel en jVistaPanel si es necesario
        informacionMedicaPanel.setSize(jVistaPanel.getSize());
        informacionMedicaPanel.setLocation(0, 0);

     
    }//GEN-LAST:event_jButtonSiguiente2ActionPerformed

    private void jButtonCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalendarActionPerformed
        CalendarJFrame calendario = new CalendarJFrame(this); // Pasa 'this' como argumento
        calendario.setVisible(true);
        calendario.setLocation(0, 0);
    }//GEN-LAST:event_jButtonCalendarActionPerformed
    
        private void jTextFieldFechaNacimientoMouseMoved(java.awt.event.MouseEvent evt) {                                                     
        CalendarJFrame calendario = new CalendarJFrame(this);
        Date selectedDate = calendario.getSelectedDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Convertir la fecha a String
        String dateString = dateFormat.format(selectedDate);
        jTextFieldFechaNacimiento.setText(dateString);  
    }
    
    private void limpiarCampos() {
        jTextFieldEmail.setText("");
        jTextFieldNombres.setText("");
        jTextFieldCedula.setText("");
        jTextFieldIdEstudiante.setText("");
        jTextFieldCarrera.setText("");
        jTextFieldFechaNacimiento.setText("");
        jComboBoxGenero.setSelectedIndex(0);
        jComboBoxEtnia.setSelectedIndex(0);
        jTextFieldDireccion.setText("");
        jTextFieldTelefono.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCalendar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonSiguiente2;
    private javax.swing.JComboBox<String> jComboBoxEtnia;
    private javax.swing.JComboBox<String> jComboBoxGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldCarrera;
    private javax.swing.JTextField jTextFieldCedula;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFechaNacimiento;
    private javax.swing.JTextField jTextFieldIdEstudiante;
    private javax.swing.JTextField jTextFieldNombres;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
