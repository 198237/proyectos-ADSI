
package Interfaces;

import Modelo.Proveedor;
import java.util.List;


public interface ProveedorCRUD {
     public List listar();
    public Proveedor list(int id);
    public boolean add(Proveedor prov);
    public boolean edit(Proveedor prov);
    public boolean eliminar(int id);
}
