package ModeloDao;

import Config.Conexion;
import Interfaces.ProveedorCRUD;
import Modelo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO implements ProveedorCRUD {

    Proveedor unProveedor = new Proveedor();
    Connection conexion;
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        ArrayList<Proveedor> list = new ArrayList<>();
        String sql = "SELECT * FROM `proveedor`";

        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setNombreProveedor(rs.getString("nombreProveedor"));
                proveedor.setRUTProveedor(rs.getString("RUTProveedor"));
                proveedor.setTelefonoProveedor(rs.getString("telefonoProveedor"));
                proveedor.setDireccionProveedor(rs.getString("direccionProveedor"));
                list.add(proveedor);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Proveedor list(int id) {
        String sql = "SELECT * FROM `proveedor` WHERE idProveedor=" + id;

        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                unProveedor.setIdProveedor(rs.getInt("idProveedor"));
                unProveedor.setNombreProveedor(rs.getString("nombreProveedor"));
                unProveedor.setRUTProveedor(rs.getString("RUTProveedor"));
                unProveedor.setTelefonoProveedor(rs.getString("telefonoProveedor"));
                unProveedor.setDireccionProveedor(rs.getString("direccionProveedor"));

            }
        } catch (Exception e) {
        }
        return unProveedor;
    }

    @Override
    public boolean add(Proveedor prov) {
        String sql = "INSERT INTO `proveedor`( `nombreProveedor`, `RUTProveedor`, `telefonoProveedor`,"
                + " `direccionProveedor`) VALUES ('" + prov.getNombreProveedor() + "','" + prov.getRUTProveedor() + "','" + prov.getTelefonoProveedor() + "',"
                + "'" + prov.getDireccionProveedor() + "')";
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Proveedor prov) {
        String sql = "UPDATE `proveedor` SET `nombreProveedor`='" + prov.getNombreProveedor() + "',"
                + "`RUTProveedor`='" + prov.getRUTProveedor() + "',`telefonoProveedor`='" + prov.getTelefonoProveedor() + "',"
                + "`direccionProveedor`='" + prov.getDireccionProveedor() + "' WHERE `idProveedor`=" + prov.getIdProveedor();

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
      String sql = "DELETE FROM proveedor WHERE idProveedor="+id;
      
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
      return false;
    }
    
    
    public List<Proveedor> listarTodo(){
    
        List<Proveedor> listarProveedor = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Proveedor unProveedor = new Proveedor();
                unProveedor.setIdProveedor(  rs.getInt("idProveedor"));
                unProveedor.setNombreProveedor(rs.getString("nombreProveedor"));
                unProveedor.setRUTProveedor(rs.getString("RUTProveedor"));
                unProveedor.setTelefonoProveedor(rs.getString("telefonoProveedor"));
                unProveedor.setDireccionProveedor(rs.getString("direccionProveedor"));
                listarProveedor.add(unProveedor);
            }
        } catch (Exception e) {
        }
        return listarProveedor;
   
    }

}
