package Modelo;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String id;
    private String dpi;
    private String nombreCompleto;
    private String usuario;
    private String contraseña;

    public Usuario(String id, String dpi, String nombreCompleto, String usuario, String contraseña) {
        this.id = id;
        this.dpi = dpi;
        this.nombreCompleto = nombreCompleto;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getId() { return id; }
    public String getDpi() { return dpi; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getUsuario() { return usuario; }
    public String getContraseña() { return contraseña; }
}
