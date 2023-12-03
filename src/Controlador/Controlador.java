
package Controlador;
        
import java.util.List;

public interface Controlador<Class> {
    public boolean agregar(Class obj);
    public Class buscar(String id);
    public List<Class> cargarTodo();
    public boolean modificar(Class obj);
    public boolean eliminar(Class obj);
}
