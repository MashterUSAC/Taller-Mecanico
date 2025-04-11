
import Modelo.DatosPersistencia;
import java.util.Vector;

public class Controlador {
    private Vector<String[]> clientes = new Vector<>();
    private Vector<String[]> repuestos = new Vector<>();
    private Vector<String[]> servicios = new Vector<>();

    public Controlador() {
        DatosPersistencia.cargarDatos(repuestos, servicios, clientes); // Cargar datos al iniciar
    }

    public Vector<String[]> getClientes() {
        return clientes;
    }

    public Vector<String[]> getRepuestos() {
        return repuestos;
    }

    public Vector<String[]> getServicios() {
        return servicios;
    }
}
