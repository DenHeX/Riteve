/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainTest;

import Cita.Cita;
import Cita.CitaControlador;
import Cita.FrmCitas;
import java.util.concurrent.ThreadLocalRandom;
import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author ´Felipe Chacón
 */
public class InsertarDatosCitas {

    public static void main(String[] args) {
        CitaControlador controlador = new CitaControlador(new FrmCitas());

        // Placas existentes en la base de datos
        String[] placas = {"ABC16", "ABC17", "ABC19", "ABC3", "ABC4", "ABC6", "ABC5", "ABC9", "ABC19", "ABC13"};

        // Insertar 10 datos de citas con placas existentes
        for (int i = 0; i < 10; i++) {
            Cita cita = generarCitaConPlacaExistente(placas[i % placas.length]);
            controlador.agregar(cita);
        }
    }

    private static Cita generarCitaConPlacaExistente(String placa) {
        // Generar una fecha aleatoria en el rango de 2022-01-01 a 2023-01-01
        long fechaMillis = ThreadLocalRandom.current().nextLong(
                Date.valueOf("2022-01-01").getTime(),
                Date.valueOf("2023-01-01").getTime()
        );
        Date fecha = new Date(fechaMillis);

        // Generar una hora aleatoria en el rango de 00:00:00 a 23:59:59
        long horaMillis = ThreadLocalRandom.current().nextLong(
                Time.valueOf("00:00:00").getTime(),
                Time.valueOf("23:59:59").getTime()
        );
        Time hora = new Time(horaMillis);

        return new Cita(fecha, hora, placa);
    }
}
