
package Modelo;

public class Pedido {
   private int idPedido;
   private int idProveedorPedido;
   private int idProductoPedido;
   private String fechaPedido;
   private String observacionPedido;
   private String nombreProveedor;
   private String nombreProducto;

    public Pedido() {
    }

    public Pedido(int idPedido, int idProveedorPedido, int idProductoPedido, String fechaPedido, String observacionPedido) {
        this.idPedido = idPedido;
        this.idProveedorPedido = idProveedorPedido;
        this.idProductoPedido = idProductoPedido;
        this.fechaPedido = fechaPedido;
        this.observacionPedido = observacionPedido;
    }
   
   //getters y setters de la entidad pedido

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProveedorPedido() {
        return idProveedorPedido;
    }

    public void setIdProveedorPedido(int idProveedorPedido) {
        this.idProveedorPedido = idProveedorPedido;
    }

    public int getIdProductoPedido() {
        return idProductoPedido;
    }

    public void setIdProductoPedido(int idProductoPedido) {
        this.idProductoPedido = idProductoPedido;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getObservacionPedido() {
        return observacionPedido;
    }

    public void setObservacionPedido(String observacionPedido) {
        this.observacionPedido = observacionPedido;
    }
    
    
}
