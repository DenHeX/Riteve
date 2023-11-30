/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainTest;

import DaoDB.DaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainTest {

    public static void main(String[] args) {
        try {
            // Crear una instancia de DaoBD
            DaoBD daoBD = new DaoBD();

            // Probar el procedimiento almacenado InsertarTecnico
            daoBD.crateStatement("CALL InsertarTecnico(?, ?, ?, ?, ?, ?, ?)");
            daoBD.set(1, "123456789");
            daoBD.set(2, "Nombre Técnico");
            daoBD.set(3, java.sql.Date.valueOf("1990-01-01"));
            daoBD.set(4, "1234567890");
            daoBD.set(5, "tecnico@ejemplo.com");
            daoBD.set(6, 1000.0);
            daoBD.set(7, "contrasena");

            boolean resultado = daoBD.execute(false);

            if (resultado) {
                System.out.println("Técnico insertado correctamente.");
            } else {
                System.out.println("Error al insertar el técnico.");
            }

            // Probar el procedimiento almacenado BuscarTecnico
            daoBD.crateStatement("CALL BuscarTecnico(?)");
            daoBD.set(1, "123456789");

            resultado = daoBD.execute(true);

            if (resultado) {
                ResultSet resultSet = daoBD.getData();
                while (resultSet.next()) {
                    String nombreCompleto = resultSet.getString("nombre_completo");
                    System.out.println("Nombre del técnico encontrado: " + nombreCompleto);
                }
            } else {
                System.out.println("Error al buscar el técnico.");
            }

            // Probar el procedimiento almacenado ModificarTecnico
            daoBD.crateStatement("CALL ModificarTecnico(?, ?, ?, ?, ?, ?, ?)");
            daoBD.set(1, "123456789");
            daoBD.set(2, "Nuevo Nombre Técnico");
            daoBD.set(3, "1995-01-01");
            daoBD.set(4, "9876543210");
            daoBD.set(5, "nuevo_tecnico@ejemplo.com");
            daoBD.set(6, 1200.0);

            resultado = daoBD.execute(false);

            if (resultado) {
                System.out.println("Técnico modificado correctamente.");
            } else {
                System.out.println("Error al modificar el técnico.");
            }

            // Probar el procedimiento almacenado EliminarTecnico
            daoBD.crateStatement("CALL EliminarTecnico(?)");
            daoBD.set(1, "123456789");

            resultado = daoBD.execute(false);

            if (resultado) {
                System.out.println("Técnico eliminado correctamente.");
            } else {
                System.out.println("Error al eliminar el técnico.");
            }

            // Cerrar la conexión
            daoBD.getData().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
