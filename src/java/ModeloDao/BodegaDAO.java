
package ModeloDao;

import Config.Conexion;
import Interfaces.BodegaCRUD;
import Modelo.Bodega;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BodegaDAO implements BodegaCRUD{
     Connection conexion;
     Conexion con = new Conexion();
     PreparedStatement ps;
     ResultSet rs;
     Bodega bodega = new Bodega();
    @Override
    public List listar() {
        ArrayList<Bodega> list = new ArrayList<>();
        String sql = "SELECT * FROM bodega INNER JOIN producto ON bodega.idProductoBodega = producto.idProducto";
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Bodega unaBodega = new Bodega();
                unaBodega.setIdBodega(  rs.getInt("idBodega"));
                unaBodega.setCodigoBodega(   rs.getString("codigoBodega"));
                unaBodega.setIdProductoBodega( rs.getInt("idProductoBodega"));
                unaBodega.setCantidadBodega(rs.getInt("cantidadBodega"));
                unaBodega.setNombreProducto(rs.getString("nombreProducto"));
                list.add(unaBodega);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Bodega list(int id) {
        String sql = "SELECT * FROM bodega WHERE idBodega="+id;
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                bodega.setIdBodega(rs.getInt("idBodega"));
                bodega.setCodigoBodega(  rs.getString("codigoBodega"));
                bodega.setIdProductoBodega(rs.getInt("idProductoBodega"));
                bodega.setCantidadBodega(rs.getInt("cantidadBodega"));
            }
        } catch (Exception e) {
        }
        return bodega;
    }

    @Override
    public boolean add(Bodega bodega) {
        String sql = "INSERT INTO `bodega`( `codigoBodega`,`idProductoBodega`, `cantidadBodega`) VALUES"
                + " ('"+bodega.getCodigoBodega()+"','"+bodega.getIdProductoBodega()+"',"
                + "'"+bodega.getCantidadBodega()+"')";
        try {
            conexion  = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Bodega bodega) {
        String sql = "UPDATE `bodega` SET `codigoBodega`='"+bodega.getCodigoBodega()+"',"
                + "`idProductoBodega`='"+bodega.getIdProductoBodega()+"',"
                + "`cantidadBodega`='"+bodega.getCantidadBodega()+"' WHERE `idBodega`="+bodega.getIdBodega();
        try {
            conexion  = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM bodega WHERE idBodega="+id;
        try {
             conexion  = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }
    
}
