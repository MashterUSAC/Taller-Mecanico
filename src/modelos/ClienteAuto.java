package modelos;

import java.io.Serializable;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class ClienteAuto implements Serializable {
    private String id;
    private String dpi;
    private String nombreCompleto;
    private String usuario;
    private String contraseña;
    private String automovil;
    private String tipoUsuario; // Nuevo atributo para el tipo de usuario

    public ClienteAuto(String id, String dpi, String nombreCompleto, String usuario, String contraseña) {
        this.id = id;
        this.dpi = dpi;
        this.nombreCompleto = nombreCompleto;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.automovil = "Sin automóvil";
        this.tipoUsuario = "Normal"; // Asignar por defecto "Normal"
    }

    public String getId() { return id; }
    public String getDpi() { return dpi; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getUsuario() { return usuario; }  
    public String getContraseña() { return contraseña; }
    public String getAutomovil() { return automovil; }
    public String getTipoUsuario() { return tipoUsuario; }
    
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    public void setAutomovil(String automovil) { this.automovil = automovil; }
    
    public void setDpi(String dpi) {
    this.dpi = dpi;
}

    public void setNombre(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public void setContraseña(String contraseña) {
    this.contraseña = encriptarContraseña(contraseña);
}

    public static String encriptarContraseña(String contraseña) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contraseña.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error en la encriptación de contraseña");
        }
    }

}
