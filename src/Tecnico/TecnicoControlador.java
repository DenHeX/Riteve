package Tecnico;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class TecnicoControlador {

    FrmTecnicos vista;

    public TecnicoControlador(FrmTecnicos vista) {
        this.vista = vista;
    }

    public void agregar(Tecnico tecnico) {
        TecnicoDao dao = new TecnicoDao();

        if (dao.buscar(tecnico.getCedula()) == null) {
            TecnicoDto dto = new TecnicoDto(
                    tecnico.getCedula(),
                    tecnico.getNombre(),
                    tecnico.getFechaNacimiento(),
                    tecnico.getTelefono(),
                    tecnico.getCorreo(),
                    tecnico.getSalario(),
                    tecnico.getContrasena()
            );

            boolean exito = dao.insertar(dto);

            if (exito) {
                tecnico.setCedula(dto.getCedula());
                vista.cargarDatos(tecnico);
                cargarTodo();
                vista.notificar("Técnico guardado correctamente", JOptionPane.INFORMATION_MESSAGE);
            } else {
                vista.notificar("Error al guardar el técnico", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            vista.notificar("El técnico ya se encuentra registrado", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar(String cedula) {
    TecnicoDao dao = new TecnicoDao();

    if (dao.obtenerTodo().size() > 1) {
        boolean exito = dao.eliminar(cedula);

        if (exito) {
            this.cargarTodo();
            vista.notificar("Técnico eliminado correctamente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("Error al eliminar el técnico", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        vista.notificar("Debe haber al menos un técnico registrado en el sistema", JOptionPane.ERROR_MESSAGE);
    }
    }

    public void modificar(Tecnico tecnico) {
        TecnicoDao dao = new TecnicoDao();
        TecnicoDto dto = new TecnicoDto(
                tecnico.getCedula(),
                tecnico.getNombre(),
                tecnico.getFechaNacimiento(),
                tecnico.getTelefono(),
                tecnico.getCorreo(),
                tecnico.getSalario(),
                tecnico.getContrasena()
        );

        boolean exito = dao.modificar(dto);

        if (exito) {
            this.cargarTodo();
            vista.notificar("Técnico modificado correctamente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("Error al modificar el técnico", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscar(String cedula) {
        TecnicoDao dao = new TecnicoDao();
        TecnicoDto tecnicoDto = dao.buscar(cedula);

        if (tecnicoDto != null) {
            Tecnico tecnico = new Tecnico(
                    tecnicoDto.getCedula(),
                    tecnicoDto.getNombre(),
                    tecnicoDto.getFechaNacimiento(),
                    tecnicoDto.getTelefono(),
                    tecnicoDto.getCorreo(),
                    tecnicoDto.getSalario(),
                    tecnicoDto.getContrasena()
            );

            vista.cargarDatos(tecnico);
            vista.notificar("Técnico encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("Técnico no encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarTodo() {
        TecnicoDao dao = new TecnicoDao();
        ArrayList<TecnicoDto> lista = dao.obtenerTodo();
        if (lista != null) {
            vista.mostrarTodo(lista);
        }
    }

    public void clear() {
        vista.txtCedula.setText("");
        vista.txtNombre.setText("");
        vista.txtFechaNacimiento.setText("");
        vista.txtTelefono.setText("");
        vista.txtCorreo.setText("");
        vista.txtSalario.setText("");
        vista.txtContrasena.setText("");
    }
}


