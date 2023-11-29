
package Crud;
        
import java.util.List;

public interface Crud<Class> {
    public boolean agregar(Class obj);
    public Class cargar(String id);
    public List<Class> cargarTodo();
    public boolean actualizar(Class obj);
    public boolean eliminar(Class obj);
}
