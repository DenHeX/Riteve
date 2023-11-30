/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tecnico;

import Controlador.Controlador;
import DaoDB.Dao;
import Views.Frm;
import Views.View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ´Felipe Chacón
 */
public class TecnicoControlador implements Controlador<Tecnico> {

    private View view;
    private Dao dao;
    Frm vista;

    public TecnicoControlador(Frm vista) {
        this.vista = vista;
    }
    public TecnicoControlador(View view, Dao dao) {
        this.view = view;
        this.dao = dao;
    }

    @Override
    public boolean create(Tecnico tecnico) {
        TecnicoDto tecnicoDto = new TecnicoDto(
                tecnico.getCedula(),
                tecnico.getNombre(),
                tecnico.getFechaNacimiento(),
                tecnico.getTelefono(),
                tecnico.getCorreo(),
                tecnico.getSalario()
        );

        if (dao.agregar(tecnicoDto)) {
            view.displayMessage("Técnico agregado correctamente");
            return true;
        } else {
            view.displayMessage("Error al agregar técnico");
            return false;
        }
    }

    @Override
    public Tecnico read(String cedula) {
        TecnicoDto tecnicoDto = (TecnicoDto) dao.cargar(cedula);

        if (tecnicoDto == null) {
            view.displayMessage("Técnico no encontrado");
        } else {
            Tecnico tecnico = new Tecnico(
                    tecnicoDto.getCedula(),
                    tecnicoDto.getNombre(),
                    tecnicoDto.getFechaNacimiento(),
                    tecnicoDto.getTelefono(),
                    tecnicoDto.getCorreo(),
                    tecnicoDto.getSalario()
            );
            view.display(tecnico);
            return tecnico;
        }
        return null;
    }

    @Override
    public List<Tecnico> readAll() {
        List<Tecnico> tecnicos = new ArrayList<>();
        List<TecnicoDto> tecnicoDtos = dao.cargarTodo();

        for (TecnicoDto tecnicoDto : tecnicoDtos) {
            Tecnico tecnico = new Tecnico(
                    tecnicoDto.getCedula(),
                    tecnicoDto.getNombre(),
                    tecnicoDto.getFechaNacimiento(),
                    tecnicoDto.getTelefono(),
                    tecnicoDto.getCorreo(),
                    tecnicoDto.getSalario()
            );
            tecnicos.add(tecnico);
        }

        return tecnicos;
    }

    @Override
    public boolean update(Tecnico tecnico) {
        TecnicoDto tecnicoDtoExistente = (TecnicoDto) dao.cargar(tecnico.getCedula());

        if (tecnicoDtoExistente == null) {
            view.displayMessage("Técnico no encontrado");
            return false;
        } else {
            TecnicoDto tecnicoDtoActualizado = new TecnicoDto(
                    tecnico.getCedula(),
                    tecnico.getNombre(),
                    tecnico.getFechaNacimiento(),
                    tecnico.getTelefono(),
                    tecnico.getCorreo(),
                    tecnico.getSalario()
            );

            if (dao.actualizar(tecnicoDtoActualizado)) {
                view.displayMessage("Técnico actualizado correctamente");
                return true;
            } else {
                view.displayMessage("Error al actualizar técnico");
                return false;
            }
        }
    }

    @Override
    public boolean delete(Tecnico tecnico) {
        TecnicoDto tecnicoDtoExistente = (TecnicoDto) dao.cargar(tecnico.getCedula());

        if (tecnicoDtoExistente == null) {
            view.displayMessage("Técnico no encontrado");
            return false;
        } else {
            if (dao.eliminar(tecnicoDtoExistente)) {
                view.displayMessage("Técnico eliminado correctamente");
                return true;
            } else {
                view.displayMessage("Error al eliminar técnico");
                return false;
            }
        }
    }
}
