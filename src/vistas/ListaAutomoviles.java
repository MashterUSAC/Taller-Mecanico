package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;
import modelos.ClienteAuto;

public class ListaAutomoviles extends JFrame {
    private JTable tablaAutomoviles;
    private DefaultTableModel modeloTabla;
    
   public ListaAutomoviles(ClienteAuto cliente) {
    setTitle("Lista de Automóviles de " + cliente.getUsuario());
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(new BorderLayout());

    // Definir columnas de la tabla
    String[] columnas = {"Placa", "Marca", "Modelo", "Foto"};
    DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
    JTable tablaAutomoviles = new JTable(modeloTabla);

    // Agregar el automóvil del cliente a la tabla
    modeloTabla.addRow(new Object[]{
        cliente.getPlaca(),
        cliente.getMarca(),
        cliente.getModelo(),
        cliente.getFoto()
    });

    add(new JScrollPane(tablaAutomoviles), BorderLayout.CENTER);
    setVisible(true);
}

    public static Vector<ClienteAuto> listaAutos = new Vector<>();

    public static void agregarAuto(ClienteAuto auto) {
        listaAutos.add(auto);
    }

    public static Vector<ClienteAuto> obtenerLista() {
        return listaAutos;
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de actualizar

        for (ClienteAuto auto : listaAutos) {
            modeloTabla.addRow(new Object[]{auto.getPlaca(), auto.getMarca(), auto.getModelo(), auto.getFoto(), auto.getUsuario()});
        }
    }
}
