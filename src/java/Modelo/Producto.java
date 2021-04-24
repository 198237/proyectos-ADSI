
package Modelo;


public class Producto {
    private int idProducto;
    private String nombreProducto;
    private int pesoProducto;
    private int idProveedor_Producot;
    private int idTipo_producto;
    private int precioProducto;
    private String nombreProveedor;
    private String nombreTipo;

    public Producto() {
    }

    public Producto(int idProducto, String nombreProducto, int pesoProducto, int idProveedor_Producot, int idTipo_producto, int precioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.pesoProducto = pesoProducto;
        this.idProveedor_Producot = idProveedor_Producot;
        this.idTipo_producto = idTipo_producto;
        this.precioProducto = precioProducto;
    }
    
    
    //metodos getters y setters de la entidad producto

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPesoProducto() {
        return pesoProducto;
    }

    public void setPesoProducto(int pesoProducto) {
        this.pesoProducto = pesoProducto;
    }

    public int getIdProveedor_Producot() {
        return idProveedor_Producot;
    }

    public void setIdProveedor_Producot(int idProveedor_Producot) {
        this.idProveedor_Producot = idProveedor_Producot;
    }

    public int getIdTipo_producto() {
        return idTipo_producto;
    }

    public void setIdTipo_producto(int idTipo_producto) {
        this.idTipo_producto = idTipo_producto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
    
    

    @Override
    public String toString() {
        return getNombreProducto();
    }
    
    
    
    
    
    
}
    