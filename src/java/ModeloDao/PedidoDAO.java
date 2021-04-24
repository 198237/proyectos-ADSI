/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import Config.Conexion;
import Interfaces.PedidoCRUD;
import Modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estiven
 */
public class PedidoDAO implements PedidoCRUD {

    Connection conexion;
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Pedido pedido = new Pedido();

    @Override
    public List listar() {
        ArrayList<Pedido> list = new ArrayList<>();
        String sql = "SELECT * FROM pedido INNER JOIN proveedor ON pedido.idProveedorPedido = proveedor.idProveedor INNER JOIN producto ON pedido.idProductoPedido = producto.idProducto";
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido unPedido = new Pedido();
                unPedido.setIdPedido(rs.getInt("idPedido"));
                unPedido.setIdProveedorPedido(rs.getInt("idProveedorPedido"));
                unPedido.setIdProductoPedido(rs.getInt("idProductoPedido"));
                unPedido.setFechaPedido(rs.getString("fechaPedido"));
                unPedido.setObservacionPedido(rs.getString("observacionPedido"));
                unPedido.setNombreProducto(rs.getString("nombreProducto"));
                unPedido.setNombreProveedor(rs.getString("nombreProveedor"));
                list.add(unPedido);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Pedido list(int id) {
        String sql = "SELECT * FROM pedido WHERE idPedido=" + id;
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdProveedorPedido(rs.getInt("idProveedorPedido"));
                pedido.setIdProductoPedido(rs.getInt("idProductoPedido"));
                pedido.setFechaPedido(rs.getString("fechaPedido"));
                pedido.setObservacionPedido(rs.getString("observacionPedido"));
            }
        } catch (Exception e) {
        }
        return pedido;
    }

    @Override
    public boolean add(Pedido pedido) {
        String sql = "INSERT INTO `pedido`( `idProveedorPedido`, `idProductoPedido`,  `observacionPedido`)"
                + " VALUES ('" + pedido.getIdProveedorPedido() + "','" + pedido.getIdProductoPedido() + "','" + pedido.getObservacionPedido() + "')";
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public boolean edit(Pedido pedido) {
        String sql = "UPDATE `pedido` SET `idProveedorPedido`='" + pedido.getIdProveedorPedido() + "',"
                + "`idProductoPedido`='" + pedido.getIdProductoPedido() + "',`observacionPedido`='" + pedido.getObservacionPedido() + "'"
                + " WHERE `idPedido`=" + pedido.getIdPedido();
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
        String sql = "DELETE FROM pedido WHERE idPedido=" + id;
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
