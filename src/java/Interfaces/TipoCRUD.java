
package Interfaces;

import Modelo.Tipo;
import java.util.List;


public interface TipoCRUD {
    public List listar();
    public Tipo list(int id);
    public boolean add(Tipo tipo);
    public boolean edit(Tipo tipo);
    public boolean eliminar(int id);
    
}
