package Revision;

import DaoDB.DaoBD;
import java.util.Date;
import java.sql.Time;
import java.sql.SQLException;
import java.util.ArrayList;

public class RevisionDao {

    public boolean insertar(RevisionDto revision) {
        DaoBD bd = new DaoBD();

        bd.createStatement("INSERT INTO revisiones (fecha, hora, id_tecnico, id_cita, tipo_revision, observaciones, estado) VALUES (?, ?, ?, ?, ?, ?, ?)");
        bd.set(1, revision.getFecha());
        bd.set(2, revision.getHora());
        bd.set(3, revision.getIdTecnico());
        bd.set(4, revision.getIdCita());
        bd.set(5, revision.getTipoRevision());
        bd.set(6, revision.getObservaciones());
        bd.set(7, revision.getEstado());

        return bd.execute(false);
    }

    public boolean eliminar(int idRevision) {
        DaoBD bd = new DaoBD();
        bd.createStatement("DELETE FROM revisiones WHERE id_revision = ?");
        bd.set(1, idRevision);
        return bd.execute(false);
    }

    public boolean actualizar(RevisionDto revision) {
        DaoBD bd = new DaoBD();
        bd.createStatement("UPDATE revisiones SET fecha = ?, hora = ?, id_tecnico = ?, id_cita = ?, tipo_revision = ?, observaciones = ?, estado = ? WHERE id_revision = ?");
        bd.set(1, revision.getFecha());
        bd.set(2, revision.getHora());
        bd.set(3, revision.getIdTecnico());
        bd.set(4, revision.getIdCita());
        bd.set(5, revision.getTipoRevision());
        bd.set(6, revision.getObservaciones());
        bd.set(7, revision.getEstado());
        bd.set(8, revision.getIdRevision());
        return bd.execute(false);
    }

    public RevisionDto buscar(int idRevision) {
        try {
            DaoBD bd = new DaoBD();

            bd.createStatement("SELECT * FROM revisiones WHERE id_revision = ?");
            bd.set(1, idRevision);
            bd.execute(true);

            if (bd.getData().next()) {
                Date fecha = bd.getData().getDate("fecha");
                Time hora = bd.getData().getTime("hora");
                String idTecnico = bd.getData().getString("id_tecnico");
                int idCita = bd.getData().getInt("id_cita");
                String tipoRevision = bd.getData().getString("tipo_revision");
                String observaciones = bd.getData().getString("observaciones");
                String estado = bd.getData().getString("estado");

                return new RevisionDto(idRevision, fecha, hora, idTecnico, idCita, tipoRevision, observaciones, estado);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<RevisionDto> obtenerTodo() {
        try {
            DaoBD bd = new DaoBD();

            bd.createStatement("SELECT * FROM revisiones");
            bd.execute(true);

            ArrayList<RevisionDto> lista = new ArrayList<>();
            while (bd.getData().next()) {
                int idRevision = bd.getData().getInt("id_revision");
                Date fecha = bd.getData().getDate("fecha");
                Time hora = bd.getData().getTime("hora");
                String idTecnico = bd.getData().getString("id_tecnico");
                int idCita = bd.getData().getInt("id_cita");
                String tipoRevision = bd.getData().getString("tipo_revision");
                String observaciones = bd.getData().getString("observaciones");
                String estado = bd.getData().getString("estado");

                RevisionDto revision = new RevisionDto(idRevision, fecha, hora, idTecnico, idCita, tipoRevision, observaciones, estado);
                lista.add(revision);
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
