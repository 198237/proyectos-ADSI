
package Modelo;


public class Usuario {
 private int idUsuario;
 private String nombreUsuario;
 private String correoUsuario;
 private String contrasenaUsuairo;
 private int rol_idRol;
 private String nombreRol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String correoUsuario, String contrasenaUsuairo, int rol_idRol, String nombreRol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuairo = contrasenaUsuairo;
        this.rol_idRol = rol_idRol;
        this.nombreRol = nombreRol;
    }

   
    

    
     //getters y setters de la entidad usuario 
    
    public int getRol_idRol() {
        return rol_idRol;
    }
   
    public void setRol_idRol(int rol_idRol) {    
        this.rol_idRol = rol_idRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContrasenaUsuairo() {
        return contrasenaUsuairo;
    }

    public void setContrasenaUsuairo(String contrasenaUsuairo) {
        this.contrasenaUsuairo = contrasenaUsuairo;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
    
    
    
    
    
 
 
}
