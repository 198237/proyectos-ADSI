
package Interfaces;

import Modelo.Auditoria;
import java.util.List;

public interface AuditoriaCRUD {
    public List listar();
    public boolean add(Auditoria auditoria);
}
