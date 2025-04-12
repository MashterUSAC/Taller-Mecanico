package Modelo; // Si prefieres que esté en Modelo, cambia esto a `package Modelo;`
import modelo.ClienteAuto;
import java.util.Vector;

public class Ordenamiento {
        public static void ordenarPorDPI(Vector<ClienteAuto> clientes) {
        int n = clientes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (Long.parseLong(clientes.get(j).getDpi()) > Long.parseLong(clientes.get(j + 1).getDpi())) { // Cambio a Long.parseLong()
                    ClienteAuto temp = clientes.get(j);
                    clientes.set(j, clientes.get(j + 1));
                    clientes.set(j + 1, temp);
                }
            }
        }
    }
}
