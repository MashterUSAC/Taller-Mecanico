package modelos;

import modelos.DatosPersistencia;
import modelos.ClienteAuto;
import modelos.Ordenamiento; // Importar la nueva clase
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import vistas.ListaAutomoviles;

public class TablaClientesAuto extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    private Vector<ClienteAuto> clientes = new Vector<>();

    // Declaración de botones
    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnOrdenar;
    private JButton btnVerAutos;
    
    public TablaClientesAuto() {
        setTitle("Tabla de Clientes y Automóviles");
        setSize(1250, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new java.awt.BorderLayout());

        //Columnas
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DPI");
        modelo.addColumn("Nombre Completo");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Automóvil");
        modelo.addColumn("Tipo Usuario");

        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, java.awt.BorderLayout.CENTER);

        DatosPersistencia.cargarClientesAuto(clientes); // Cargar datos
        actualizarTabla(); // Mostrar registros

        // INICIALIZAR BOTONES antes de asignarles acciones
        btnAgregar = new JButton("Agregar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnOrdenar = new JButton("Ordenar por DPI");
        btnVerAutos = new JButton("Ver Automóviles");
        JButton btnVerListaAutos = new JButton("Ver Lista de Automóviles");
        
        // ASIGNAR FUNCIONES SOLO DESPUÉS DE LA INICIALIZACIÓN
        btnAgregar.addActionListener(e -> agregarUsuario());
        btnModificar.addActionListener(e -> modificarUsuario());
        btnEliminar.addActionListener(e -> eliminarUsuario());
        btnOrdenar.addActionListener(e -> ordenarPorDPI());
        btnVerAutos.addActionListener(e -> mostrarListaAutomoviles());
        
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnOrdenar);
        panelBotones.add(btnVerAutos);
        panelBotones.add(btnVerAutos);

        add(panelBotones, java.awt.BorderLayout.SOUTH);
    }

    private void actualizarTabla() {
    modelo.setRowCount(0); // Limpiar tabla
    for (ClienteAuto cliente : clientes) {
        modelo.addRow(new Object[]{
            cliente.getId(), 
            cliente.getDpi(), 
            cliente.getNombreCompleto(), 
            cliente.getUsuario(),
            cliente.getContraseña(), 
            cliente.getAutomovil(), 
            cliente.getTipoUsuario() // Mostrar el tipo en la tabla
        });
    }
}

    private void eliminarUsuario() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            clientes.remove(filaSeleccionada);
            DatosPersistencia.guardarClientesAuto(clientes);
            actualizarTabla();
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario para eliminar.");
        }
    }

    private void modificarUsuario() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String dpiNuevo = JOptionPane.showInputDialog("Ingrese nuevo DPI:", modelo.getValueAt(filaSeleccionada, 1));
            String nombreNuevo = JOptionPane.showInputDialog("Ingrese nuevo Nombre:", modelo.getValueAt(filaSeleccionada, 2));
            String usuarioNuevo = JOptionPane.showInputDialog("Ingrese nuevo Usuario:", modelo.getValueAt(filaSeleccionada, 3));
            String automovilNuevo = JOptionPane.showInputDialog("Ingrese nuevo Automóvil:", modelo.getValueAt(filaSeleccionada, 4));

            ClienteAuto cliente = clientes.get(filaSeleccionada);
            cliente.setDpi(dpiNuevo);
            cliente.setNombre(nombreNuevo); // Corrección aquí
            cliente.setUsuario(usuarioNuevo);
            cliente.setAutomovil(automovilNuevo);

            DatosPersistencia.guardarClientesAuto(clientes);
            actualizarTabla();
            JOptionPane.showMessageDialog(null, "Usuario modificado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario para modificar.");
        }
    }

    private void agregarUsuario() {
    DatosPersistencia.cargarClientesAuto(clientes); // Cargar usuarios existentes antes de agregar uno nuevo

    String dpi = JOptionPane.showInputDialog("Ingrese DPI:");
    String nombreCompleto = JOptionPane.showInputDialog("Ingrese Nombre Completo:");
    String usuario = JOptionPane.showInputDialog("Ingrese Usuario:");
    String contraseña = JOptionPane.showInputDialog("Ingrese Contraseña:");

    if (dpi == null || nombreCompleto == null || usuario == null || contraseña == null ||
        dpi.isEmpty() || nombreCompleto.isEmpty() || usuario.isEmpty() || contraseña.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
        return;
    }

    // Verificar si el DPI o Usuario ya existen
    for (ClienteAuto cliente : clientes) {
        if (cliente.getDpi().equals(dpi) || cliente.getUsuario().equals(usuario)) {
            JOptionPane.showMessageDialog(null, "DPI o Usuario ya están registrados.");
            return;
        }
    }

    // Generar nuevo usuario con un ID único
    String idNuevo = String.valueOf(DatosPersistencia.generarID());
    ClienteAuto nuevoCliente = new ClienteAuto(idNuevo, dpi, nombreCompleto, usuario, contraseña);
    clientes.add(nuevoCliente); // Añadir nuevo usuario a la lista

    DatosPersistencia.guardarClientesAuto(clientes); // Guardar TODOS los clientes, incluyendo los antiguos y nuevos
    actualizarTabla(); // Refrescar la tabla con el nuevo usuario
    }
    
    private void ordenarPorDPI() {
    Ordenamiento.ordenarPorDPI(clientes); // Usar el método ordenado desde la clase nueva
    actualizarTabla(); // Refrescar la tabla después de ordenar
    
    }
    
    private void mostrarAutomoviles() {
    int filaSeleccionada = tabla.getSelectedRow();
    if (filaSeleccionada >= 0) {
        ClienteAuto cliente = clientes.get(filaSeleccionada);
        JOptionPane.showMessageDialog(null, "Automóvil registrado: " + cliente.getAutomovil());
    } else {
        JOptionPane.showMessageDialog(null, "Selecciona un cliente para ver sus automóviles.");
    }
}
    private void mostrarListaAutomoviles() {
    int filaSeleccionada = tabla.getSelectedRow();
    if (filaSeleccionada >= 0) {
        ClienteAuto cliente = clientes.get(filaSeleccionada);
        new ListaAutomoviles(cliente).setVisible(true); // Abrir la nueva ventana
    } else {
        JOptionPane.showMessageDialog(null, "Selecciona un cliente para ver su automóvil.");
    }
}
    
    private void MostrarListaAutomoviles() {
    int filaSeleccionada = tabla.getSelectedRow();
    if (filaSeleccionada >= 0) {
        ClienteAuto cliente = clientes.get(filaSeleccionada);
        new ListaAutomoviles(cliente).setVisible(true); // Abrir la nueva ventana
    } else {
        JOptionPane.showMessageDialog(null, "Selecciona un cliente para ver su automóvil.");
    }
}



}
