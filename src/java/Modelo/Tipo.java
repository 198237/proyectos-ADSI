
package Modelo;


public class Tipo {
    private int idTipo;
    private String descripcionTipo;

    public Tipo() {
    }

    public Tipo(int idTipo, String descripcionTipo) {
        this.idTipo = idTipo;
        this.descripcionTipo = descripcionTipo;
    }
    
    
    //getters y setters de la entidad tipo

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }
    
    //to string

    @Override
    public String toString() {
        return getDescripcionTipo();
    }
    
    
}
