
package Crud;
        
import java.util.List;

public interface Crud<Class> {
    public boolean insertar(Class obj);
    public Class buscar(String cedula);
    public List<Class> obtenerTodo();
    public boolean modificar(Class obj);
    public boolean eliminar(Class obj);
}
