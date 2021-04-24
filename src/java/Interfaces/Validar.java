
package Interfaces;

import Modelo.Usuario;
import java.util.List;

public interface Validar {
    public int validar(Usuario user);
    public boolean add(Usuario usuario);
    public List listar();
    public boolean edit(Usuario usuario);
    public boolean eliminar(int id);
    public Usuario List(int id);
    public int existeUsuario(String usuario);
    
}
 