package vistas;

import java.awt.Component;
import java.awt.GridLayout;
import java.io.File;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import modelos.ClienteAuto;
import vistas.ListaAutomoviles;

public class Cliente extends javax.swing.JFrame {

    private String usuarioActual; // Para almacenar el usuario logueado
    private Vector<ClienteAuto> clientes = new Vector<>(); // Para la lista de clientes
    
    public Cliente(String usuario, Vector<ClienteAuto> clientes) {
        this.usuarioActual = usuario; // Guardar el usuario que inició sesión
        this.clientes = clientes; // Guardar la lista de clientes
        initComponents(); // Inicializar la interfaz
    }

    private Cliente() {
        initComponents(); // Inicializar la interfaz
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        RegistrarAuto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CerrarSesion = new javax.swing.JButton();
        ListaAuto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente");

        RegistrarAuto.setText("Registrar Automovil");
        RegistrarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarAutoActionPerformed(evt);
            }
        });

        jLabel3.setText("Ver Progreso");

        jLabel4.setText("Facturas");

        CerrarSesion.setText("Cerrar Sesion");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });

        ListaAuto.setText("Ver Automovil");
        ListaAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaAutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CerrarSesion)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(RegistrarAuto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ListaAuto, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(CerrarSesion))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegistrarAuto)
                    .addComponent(ListaAuto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(95, 95, 95))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog (null, "Cerrando Sesion");
        new UserAdmin().setVisible(true);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) evt.getSource());
        frame.dispose(); 
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void RegistrarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarAutoActionPerformed
        // Ventana emergente para registrar el automóvil
    JFrame ventanaRegistrar = new JFrame("Registrar Automóvil");
    ventanaRegistrar.setSize(400, 300);
    ventanaRegistrar.setLayout(new GridLayout(5, 2));

    JTextField txtPlaca = new JTextField();
    JTextField txtModelo = new JTextField();
    JTextField txtMarca = new JTextField();
    JButton btnFoto = new JButton("Agregar Foto");
    JButton btnRegistrar = new JButton("Registrar");
    JButton btnCancelar = new JButton("Cancelar");

    final String[] fotoRuta = {""};

    ventanaRegistrar.add(new JLabel("Placa:"));
    ventanaRegistrar.add(txtPlaca);
    
    ventanaRegistrar.add(new JLabel("Modelo:"));
    ventanaRegistrar.add(txtModelo);

    ventanaRegistrar.add(new JLabel("Marca:"));
    ventanaRegistrar.add(txtMarca);

    ventanaRegistrar.add(btnFoto);
    ventanaRegistrar.add(new JLabel("")); // Espacio vacío

    btnFoto.addActionListener(e -> {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes (*.jpg, *.png)", "jpg", "png"));

        if (fileChooser.showOpenDialog(ventanaRegistrar) == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            fotoRuta[0] = archivo.getAbsolutePath();
            btnFoto.setText("Imagen seleccionada");
        }
    });

    btnRegistrar.addActionListener(e -> {
        String placa = txtPlaca.getText();
        String modelo = txtModelo.getText();
        String marca = txtMarca.getText();

        if (placa.isEmpty() || modelo.isEmpty() || marca.isEmpty() || fotoRuta[0].isEmpty()) {
            JOptionPane.showMessageDialog(ventanaRegistrar, "❌ Todos los campos son obligatorios.");
            return;
        }

        ClienteAuto nuevoAuto = new ClienteAuto(placa, marca, modelo, fotoRuta[0], usuarioActual);
        vistas.ListaAutomoviles.agregarAuto(nuevoAuto); // Guardar en la lista global

        JOptionPane.showMessageDialog(ventanaRegistrar, "✅ Automóvil registrado correctamente.");
        ventanaRegistrar.dispose(); // Cerrar ventana después del registro
    });

    btnCancelar.addActionListener(e -> ventanaRegistrar.dispose());

    ventanaRegistrar.add(btnRegistrar);
    ventanaRegistrar.add(btnCancelar);

    ventanaRegistrar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventanaRegistrar.setVisible(true);      
    }//GEN-LAST:event_RegistrarAutoActionPerformed

    private void ListaAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaAutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListaAutoActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CerrarSesion;
    private javax.swing.JButton ListaAuto;
    private javax.swing.JButton RegistrarAuto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
