/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainTest;
import Vehiculo.VehiculoDao;
import Vehiculo.VehiculoDto;
import java.util.ArrayList;
import java.sql.Date;

public class VehiculoDaoTest {

    public static void main(String[] args) {
        // Crear una instancia de VehiculoDao
        VehiculoDao vehiculoDao = new VehiculoDao();

        // Insertar un nuevo vehículo
        VehiculoDto nuevoVehiculo = new VehiculoDto(
            "ABC123",
            "Toyota",
            "Corolla",
            2022,
            Date.valueOf("2022-01-01"),
            "123456789",
            "Propietario Ejemplo"
        );

        boolean insertarResultado = vehiculoDao.insertar(nuevoVehiculo);

        if (insertarResultado) {
            System.out.println("Vehículo insertado correctamente.");
        } else {
            System.out.println("Error al insertar el vehículo.");
        }

        // Buscar un vehículo por número de placa
        String numeroPlacaBuscar = "ABC123";
        VehiculoDto vehiculoEncontrado = vehiculoDao.buscar(numeroPlacaBuscar);

        if (vehiculoEncontrado != null) {
            System.out.println("Vehículo encontrado: " + vehiculoEncontrado);
        } else {
            System.out.println("No se encontró el vehículo con número de placa: " + numeroPlacaBuscar);
        }

        // Modificar un vehículo
        VehiculoDto vehiculoModificado = new VehiculoDto(
            "ABC123",
            "Toyota",
            "Camry",  // Modelo modificado
            2022,
            Date.valueOf("2022-01-01"),
            "123456789",
            "Propietario Modificado"
        );

        boolean modificarResultado = vehiculoDao.modificar(vehiculoModificado);

        if (modificarResultado) {
            System.out.println("Vehículo modificado correctamente.");
        } else {
            System.out.println("Error al modificar el vehículo.");
        }

//        // Eliminar un vehículo
//        String numeroPlacaEliminar = "ABC123";
//        boolean eliminarResultado = vehiculoDao.eliminar(numeroPlacaEliminar);
//
//        if (eliminarResultado) {
//            System.out.println("Vehículo eliminado correctamente.");
//        } else {
//            System.out.println("Error al eliminar el vehículo.");
//        }
//
//        // Obtener todos los vehículos
//        ArrayList<VehiculoDto> listaVehiculos = vehiculoDao.obtenerTodo();
//
//        if (!listaVehiculos.isEmpty()) {
//            System.out.println("Lista de vehículos:");
//            for (VehiculoDto vehiculo : listaVehiculos) {
//                System.out.println(vehiculo);
//            }
//        } else {
//            System.out.println("No hay vehículos en la base de datos.");
//        }
    }
}