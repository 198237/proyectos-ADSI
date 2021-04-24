package ModeloDao;

import Config.Conexion;
import Interfaces.ProductoCRUD;
import Modelo.Producto;
import Modelo.Tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements ProductoCRUD {

    Connection conexion;
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Producto producto = new Producto();

    @Override
    public List listar() {
        ArrayList<Producto> list = new ArrayList<>();
        String sql = "SELECT * FROM `producto` INNER JOIN proveedor"
                + " ON producto.idProveedor_Producto = proveedor.idProveedor"
                + " INNER JOIN tipo ON producto.idTipo_Producto = tipo.idTipo";

        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto unProducto = new Producto();
                unProducto.setIdProducto(rs.getInt("idProducto"));
                unProducto.setNombreProducto(rs.getString("nombreProducto"));
                unProducto.setPesoProducto(rs.getInt("pesoProducto"));
                unProducto.setNombreProveedor(rs.getString("nombreProveedor"));
                unProducto.setNombreTipo(rs.getString("descripcionTipo"));
                unProducto.setPrecioProducto(rs.getInt("precioProducto"));
                list.add(unProducto);
            }
        } catch (SQLException e) {
            System.err.println("no se pudo listar");
        }
        return list;
    }

    @Override
    public Producto list(int id) {
        String sql = "SELECT * FROM producto WHERE idProducto=" + id;
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setPesoProducto(rs.getInt("pesoProducto"));
                producto.setIdProveedor_Producot(rs.getInt("idProveedor_Producto"));
                producto.setIdTipo_producto(rs.getInt("idTipo_Producto"));
                producto.setPrecioProducto(rs.getInt("precioProducto"));
            }
        } catch (Exception e) {
        }
        return producto;

    }

    @Override
    public boolean add(Producto producto) {
        String sql = "INSERT INTO `producto`(`nombreProducto`, `pesoProducto`, `idProveedor_Producto`,"
                + " `idTipo_Producto`, `precioProducto`) VALUES ('" + producto.getNombreProducto() + "',"
                + "'" + producto.getPesoProducto() + "','" + producto.getIdProveedor_Producot() + "',"
                + "'" + producto.getIdTipo_producto() + "','" + producto.getPesoProducto() + "')";

        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Producto producto) {
        String sql = "UPDATE `producto` SET `nombreProducto`='"+producto.getNombreProducto()+"',`pesoProducto`='"+producto.getPesoProducto()+"',"
        + "`idProveedor_Producto`='"+producto.getIdProveedor_Producot()+"',"
        + "`idTipo_Producto`='"+producto.getIdTipo_producto()+"',`precioProducto`='"+producto.getPrecioProducto()+"'\n" +
         "WHERE `idProducto`="+producto.getIdProducto();
        
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM producto WHERE idProducto ="+id;
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    return false;
    }

    @Override
    public List listarTipo() {
        return null;

        ///;
    }
    
    
    public List<Producto> listarTodo(){
    List<Producto> listado = new ArrayList<Producto>();
    String sql = "SELECT * FROM producto";
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Producto elProducto = new Producto();
                elProducto.setIdProducto(rs.getInt("idProducto"));
                elProducto.setNombreProducto(rs.getString("nombreProducto"));
                elProducto.setPesoProducto(rs.getInt("pesoProducto"));
                elProducto.setIdProveedor_Producot(rs.getInt("idProveedor_Producto"));
                elProducto.setIdTipo_producto(rs.getInt("idTipo_Producto"));
                elProducto.setPrecioProducto(rs.getInt("precioProducto"));
                listado.add(elProducto);
            }
            
        } catch (Exception e) {
        }
    return listado;
    }
}
