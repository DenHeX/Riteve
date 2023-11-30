/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculo;

import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ´Felipe Chacón
 */
public class VehiculoControlador {

    FrmVehiculos vista;

    public VehiculoControlador(FrmVehiculos vista) {
        this.vista = vista;
    }

    public void agregar(Vehiculo vehiculo) {
        VehiculoDao dao = new VehiculoDao();

        if (dao.buscar(vehiculo.getNumeroPlaca()) == null) {
            VehiculoDto dto = new VehiculoDto(
                    vehiculo.getNumeroPlaca(),
                    vehiculo.getMarca(),
                    vehiculo.getModelo(),
                    vehiculo.getAnio(),
                    vehiculo.getFechaInscripcion(), // No necesitas convertir, ya es de tipo java.sql.Date
                    vehiculo.getCedulaPropietario(),
                    vehiculo.getNombrePropietario()
            );

            boolean exito = dao.insertar(dto);

            if (exito) {
                vehiculo.setNumeroPlaca(dto.getNumeroPlaca());
                vista.cargarDatos(vehiculo);
                cargarTodo();
                vista.notificar("Vehículo guardado correctamente", JOptionPane.INFORMATION_MESSAGE);
            } else {
                vista.notificar("Error al guardar el vehículo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            vista.notificar("El vehículo ya se encuentra registrado", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar(String numeroPlaca) {
        VehiculoDao dao = new VehiculoDao();
        boolean exito = dao.eliminar(numeroPlaca);

        if (exito) {
            this.cargarTodo();
            vista.notificar("Vehículo eliminado correctamente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("Error al eliminar el vehículo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificar(Vehiculo vehiculo) {
        VehiculoDao dao = new VehiculoDao();
        VehiculoDto dto = new VehiculoDto(
                vehiculo.getNumeroPlaca(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getAnio(),
                vehiculo.getFechaInscripcion(),
                vehiculo.getCedulaPropietario(),
                vehiculo.getNombrePropietario()
        );

        boolean exito = dao.modificar(dto);

        if (exito) {
            this.cargarTodo();
            vista.notificar("Vehículo modificado correctamente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("Error al modificar el vehículo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscar(String numeroPlaca) {
        VehiculoDao dao = new VehiculoDao();
        VehiculoDto vehiculoDto = dao.buscar(numeroPlaca);

        if (vehiculoDto != null) {
            Vehiculo vehiculo = new Vehiculo(
                    vehiculoDto.getNumeroPlaca(),
                    vehiculoDto.getMarca(),
                    vehiculoDto.getModelo(),
                    vehiculoDto.getAnio(),
                    vehiculoDto.getFechaInscripcion(),
                    vehiculoDto.getCedulaPropietario(),
                    vehiculoDto.getNombrePropietario()
            );

            vista.cargarDatos(vehiculo);
            vista.notificar("Vehículo encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("Vehículo no encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarTodo() {
        VehiculoDao dao = new VehiculoDao();
        ArrayList<VehiculoDto> lista = dao.obtenerTodo();
        if (lista != null) {
            vista.mostrarTodo(lista);
        }
    }

    public void clear() {
        vista.txtPlaca.setText("");
        vista.txtMarca.setText("");
        vista.txtModelo.setText("");
        vista.txtAnio.setText("");
        vista.txtFechadeInscripcion.setText("");
        vista.txtCedulaPropietario.setText("");
        vista.txtNombrePropietario.setText("");
    }

}
