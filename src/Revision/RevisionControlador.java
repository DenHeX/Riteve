package Revision;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RevisionControlador {

    private FrmRevisiones vista;

    public RevisionControlador(FrmRevisiones vista) {
        this.vista = vista;
    }

    public void agregar(Revision revision) {
    RevisionDao dao = new RevisionDao();

    if (dao.buscar(revision.getIdRevision()) == null) {
        RevisionDto dto = new RevisionDto(
            revision.getFecha(),
            revision.getHora(),
            revision.getIdTecnico(),
            revision.getIdCita(),
            revision.getTipoRevision(),
            revision.getObservaciones(),
            revision.getEstado()
        );

        boolean exito = dao.insertar(dto);

            if (exito) {
                vista.notificar("Revisión agregada correctamente", JOptionPane.INFORMATION_MESSAGE);
                cargarTodo();
                limpiar();
            } else {
                vista.notificar("Error al agregar la revisión", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            vista.notificar("La revisión ya existe", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar(int idRevision) {
        RevisionDao dao = new RevisionDao();

        RevisionDto revisionExistente = dao.buscar(idRevision);
        if (revisionExistente != null) {
            boolean exito = dao.eliminar(idRevision);

            if (exito) {
                vista.notificar("Revisión eliminada correctamente", JOptionPane.INFORMATION_MESSAGE);
                cargarTodo();
            } else {
                vista.notificar("Error al eliminar la revisión", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            vista.notificar("La revisión no existe", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizar(Revision revision) {
        RevisionDao dao = new RevisionDao();

        RevisionDto revisionExistente = dao.buscar(revision.getIdRevision());
        if (revisionExistente != null) {
            RevisionDto dto = new RevisionDto(
                    revision.getIdRevision(),
                    revision.getFecha(),
                    revision.getHora(),
                    revision.getIdTecnico(),
                    revision.getIdCita(),
                    revision.getTipoRevision(),
                    revision.getObservaciones(),
                    revision.getEstado()
            );

            boolean exito = dao.actualizar(dto);

            if (exito) {
                vista.notificar("Revisión actualizada correctamente", JOptionPane.INFORMATION_MESSAGE);
                cargarTodo();
                limpiar();
            } else {
                vista.notificar("Error al actualizar la revisión", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            vista.notificar("La revisión no existe", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscar(int idRevision) {
        RevisionDao dao = new RevisionDao();

        RevisionDto revisionEncontrada = dao.buscar(idRevision);

        if (revisionEncontrada != null) {
            vista.cargarDatos(revisionEncontrada);
            vista.notificar("Revisión encontrada", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("Revisión no encontrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarTodo() {
        RevisionDao dao = new RevisionDao();

        ArrayList<RevisionDto> listaRevisiones = dao.obtenerTodo();

        if (listaRevisiones != null) {
            vista.mostrarTodo(listaRevisiones);
        } else {
            vista.notificar("Error al cargar las revisiones", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiar() {
        vista.limpiarCampos();
    }
}
