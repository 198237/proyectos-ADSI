
package Interfaces;

import Modelo.Empleado;
import java.util.List;


public interface EmpleadoCRUD {
 public List listar();
 public Empleado list(int id);
 public boolean add(Empleado empleado);
 public boolean edit(Empleado empleado);
 public boolean eliminar(int id);
}
