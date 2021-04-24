package ModeloDao;

import Config.Conexion;
import Interfaces.EmpleadoCRUD;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements EmpleadoCRUD {

    Connection conexion;
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Empleado empleado = new Empleado();

    @Override
    public List listar() {
       ArrayList<Empleado> list = new ArrayList<>();
       String sql = "SELECT * FROM empleado";
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Empleado unEmpleado = new Empleado();
                unEmpleado.setIdEmpleado(rs.getInt("idEmpleado"));
                unEmpleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                unEmpleado.setApellidoEmpleado(rs.getString("apellidoEmpleado"));
                unEmpleado.setEdadEmpleado(rs.getString("edadEmpledo"));
                unEmpleado.setSalarioEmpleado(rs.getInt("salarioEmpleado"));
                unEmpleado.setCorreoEmpleado(rs.getString("correoEmpleado"));
                list.add(unEmpleado);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Empleado list(int id) {
        String sql = "SELECT * FROM `empleado` WHERE `idEmpleado`=" + id;
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleado.setApellidoEmpleado(rs.getString("apellidoEmpleado"));
                empleado.setEdadEmpleado(rs.getString("edadEmpledo"));
                empleado.setSalarioEmpleado(rs.getInt("salarioEmpleado"));
                empleado.setCorreoEmpleado(rs.getString("correoEmpleado"));
               
            }
        } catch (Exception e) {
        }
        return empleado;
    }

    @Override
    public boolean add(Empleado empleado) {
        String sql = "INSERT INTO `empleado`( `nombreEmpleado`, `apellidoEmpleado`, `edadEmpledo`, "
                + "`salarioEmpleado`, `correoEmpleado`) VALUES ('"+empleado.getNombreEmpleado()+"',"
                + "'"+empleado.getApellidoEmpleado()+"','"+empleado.getEdadEmpleado()+"',"
                + "'"+empleado.getSalarioEmpleado()+"','"+empleado.getCorreoEmpleado()+"')";
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Empleado empleado) {
        String sql = "UPDATE `empleado` SET `nombreEmpleado`='"+empleado.getNombreEmpleado()+"',"
                + "`apellidoEmpleado`='"+empleado.getApellidoEmpleado()+"',"
                + "`edadEmpledo`='"+empleado.getEdadEmpleado()+"',"
                + "`salarioEmpleado`='"+empleado.getSalarioEmpleado()+"',"
                + "`correoEmpleado`='"+empleado.getCorreoEmpleado()+"' "
                + "WHERE `idEmpleado`="+empleado.getIdEmpleado();
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
        String sql = "DELETE FROM empleado WHERE idEmpleado="+id;
        try {
            conexion = con.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
