package Modelo;
import java.io.*;
import java.util.Vector;

public class DatosPersistencia {
    private static final String ARCHIVO_DATOS = "datos.dat";
    
    private static int contadorID = 1; // Se inicia en 1

    public static int generarID() {
        return contadorID++;
    }
    

    // Método para guardar datos
    public static void guardarDatos(Vector<String[]> repuestos, Vector<String[]> servicios, Vector<String[]> clientes) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos.dat"))) {
        oos.writeObject(repuestos);
        oos.writeObject(servicios);
        oos.writeObject(clientes);
    } catch (IOException e) {
        System.out.println("Error al guardar los datos: " + e.getMessage());
    }
}

    public static void guardarUsuarios(Vector<Usuario> usuarios) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) {
        oos.writeObject(usuarios);
    } catch (IOException e) {
        System.out.println("Error al guardar los usuarios: " + e.getMessage());
    }
}

    @SuppressWarnings("unchecked")
    public static void cargarUsuarios(Vector<Usuario> usuarios) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            Vector<Usuario> usuariosCargados = (Vector<Usuario>) ois.readObject();
            usuarios.clear();
            if (usuariosCargados != null) usuarios.addAll(usuariosCargados);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Archivo de usuarios no encontrado o vacío.");
        }
    }
    
    
    // Método para cargar datos
    @SuppressWarnings("unchecked")
    public static void cargarDatos(Vector<String[]> repuestos, Vector<String[]> servicios, Vector<String[]> clientes) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_DATOS))) {
        
        Vector<String[]> repuestosCargados = (Vector<String[]>) ois.readObject();
        Vector<String[]> serviciosCargados = (Vector<String[]>) ois.readObject();
        Vector<String[]> clientesCargados = (Vector<String[]>) ois.readObject();
        
        repuestos.clear();
        servicios.clear();
        clientes.clear();

        // Solo agregar datos si no están duplicados
        // Asegurar que los vectores no sean null antes de usarlos
        if (repuestosCargados != null) repuestos.addAll(repuestosCargados);
        if (serviciosCargados != null) servicios.addAll(serviciosCargados);
        if (clientesCargados != null) clientes.addAll(clientesCargados);
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error al cargar datos. Archivo no encontrado o vacío.");
    }
    }
}

