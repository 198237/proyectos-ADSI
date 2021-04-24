
package Modelo;


public class Proveedor {
    private int idProveedor;
    private String nombreProveedor;
    private String RUTProveedor;
    private String telefonoProveedor;
    private String direccionProveedor;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String nombreProveedor, String RUTProveedor, String telefonoProveedor, String direccionProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.RUTProveedor = RUTProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.direccionProveedor = direccionProveedor;
    }
    
    //metodos getters y setters de la entidad proveedor

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getRUTProveedor() {
        return RUTProveedor;
    }

    public void setRUTProveedor(String RUTProveedor) {
        this.RUTProveedor = RUTProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "nombreProveedor=" + nombreProveedor + '}';
    }
    
    
    
}
