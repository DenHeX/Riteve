package Revision;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RevisionControlador {
    private ArrayList<Revision> listaRevisiones;

    public RevisionControlador() {
        listaRevisiones = new ArrayList<>();
    }

    public void agregarRevision(LocalDateTime fecha, String tecnico, String tipo, String observaciones, String estado) {
        Revision nuevaRevision = new Revision(fecha, tecnico, tipo, observaciones, estado);
        listaRevisiones.add(nuevaRevision);
    }

    public void modificarRevision(int indice, LocalDateTime fecha, String tecnico, String tipo, String observaciones, String estado) {
        if (indice >= 0 && indice < listaRevisiones.size()) {
            Revision revision = listaRevisiones.get(indice);
            revision.setFecha(fecha);
            revision.setTecnico(tecnico);
            revision.setTipo(tipo);
            revision.setObservaciones(observaciones);
            revision.setEstado(estado);
        } else {
            System.out.println("Índice fuera de rango");
        }
    }

    public void eliminarRevision(int indice) {
        if (indice >= 0 && indice < listaRevisiones.size()) {
            listaRevisiones.remove(indice);
        } else {
            System.out.println("Índice fuera de rango");
        }
    }

    public Revision obtenerRevision(int indice) {
        if (indice >= 0 && indice < listaRevisiones.size()) {
            return listaRevisiones.get(indice);
        } else {
            System.out.println("Índice fuera de rango");
            return null;
        }
    }

    public ArrayList<Revision> obtenerTodasRevisiones() {
        return listaRevisiones;
    }
}

