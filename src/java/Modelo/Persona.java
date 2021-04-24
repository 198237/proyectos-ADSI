
package Modelo;

/**
 *
 * @author Estiven
 */
public class Persona {
     int idPersona;
    String dniPersona;
    String nombrePersona;

    public Persona() {
    }

    public Persona(String dniPersona, String nombrePersona) {
        
        this.dniPersona = dniPersona;
        this.nombrePersona = nombrePersona;
    }
    
    //listado de metodos getters y setters de la entidad persona

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
    
    
    
    
}
