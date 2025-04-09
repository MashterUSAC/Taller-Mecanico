/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package taller.mecanico;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author masho
 */
public class Administrador extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Repuestos = new javax.swing.JButton();
        Servicio = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        CerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Importar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Repuestos.setText("Repuestos");
        Repuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepuestosActionPerformed(evt);
            }
        });

        Servicio.setText("Servicios");
        Servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServicioActionPerformed(evt);
            }
        });

        jButton3.setText("Clientes y Automoviles");

        jButton4.setText("Progreso Autos");

        jButton5.setText("Reportes");

        CerrarSesion.setText("Cerrar Sesion");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });

        jLabel1.setText("ADMINISTRADOR");

        jLabel2.setText("Opciones:");

        Importar.setText("Importar");
        Importar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Servicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Repuestos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Importar)
                    .addComponent(CerrarSesion))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(CerrarSesion))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Repuestos)
                    .addComponent(Importar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Servicio)
                .addGap(24, 24, 24)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Vector<String[]> repuestos = new Vector<>();
    private Vector<String[]> servicios = new Vector<>();
    private int idRepuestos = 1;
    private int idServicios = 1;
    
    private double obtenerPrecioRepuesto(String marca, String modelo) {
    for (String[] repuesto : repuestos) {
        if (repuesto.length >= 6 && repuesto[2].equalsIgnoreCase(marca) && repuesto[3].equalsIgnoreCase(modelo)) {
            try {
                return Double.parseDouble(repuesto[5]); 
            } catch (NumberFormatException e) {
                return 0; // Si el precio del repuesto no es válido, devolvemos 0
            }
        }
    }
    return 0; // Si no se encuentra un repuesto, devolvemos 0 sin mostrar mensaje
    }


    
    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog (null, "Cerrando Sesion");
        new UserAdmin().setVisible(true);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) evt.getSource());
        frame.dispose(); 
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void RepuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepuestosActionPerformed
        // TODO add your handling code here:
        JFrame ventanaEmergente = new JFrame("Repuestos Importados");
        ventanaEmergente.setSize(1250, 400);
        ventanaEmergente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaEmergente.setLayout(new java.awt.BorderLayout());

        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Marca");
        modeloTabla.addColumn("Modelo");
        modeloTabla.addColumn("Existencias");
        modeloTabla.addColumn("Precio");
        

        JTable tabla = new JTable(modeloTabla);
        tabla.setDefaultEditor(Object.class, new javax.swing.DefaultCellEditor(new JTextField()));
        JScrollPane scrollPane = new JScrollPane(tabla);
        ventanaEmergente.add(scrollPane, java.awt.BorderLayout.CENTER);

        for (String[] fila : repuestos) {
            modeloTabla.addRow(fila);
        }
        
            JButton btnEliminar = new JButton("Eliminar Registro");
        btnEliminar.addActionListener(e -> {
            int filaSeleccionada = tabla.getSelectedRow();
            if (filaSeleccionada >= 0) {
                repuestos.remove(filaSeleccionada);
                modeloTabla.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
            }
        });
        
        
        JButton btnModificar = new JButton("Guardar Modificaciones");
    btnModificar.addActionListener(e -> {
        int filas = modeloTabla.getRowCount();
        repuestos.clear(); // Limpiar el vector y guardar los datos editados

        for (int i = 0; i < filas; i++) {
            String id = (String) modeloTabla.getValueAt(i, 0);
            String nombre = (String) modeloTabla.getValueAt(i, 1);
            String marca = (String) modeloTabla.getValueAt(i, 2);
            String modelo = (String) modeloTabla.getValueAt(i, 3);
            String existencias = (String) modeloTabla.getValueAt(i, 4);
            String precio = (String) modeloTabla.getValueAt(i, 5);
            repuestos.add(new String[]{id, nombre, marca, modelo, existencias, precio});
        }

        JOptionPane.showMessageDialog(null, "Modificaciones guardadas correctamente.");
    });
    
        //Agregar Datos
        JTextField txtNombre = new JTextField(10);
        JTextField txtMarca = new JTextField(10);
        JTextField txtModelo = new JTextField(10);
        JTextField txtExistencias = new JTextField(5);
        JTextField txtPrecio = new JTextField(5);
        JButton btnAgregar = new JButton("Agregar Repuesto");

        btnAgregar.addActionListener(e -> {
        String id = String.valueOf(idRepuestos++);
        repuestos.add(new String[]{id, txtNombre.getText(), txtMarca.getText(), txtModelo.getText(), txtExistencias.getText(), txtPrecio.getText()});
        modeloTabla.addRow(new String[]{id, txtNombre.getText(), txtMarca.getText(), txtModelo.getText(), txtExistencias.getText(), txtPrecio.getText()});
        JOptionPane.showMessageDialog(null, "Repuesto agregado correctamente.");
    });

        JPanel panelFormulario = new JPanel();
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Marca:"));
        panelFormulario.add(txtMarca);
        panelFormulario.add(new JLabel("Modelo:"));
        panelFormulario.add(txtModelo);
        panelFormulario.add(new JLabel("Existencias:"));
        panelFormulario.add(txtExistencias);
        panelFormulario.add(new JLabel("Precio:"));
        panelFormulario.add(txtPrecio);
        panelFormulario.add(btnAgregar);
        //Datos
    
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnEliminar);
        panelBotones.add(btnModificar);
        ventanaEmergente.add(panelBotones, java.awt.BorderLayout.SOUTH);
        ventanaEmergente.add(panelFormulario, java.awt.BorderLayout.NORTH);
        ventanaEmergente.setVisible(true);
    }//GEN-LAST:event_RepuestosActionPerformed
        
    private void ImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportarActionPerformed
        // TODO add your handling code here:
            JFileChooser fileChooser = new JFileChooser();
    int seleccion = fileChooser.showOpenDialog(this);

    if (seleccion == JFileChooser.APPROVE_OPTION) {
        File archivoSeleccionado = fileChooser.getSelectedFile();
        String nombreArchivo = archivoSeleccionado.getName();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoSeleccionado))) {
            if (nombreArchivo.endsWith(".tmr")) {
                repuestos.clear(); // Limpia los datos antes de importar nuevos repuestos
                String linea;
                while ((linea = br.readLine()) != null) { 
                    String[] datos = linea.split("-");
                    try {
                        // Convertimos el precio a número antes de almacenarlo
                        double precio = Double.parseDouble(datos[4]); 
                        repuestos.add(new String[]{String.valueOf(idRepuestos++), datos[0], datos[1], datos[2], datos[3], String.valueOf(precio)});
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error al leer precio del repuesto en el archivo.");
                    }
                }
                JOptionPane.showMessageDialog(null, "Repuestos importados correctamente.");
            } else if (nombreArchivo.endsWith(".tms")) {
                servicios.clear(); // Limpia los datos antes de importar nuevos servicios
                String linea;
                while ((linea = br.readLine()) != null) { 
                    String[] datos = linea.split("-");
                    try {
                        // Convertimos el precio de mano de obra a número
                        double manoObra = Double.parseDouble(datos[4]); 
                        // Obtener el precio del repuesto asociado
                        double precioRepuesto = obtenerPrecioRepuesto(datos[1], datos[2]); 
                        // Calcular el precio total
                        double precioTotal = precioRepuesto + manoObra;

                        // Agregar el servicio con el cálculo correcto en un solo paso
                        servicios.add(new String[]{String.valueOf(idServicios++), datos[0], datos[1], datos[2], datos[3], datos[4], String.valueOf(precioTotal)});
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error al leer precio en el archivo de servicios.");
                    }
                }
                JOptionPane.showMessageDialog(null, "Servicios importados correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Formato de archivo no soportado.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_ImportarActionPerformed

    private void ServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServicioActionPerformed
        // TODO add your handling code here:
            JFrame ventanaEmergente = new JFrame("Servicios Importados");
        ventanaEmergente.setSize(1250, 400);
        ventanaEmergente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaEmergente.setLayout(new java.awt.BorderLayout());

        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Servicio");
        modeloTabla.addColumn("Marca");
        modeloTabla.addColumn("Modelo");
        modeloTabla.addColumn("Repuestos");
        modeloTabla.addColumn("Mano de Obra");
        modeloTabla.addColumn("Precio Total");

        JTable tabla = new JTable(modeloTabla);
        tabla.setDefaultEditor(Object.class, new javax.swing.DefaultCellEditor(new JTextField()));
        JScrollPane scrollPane = new JScrollPane(tabla);
        ventanaEmergente.add(scrollPane, java.awt.BorderLayout.CENTER);

        // Llenar la tabla con los datos ya almacenados sin limpiar la lista
        for (String[] fila : servicios) {
            modeloTabla.addRow(fila);
        }

        JButton btnEliminar = new JButton("Eliminar Registro");
        btnEliminar.addActionListener(e -> {
            int filaSeleccionada = tabla.getSelectedRow();
            if (filaSeleccionada >= 0) {
                servicios.remove(filaSeleccionada);
                modeloTabla.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
            }
        });

        JButton btnModificar = new JButton("Guardar Modificaciones");
        btnModificar.addActionListener(e -> {
            int filas = modeloTabla.getRowCount();
            servicios.clear(); // Ya no se limpia la lista completa

            for (int i = 0; i < filas; i++) {
                String id = (String) modeloTabla.getValueAt(i, 0);
                String servicio = (String) modeloTabla.getValueAt(i, 1);
                String marca = (String) modeloTabla.getValueAt(i, 2);
                String modelo = (String) modeloTabla.getValueAt(i, 3);
                String repuestos = (String) modeloTabla.getValueAt(i, 4);
                String manoObra = (String) modeloTabla.getValueAt(i, 5);
                String precioTotal = (String) modeloTabla.getValueAt(i, 6);
                servicios.add(new String[]{id, servicio, marca, modelo, repuestos, manoObra});
            }

            JOptionPane.showMessageDialog(null, "Modificaciones guardadas correctamente.");
        });

        // Campos de entrada para agregar nuevos servicios con ID automático
        JTextField txtServicio = new JTextField(10);
        JTextField txtMarca = new JTextField(10);
        JTextField txtModelo = new JTextField(10);
        JTextField txtRepuestos = new JTextField(15);
        JTextField txtManoObra = new JTextField(5);    
        JButton btnAgregar = new JButton("Agregar Servicio");

        btnAgregar.addActionListener(e -> {
            String servicio = txtServicio.getText();
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            String repuestos = txtRepuestos.getText();
            String manoObra = txtManoObra.getText();
            double precioRepuesto = obtenerPrecioRepuesto(marca, modelo);
            
                if (!servicio.isEmpty() && !marca.isEmpty() && !modelo.isEmpty() && !repuestos.isEmpty() && !manoObra.isEmpty()) {
            try {
                double manoDeObraNum = Double.parseDouble(manoObra);
                double total = precioRepuesto + manoDeObraNum; // Calcular el precio total
                String id = String.valueOf(idServicios++);
                servicios.add(new String[]{id, servicio, marca, modelo, repuestos, manoObra, String.valueOf(total)});
                modeloTabla.addRow(new String[]{id, servicio, marca, modelo, repuestos, manoObra, String.valueOf(total)});
                JOptionPane.showMessageDialog(null, "Servicio agregado correctamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error: Mano de obra debe ser un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los campos.");
        }
        });

        JPanel panelFormulario = new JPanel();
        panelFormulario.add(new JLabel("Servicio:"));
        panelFormulario.add(txtServicio);
        panelFormulario.add(new JLabel("Marca:"));
        panelFormulario.add(txtMarca);
        panelFormulario.add(new JLabel("Modelo:"));
        panelFormulario.add(txtModelo);
        panelFormulario.add(new JLabel("Repuestos:"));
        panelFormulario.add(txtRepuestos);
        panelFormulario.add(new JLabel("Mano de Obra:"));
        panelFormulario.add(txtManoObra);
        panelFormulario.add(btnAgregar);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnEliminar);
        panelBotones.add(btnModificar);
        ventanaEmergente.add(panelBotones, java.awt.BorderLayout.SOUTH);
        ventanaEmergente.add(panelFormulario, java.awt.BorderLayout.NORTH);
        ventanaEmergente.setVisible(true);
    }//GEN-LAST:event_ServicioActionPerformed

    
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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);      
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CerrarSesion;
    private javax.swing.JButton Importar;
    private javax.swing.JButton Repuestos;
    private javax.swing.JButton Servicio;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
