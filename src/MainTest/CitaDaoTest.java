/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainTest;

import Cita.CitaDao;
import Cita.CitaDto;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class CitaDaoTest {

    public static void main(String[] args) {
        // Crear una instancia de CitaDao
        CitaDao citaDao = new CitaDao();

//        // Insertar una nueva cita
        CitaDto nuevaCita = new CitaDto(
            Date.valueOf("2023-08-09"),
            Time.valueOf("12:00:00"),
            "1"
        );

        boolean insertarResultado = citaDao.insertar(nuevaCita);

        if (insertarResultado) {
            System.out.println("Cita insertada correctamente.");
        } else {
            System.out.println("Error al insertar la cita.");
        }

        // Buscar una cita por id
        int idCitaBuscar = 3;
        CitaDto citaEncontrada = citaDao.buscar(idCitaBuscar);

        if (citaEncontrada != null) {
            System.out.println("Cita encontrada: " + citaEncontrada);
        } else {
            System.out.println("No se encontró la cita con ID: " + idCitaBuscar);
        }

    // Supongamos que tienes el id_cita de la cita que deseas modificar
        int idCitaAModificar = 3; // Reemplaza esto con el id_cita real que deseas modificar

    // Modificar una cita
        CitaDto citaModificada = new CitaDto(
                idCitaAModificar, // Id de la cita que deseas modificar
                Date.valueOf("2023-01-09"), // Fecha modificada
                Time.valueOf("13:00:00"), // Hora modificada
                "ABC123"
        );

        boolean modificarResultado = citaDao.modificar(citaModificada);

        if (modificarResultado) {
            System.out.println("Cita modificada correctamente.");
        } else {
            System.out.println("Error al modificar la cita.");
        }

        // Eliminar una cita
        int idCitaEliminar = 3;
        boolean eliminarResultado = citaDao.eliminar(idCitaEliminar);

        if (eliminarResultado) {
            System.out.println("Cita eliminada correctamente.");
        } else {
            System.out.println("Error al eliminar la cita.");
        }
        // Obtener todas las citas
        ArrayList<CitaDto> listaCitas = citaDao.obtenerTodo();

        if (!listaCitas.isEmpty()) {
            System.out.println("Lista de citas:");
            for (CitaDto cita : listaCitas) {
                System.out.println(cita);
            }
        } else {
            System.out.println("No hay citas en la base de datos.");
        }
    }
}
