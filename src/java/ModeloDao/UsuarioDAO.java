/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import Config.Conexion;
import Interfaces.Validar;
import Modelo.Persona;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Estiven
 */
public class UsuarioDAO implements Validar {

    Conexion con = new Conexion();
    Connection conexion;
    ResultSet rs;
    PreparedStatement ps;

    @Override
    public int validar(Usuario user) {
        int resultado = 0;
        String sql = "SELECT * FROM `usario` WHERE `nombreUsuario`=? AND `correoUsuario`=? AND `contrasena`=? ";

        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, user.getNombreUsuario());
            ps.setString(2, user.getCorreoUsuario());
            ps.setString(3, user.getContrasenaUsuairo());
            
            rs = ps.executeQuery();

            while (rs.next()) {
                resultado = resultado + 1;

                user.setNombreUsuario(rs.getString("nombreUsuario"));
                user.setCorreoUsuario(rs.getString("correoUsuario"));
                user.setContrasenaUsuairo(rs.getString("contrasena"));
                user.setRol_idRol(rs.getInt("rol_idRol"));

            }
            if (resultado == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (SQLException e) {
            return 0;
        }

    }

    @Override
    public boolean add(Usuario usuario) {
        String sql = "INSERT INTO `usario`(`nombreUsuario`, `correoUsuario`, `contrasena`, rol_idRol) "
                + "VALUES ('" + usuario.getNombreUsuario() + "',"
                + "'" + usuario.getCorreoUsuario() + "',"
                + "'" + usuario.getContrasenaUsuairo() + "',"
                + "'"+usuario.getRol_idRol()+"')";

        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "pailas" + ps);
        }
        return false;
    }

    @Override
    public java.util.List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "SELECT * FROM `usario` INNER JOIN rol ON usario.rol_idRol = rol.idRol";
        
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Usuario unUsuario = new Usuario();
                unUsuario.setIdUsuario(rs.getInt("idUsuario"));
                unUsuario.setNombreUsuario(rs.getString("nombreUsuario"));
                unUsuario.setCorreoUsuario(rs.getString("correoUsuario"));
                unUsuario.setContrasenaUsuairo(rs.getString("contrasena"));
                unUsuario.setRol_idRol(rs.getInt("rol_idRol"));
                unUsuario.setNombreRol(rs.getString("nombreRol"));
                list.add(unUsuario);
            }
            
        } catch (Exception e) {
        }
        return list;
               
    }

    @Override
    public boolean edit(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM `usario` WHERE `idUsuario`="+id;
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }

    @Override
    public Usuario List(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int existeUsuario(String usuario) {
        
    
        String sql = "SELECT COUNT(correoUsuario) FROM `usario` WHERE correoUsuario=?";

        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, usuario);
            rs =  ps.executeQuery();

            if (rs.next()) {

                return rs.getInt(1);

             }
            return 1;

        } catch (SQLException e) {

            return 1;

        }
    }

}
