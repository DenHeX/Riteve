/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainTest;

import Cita.Cita;
import Cita.CitaControlador;
import Cita.FrmCitas;
import java.sql.Date;
import java.sql.Time;

/**
 * Clase de prueba para el controlador de citas.
 */
public class CitaControladorTest {

    public static void main(String[] args) {
        // Crear una instancia de FrmCitas
        FrmCitas vista = new FrmCitas();

        // Instanciar el controlador y pasar la instancia de FrmCitas
        CitaControlador controlador = new CitaControlador(vista);

        // Agregar una cita
        Cita citaAgregar = new Cita(
                Date.valueOf("2022-12-01"),
                Time.valueOf("09:00:00"),
                "ABC16"
        );
        controlador.agregar(citaAgregar);

        // Modificar una cita (reemplaza los valores con los que deseas probar)
        Cita citaModificar = new Cita(
                14,  // ID de cita a modificar
                Date.valueOf("2023-01-02"), // Nueva fecha
                Time.valueOf("13:00:00"),   // Nueva hora
                "ABC123"                     // Nuevo ID de vehículo
        );

        // Llamar al método modificar del controlador
        controlador.modificar(citaModificar);
    
        // Buscar una cita
        int idCitaBuscar = 7;
        controlador.buscar(idCitaBuscar);

        // Eliminar una cita
        int idCitaEliminar = 7;
        controlador.eliminar(idCitaEliminar);

        // Cargar todas las citas
        controlador.cargarTodo();
    }
}
