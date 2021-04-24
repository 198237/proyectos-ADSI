
package Interfaces;

import Modelo.Pedido;
import java.util.List;


public interface PedidoCRUD {
    public List listar();
    public Pedido list( int id);
    public boolean add(Pedido pedido);
    public boolean edit(Pedido pedido);
    public boolean eliminar(int id);
    
}
