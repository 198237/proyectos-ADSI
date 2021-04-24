
package ModeloDao;

import Config.Conexion;
import Interfaces.CRUD;

import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements CRUD {
    Conexion con = new Conexion();
    Connection conexion;
    Persona persona = new Persona();
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List listar() {
        ArrayList<Persona> list = new ArrayList<>();
        String sql = "SELECT * FROM `persona`";
        
            try{ 
               conexion = con.getConexion();
               ps = conexion.prepareStatement(sql);
               rs = ps.executeQuery();
               
                while (rs.next()) {                    
                    Persona unaPersona = new Persona();
                    unaPersona.setIdPersona(rs.getInt("idPersona"));
                    unaPersona.setDniPersona(rs.getString("DNIPersona"));
                    unaPersona.setNombrePersona(rs.getString("nombresPersona"));
                    list.add(unaPersona);
                }
        } catch (Exception e) {
        }
              return list;  
    }

    @Override
    public Persona list(int id) {
        
         ArrayList<Persona> list = new ArrayList<>();
        String sql = "SELECT * FROM `persona` WHERE idPersona = "+id;
        
            try{ 
               conexion = con.getConexion();
               ps = conexion.prepareStatement(sql);
               rs = ps.executeQuery();
               
                while (rs.next()) {                    
                    
                    persona.setIdPersona(rs.getInt("idPersona"));
                    persona.setDniPersona(rs.getString("DNIPersona"));
                    persona.setNombrePersona(rs.getString("nombresPersona"));
                   
                }
        } catch (Exception e) {
                System.out.println("");
        }
              return persona;
    }

    @Override
    public boolean add(Persona per) {
     String sql = "INSERT INTO `persona`( `DNIPersona`, `nombresPersona`) VALUES"
             + " ('"+per.getDniPersona()+"','"+per.getNombrePersona()+"')";
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("pailas");
        }
     return false;
    }

    @Override
    public boolean edit(Persona per) {
     String sql = "UPDATE `persona` SET `DNIPersona`='"+per.getDniPersona()+"',`nombresPersona`='"+per.getNombrePersona()+"' "
             + "WHERE `idPersona`="+per.getIdPersona();
     
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("");
        }
     
     return  false;
    }

    @Override
    public boolean eliminar(int id) {
       String sql = "DELETE FROM persona WHERE idPersona = "+id;
       
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }
    
    
}
