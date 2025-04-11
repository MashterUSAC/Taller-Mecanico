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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_DATOS))) {
            oos.writeObject(repuestos);
            oos.writeObject(servicios);
            oos.writeObject(clientes);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    // Método para cargar datos
    @SuppressWarnings("unchecked")
    public static void cargarDatos(Vector<String[]> repuestos, Vector<String[]> servicios, Vector<String[]> clientes) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_DATOS))) {
        repuestos.clear();
        servicios.clear();
        clientes.clear();

        Vector<String[]> repuestosCargados = (Vector<String[]>) ois.readObject();
        Vector<String[]> serviciosCargados = (Vector<String[]>) ois.readObject();
        Vector<String[]> clientesCargados = (Vector<String[]>) ois.readObject();

        // Solo agregar datos si no están duplicados
        repuestos.addAll(repuestosCargados);
        servicios.addAll(serviciosCargados);
        clientes.addAll(clientesCargados);
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("No se encontró un archivo de datos guardados.");
    }
    }
}

