/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainTest;
import Cita.CitaDao;
import java.sql.Date;
import java.sql.Time;

public class CitaDaoTest2 {

    public static void main(String[] args) {
        CitaDao citaDao = new CitaDao();

        // Prueba de verificarCitaActiva
        String idVehiculo = "ABC123"; // Reemplaza con un ID de vehículo existente en tu base de datos
        boolean citaActiva = citaDao.verificarCitaActiva(idVehiculo);
        System.out.println("¿La cita está activa para el vehículo? " + citaActiva);

        // Prueba de contarCitasEnMismoHorario
        Date fecha = Date.valueOf("2022-12-31"); // Reemplaza con una fecha existente en tu base de datos
        Time hora = Time.valueOf("14:22:10"); // Reemplaza con una hora existente en tu base de datos
        int citasEnMismoHorario = citaDao.contarCitasEnMismoHorario(fecha, hora);
        System.out.println("Número de citas en el mismo horario: " + citasEnMismoHorario);
    }
}
