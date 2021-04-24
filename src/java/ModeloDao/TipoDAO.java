
package ModeloDao;

import Config.Conexion;
import Interfaces.TipoCRUD;
import Modelo.Auditoria;
import Modelo.Tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TipoDAO implements TipoCRUD {
     Connection conexion;
     Conexion con = new Conexion();
     PreparedStatement ps;
     PreparedStatement ps2;
     ResultSet rs;
     Tipo tipo = new Tipo();
     Auditoria audi = new Auditoria();
    @Override
    public List listar() {
        ArrayList<Tipo> list = new ArrayList<>();
        String sql = "SELECT * FROM tipo";
        
        try {
            
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
               Tipo unTipo = new Tipo();
               unTipo.setIdTipo(   rs.getInt("idTipo"));
               unTipo.setDescripcionTipo(  rs.getString("descripcionTipo"));
                list.add(unTipo);
            }
        } catch (SQLException e) {
            System.out.println("no se pudo listar"+e.getMessage());
        }
        
        if (list.isEmpty()) {
            Tipo miTipo = new Tipo();
            miTipo.setDescripcionTipo("no hay registros");
            list.add(miTipo);
        }
        return list;
    }

    @Override
    public Tipo list(int id) {
       ArrayList<Tipo> list = new ArrayList<>();
       String sql = "SELECT * FROM tipo WHERE idTipo ="+id;
       
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {   
                tipo.setIdTipo(  rs.getInt("idTipo"));
                tipo.setDescripcionTipo(  rs.getString("descripcionTipo"));
            }
        } catch (Exception e) {
        }
       
       return tipo;
    }

    @Override
    public boolean add(Tipo tipo) {
        
        String sql = "INSERT INTO `tipo`(`descripcionTipo`) VALUES ('"+tipo.getDescripcionTipo()+"')";
       
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("pailas");
        }
        return false;
    }

    @Override
    public boolean edit(Tipo tipo) {
        String sql = "UPDATE `tipo` SET `descripcionTipo`='"+tipo.getDescripcionTipo()+"' WHERE idTipo="+tipo.getIdTipo();
        
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("pailas");
        }
        
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM tipo WHERE idTipo="+id;
        
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("pailas");
        }
        
        return false;
    }
    
    public List<Tipo> consultarTodo(){
    
    List<Tipo> list = new ArrayList<Tipo>();
        String sql = "SELECT * FROM tipo";
               
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
             while (rs.next()) {                
                Tipo unTipo = new Tipo();
                unTipo.setIdTipo( rs.getInt("idTipo"));
                unTipo.setDescripcionTipo(  rs.getString("descripcionTipo"));
                list.add(unTipo);
            }
        } catch (SQLException e) {
            System.out.println("pailas al listar el tipo");
        }
        return list;
    }
    
}
