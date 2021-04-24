
package Interfaces;

import Modelo.Bodega;
import Modelo.Persona;
import java.util.List;


public interface BodegaCRUD {
    public List listar();
    public Bodega list(int id);
    public boolean add(Bodega bodega);
    public boolean edit(Bodega bodega);
    public boolean eliminar(int id);
}
