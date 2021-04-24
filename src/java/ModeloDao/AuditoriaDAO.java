/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import Config.Conexion;
import Interfaces.AuditoriaCRUD;
import Modelo.Auditoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estiven
 */
public class AuditoriaDAO implements AuditoriaCRUD {
    Connection conexion;
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    
    @Override
    public List listar() {
        ArrayList<Auditoria> list = new ArrayList<>();
        String sql = "SELECT * FROM auditoria";
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Auditoria unaAuditoria = new Auditoria();
                unaAuditoria.setIdAuditoria(  rs.getInt("idAuditoria"));
                unaAuditoria.setUsuarioAuditoria(  rs.getString("usuarioAuditoria"));
                unaAuditoria.setDescripcionAuditoria(rs.getString("descripcionAuditoria"));
                unaAuditoria.setFechaAuditoria( rs.getString("fechaAuditoria"));
                list.add(unaAuditoria);
            }
        } catch (Exception e) {
        }
        
        return list;
    }

    @Override
    public boolean add(Auditoria auditoria) {
        String sql = "INSERT INTO `auditoria`( `usuarioAuditoria`, `descripcionAuditoria`) "
                + "VALUES ('"+auditoria.getUsuarioAuditoria()+"','"+auditoria.getDescripcionAuditoria()+"')";
        
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
