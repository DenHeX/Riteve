/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainTest;

import DaoDB.DaoBD;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public class PruebaMetodos {

    public static void main(String[] args) {
        probarVerificarCitaActiva();
        probarContarCitasEnMismoHorario();
    }

    private static void probarVerificarCitaActiva() {
        try {
            String idVehiculo = "ABC123"; // Reemplaza con el ID de vehículo que deseas probar
            boolean citaActiva = verificarCitaActiva(idVehiculo);

            if (citaActiva) {
                System.out.println("El vehículo tiene una cita activa.");
            } else {
                System.out.println("El vehículo no tiene una cita activa.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void probarContarCitasEnMismoHorario() {
        try {
            Date fecha = Date.valueOf("2022-12-01"); // Reemplaza con la fecha que deseas probar
            Time hora = Time.valueOf("09:00:00"); // Reemplaza con la hora que deseas probar

            int citasEnMismoHorario = contarCitasEnMismoHorario(fecha, hora);

            System.out.println("Número de citas en el mismo horario: " + citasEnMismoHorario);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean verificarCitaActiva(String idVehiculo) throws SQLException {
        DaoBD bd = new DaoBD();
        bd.createCallableStatement("{CALL VerificarCitaActiva(?, ?)}");

        try {
            bd.set(1, idVehiculo);
            bd.set(2, 0); // El segundo parámetro es de salida, inicializado en 0

            bd.execute(true);

            // Obtener el resultado del procedimiento almacenado
            int citaActiva = bd.getData().getInt(2);

            return citaActiva > 0;
        } catch (SQLException ex) {
            throw ex;
        } 
    }

    private static int contarCitasEnMismoHorario(Date fecha, Time hora) throws SQLException {
        DaoBD bd = new DaoBD();
        bd.createCallableStatement("{CALL CitasMismoHorario(?, ?, ?)}");

        try {
            bd.set(1, fecha);
            bd.set(2, hora);
            bd.set(3, 0); // El tercer parámetro es de salida, inicializado en 0

            bd.execute(true);

            // Obtener el resultado del procedimiento almacenado
            int citasEnMismoHorario = bd.getData().getInt(3);

            return citasEnMismoHorario;
        } catch (SQLException ex) {
            throw ex;
        }
    }
}