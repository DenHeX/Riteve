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
    public boolean agregar(TecnicoDto obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TecnicoDto cargar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TecnicoDto> cargarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(TecnicoDto obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(TecnicoDto obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
