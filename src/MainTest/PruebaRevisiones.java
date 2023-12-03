package MainTest;

import Revision.FrmRevisiones;
import Revision.RevisionControlador;
import Revision.RevisionDto;
import java.sql.Date;

public class PruebaRevisiones {

    public static void main(String[] args) {
        // Crear una instancia del controlador de revisiones
        RevisionControlador controlador = new RevisionControlador(new FrmRevisiones()); // Reemplaza FrmRevisiones con tu vista real

        // Crear una nueva revisión
        RevisionDto nuevaRevision = new RevisionDto(
                0, // El ID se generará automáticamente en la base de datos (clave AUTO_INCREMENT)
                Date.valueOf("2023-12-03"),
                java.sql.Time.valueOf("12:00:00"),
                "ID_TECNICO_AQUI", // Reemplaza con el ID del técnico correspondiente
                1, // Reemplaza con el ID de cita correspondiente
                "Inspección",
                "Observaciones de la revisión",
                "Aprobado"
        );

        // Agregar la nueva revisión utilizando el controlador
        controlador.agregar(nuevaRevision);
    }
}
