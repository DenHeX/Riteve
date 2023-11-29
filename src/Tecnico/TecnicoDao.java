package Tecnico;

import Crud.Crud;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ´Ronny Sandino
 */
public class TecnicoDao implements Crud<TecnicoDto> {

    private List<TecnicoDto> tecnicosList;
    private static TecnicoDao instance;

    // Constructor privado para implementar Singleton
    private TecnicoDao() {
        tecnicosList = new ArrayList<>();
    }

    // Método estático para obtener la única instancia de TecnicoDao
    public static TecnicoDao getInstance() {
        if (instance == null) {
            instance = new TecnicoDao();
        }
        return instance;
    }

    @Override
    public boolean agregar(TecnicoDto tecnico) {
        if (tecnico == null || tecnicosList.contains(tecnico)) {
            return false;
        }
        tecnicosList.add(tecnico);
        return true;
    }

    @Override
    public TecnicoDto cargar(String cedula) {
        for (TecnicoDto tecnico : tecnicosList) {
            if (tecnico.getCedula().equals(cedula)) {
                return tecnico;
            }
        }
        return null;
    }

    @Override
    public List<TecnicoDto> cargarTodo() {
        return new ArrayList<>(tecnicosList);
    }

    @Override
    public boolean actualizar(TecnicoDto tecnico) {
        for (int i = 0; i < tecnicosList.size(); i++) {
            if (tecnicosList.get(i).getCedula().equals(tecnico.getCedula())) {
                tecnicosList.set(i, tecnico);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(TecnicoDto tecnico) {
        return tecnicosList.remove(tecnico);
    }
}
