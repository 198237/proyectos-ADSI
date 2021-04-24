
package Modelo;


public class Bodega {
    private int idBodega;
    private String codigoBodega;
    private int idProductoBodega;
    private int cantidadBodega;
    private String nombreProducto;

    public Bodega() {
    }

    public Bodega(int idBodega, String codigoBodega, int idProductoBodega, int cantidadBodega) {
        this.idBodega = idBodega;
        this.codigoBodega = codigoBodega;
        this.idProductoBodega = idProductoBodega;
        this.cantidadBodega = cantidadBodega;
    }
   
    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public String getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(String codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public int getIdProductoBodega() {
        return idProductoBodega;
    }

    public void setIdProductoBodega(int idProductoBodega) {
        this.idProductoBodega = idProductoBodega;
    }

    public int getCantidadBodega() {
        return cantidadBodega;
    }

    public void setCantidadBodega(int cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    
    
    
}
