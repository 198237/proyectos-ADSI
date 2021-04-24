
package Modelo;


public class Empleado {
    private int idEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String edadEmpleado;
    private int salarioEmpleado;
    private String correoEmpleado;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String nombreEmpleado, String apellidoEmpleado, String edadEmpleado, int salarioEmpleado, String correoEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.edadEmpleado = edadEmpleado;
        this.salarioEmpleado = salarioEmpleado;
        this.correoEmpleado = correoEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getEdadEmpleado() {
        return edadEmpleado;
    }

    public void setEdadEmpleado(String edadEmpleado) {
        this.edadEmpleado = edadEmpleado;
    }

    public int getSalarioEmpleado() {
        return salarioEmpleado;
    }

    public void setSalarioEmpleado(int salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }
    
    
    
}
