/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainTest;

import Cita.CitaDao;
import java.sql.Date;
import java.sql.Time;

public class PruebaCitaDao {

    public static void main(String[] args) {
        probarCitasMismoHorario();
        probarVerificarCitaActiva();
    }

    private static void probarCitasMismoHorario() {
        CitaDao citaDao = new CitaDao();

        // Definir una fecha y hora para la prueba
        Date fecha = Date.valueOf("2023-12-06");
        Time hora = Time.valueOf("00:00:00");

        // Llamar al procedimiento CitasMismoHorario
        boolean resultado = citaDao.verificarCitasMismoHorario(fecha, hora);

        // Imprimir el resultado
        System.out.println("¿Hay cuatro citas en el mismo horario? " + resultado);
    }

    private static void probarVerificarCitaActiva() {
        CitaDao citaDao = new CitaDao();

        // Definir un ID de vehículo para la prueba
        String idVehiculo = "ABC1";

        // Llamar al procedimiento VerificarCitaActiva
        boolean resultado = citaDao.verificarCitaActiva(idVehiculo);

        // Imprimir el resultado
        System.out.println("¿Hay una cita activa para el vehículo? " + resultado);
    }
}