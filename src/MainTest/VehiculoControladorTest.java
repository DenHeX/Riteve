/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainTest;

import Vehiculo.FrmVehiculos;
import Vehiculo.Vehiculo;
import Vehiculo.VehiculoControlador;
import java.sql.Date;

/**
 *
 * @author ´Felipe Chacón
 */
public class VehiculoControladorTest {

    public static void main(String[] args) {
        // Crear una instancia de FrmVehiculos
        FrmVehiculos vista = new FrmVehiculos();

        // Instanciar el controlador y pasar la instancia de FrmVehiculos
        VehiculoControlador controlador = new VehiculoControlador(vista);;

        // Agregar un vehículo
        Vehiculo vehiculoAgregar = new Vehiculo(
                "ABC123",
                "Toyota",
                "Corolla",
                2022,
                Date.valueOf("2022-01-01"),
                "123456789",
                "Propietario Ejemplo"
        );
        controlador.agregar(vehiculoAgregar);

        // Modificar un vehículo
        Vehiculo vehiculoModificar = new Vehiculo(
                "ABC123",
                "Toyota",
                "Camry",
                2023,
                Date.valueOf("2023-01-01"),
                "987654321",
                "Nuevo Propietario"
        );
        controlador.modificar(vehiculoModificar);

        // Buscar un vehículo
        String placaBuscar = "ABC123";
        controlador.buscar(placaBuscar);

        // Eliminar un vehículo
        String placaEliminar = "ABC123";
        controlador.eliminar(placaEliminar);

        // Cargar todos los vehículos
        controlador.cargarTodo();
    }
}
