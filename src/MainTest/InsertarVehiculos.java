/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainTest;

import Vehiculo.VehiculoDao;
import Vehiculo.VehiculoDto;
import java.sql.Date;

/**
 *
 * @author ´Felipe Chacón
 */
public class InsertarVehiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Crear una instancia de VehiculoDao
        VehiculoDao vehiculoDao = new VehiculoDao();

        // Realizar 20 inserciones
        for (int i = 0; i < 20; i++) {
            // Generar datos de ejemplo para cada vehículo
            String numeroPlaca = "ABC" + i;
            String marca = "Marca" + i;
            String modelo = "Modelo" + i;
            int anio = 2022 - i; // Año decreciente
            Date fechaInscripcion = Date.valueOf("2022-01-01");
            String cedulaPropietario = "123456789";
            String nombrePropietario = "Propietario" + i;

            // Crear un nuevo VehiculoDto con los datos generados
            VehiculoDto nuevoVehiculo = new VehiculoDto(
                    numeroPlaca,
                    marca,
                    modelo,
                    anio,
                    fechaInscripcion,
                    cedulaPropietario,
                    nombrePropietario
            );

            // Insertar el nuevo vehículo
            boolean insertarResultado = vehiculoDao.insertar(nuevoVehiculo);

            if (insertarResultado) {
                System.out.println("Vehículo insertado correctamente: " + nuevoVehiculo.getNumeroPlaca());
            } else {
                System.out.println("Error al insertar el vehículo: " + nuevoVehiculo.getNumeroPlaca());
            }
        }
    }
}
