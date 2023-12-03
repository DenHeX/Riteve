package Revision;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RevisionControlador {

    private FrmRevisiones vista;

    public RevisionControlador(FrmRevisiones vista) {
        this.vista = vista;
    }

    public void agregar(RevisionDto revision) {
        RevisionDao dao = new RevisionDao();

        if (dao.buscar(revision.getIdRevision()) == null) {
            boolean exito = dao.insertar(revision);

            if (exito) {
                vista.notificar("Revisión agregada correctamente", JOptionPane.INFORMATION_MESSAGE);
                cargarTodo();
                clear();
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

    public void actualizar(RevisionDto revision) {
        RevisionDao dao = new RevisionDao();

        RevisionDto revisionExistente = dao.buscar(revision.getIdRevision());
        if (revisionExistente != null) {
            boolean exito = dao.actualizar(revision);

            if (exito) {
                vista.notificar("Revisión actualizada correctamente", JOptionPane.INFORMATION_MESSAGE);
                cargarTodo();
                clear();
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
            vista.mostrarRevisionEncontrada(revisionEncontrada);
            vista.notificar("Revisión encontrada", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("Revisión no encontrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarTodo() {
        RevisionDao dao = new RevisionDao();

        ArrayList<RevisionDto> listaRevisiones = dao.obtenerTodo();

        if (listaRevisiones != null) {
            vista.mostrarTodasLasRevisiones(listaRevisiones);
        } else {
            vista.notificar("Error al cargar las revisiones", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiar() {
        vista.limpiarCampos();
    }
}
