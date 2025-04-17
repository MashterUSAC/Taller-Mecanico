package vista;

import modelos.ClienteAuto;
import javax.swing.*;
import java.awt.*;

public class ListaAutomoviles extends JFrame {
    private JLabel lblImagenAuto;
    private JTextArea txtDescripcion;
    private JList<String> listaPiezas;
    
    public ListaAutomoviles(ClienteAuto cliente) {
        setTitle("Automóvil de " + cliente.getNombreCompleto());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Cargar imagen del auto (se recomienda usar rutas dinámicas)
        lblImagenAuto = new JLabel(new ImageIcon("imagenes/" + cliente.getAutomovil() + ".jpg")); // Ruta de la imagen

        txtDescripcion = new JTextArea("Descripción del automóvil: " + cliente.getAutomovil());
        txtDescripcion.setEditable(false);

        // Simulación de lista de piezas
        String[] piezas = { "Motor", "Transmisión", "Frenos", "Suspensión", "Neumáticos" };
        listaPiezas = new JList<>(piezas);

        // Agregar componentes a la ventana
        add(lblImagenAuto, BorderLayout.NORTH);
        add(txtDescripcion, BorderLayout.CENTER);
        add(new JScrollPane(listaPiezas), BorderLayout.SOUTH);
    }
}
