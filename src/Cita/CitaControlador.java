/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cita;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Controlador para gestionar las citas de revisión vehicular. Se asume la
 * existencia de un formulario FrmCitas. Asegúrate de ajustar los nombres de las
 * clases según tu implementación.
 */
public class CitaControlador {

    FrmCitas vista;

    public CitaControlador(FrmCitas vista) {
        this.vista = vista;
    }

    public void agregar(Cita cita) {
        CitaDao dao = new CitaDao();

        try {
            // Verificar si hay una cita activa para el vehículo
            if (dao.verificarCitaActiva(cita.getIdVehiculo())) {
                notificarError("El vehículo ya tiene una cita activa.");
                return;
            }

            // Verificar cuántas citas hay en el mismo horario
            int citasEnMismoHorario = dao.contarCitasEnMismoHorario(cita.getFecha(), cita.getHora());
            if (citasEnMismoHorario >= 4) {
                notificarError("Ya existen 4 citas registradas en el mismo horario.");
                return;
            }

            // Agregar la nueva cita
            CitaDto dto = new CitaDto(
                    cita.getFecha(),
                    cita.getHora(),
                    cita.getIdVehiculo()
            );

            boolean exito = dao.insertar(dto);

            if (exito) {
                vista.cargarDatos(cita);
                cargarTodo();
                notificarExito("Cita guardada correctamente");
            } else {
                notificarError("Error al guardar la cita");
            }
        } catch (Exception e) {
            e.printStackTrace();
            notificarError("Error inesperado al agregar la cita");
        }
    }

    public void eliminar(int idCita) {
        CitaDao dao = new CitaDao();
        boolean exito = dao.eliminar(idCita);

        if (exito) {
            this.cargarTodo();
            vista.notificar("Cita eliminada correctamente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("Error al eliminar la cita", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificar(Cita cita) {
        CitaDao dao = new CitaDao();

        try {
            // Verificar si hay una cita activa para el vehículo
            if (dao.verificarCitaActiva(cita.getIdVehiculo())) {
                notificarError("El vehículo ya tiene una cita activa.");
                return;
            }

            // Verificar cuántas citas hay en el mismo horario
            int citasEnMismoHorario = dao.contarCitasEnMismoHorario(cita.getFecha(), cita.getHora());
            if (citasEnMismoHorario >= 4) {
                notificarError("Ya existen 4 citas registradas en el mismo horario.");
                return;
            }

            // Modificar la cita existente
            CitaDto dto = new CitaDto(
                    cita.getIdCita(),
                    cita.getFecha(),
                    cita.getHora(),
                    cita.getIdVehiculo()
            );

            boolean exito = dao.modificar(dto);

            if (exito) {
                this.cargarTodo();
                vista.notificar("Cita modificada correctamente", JOptionPane.INFORMATION_MESSAGE);
            } else {
                notificarError("Error al modificar la cita");
            }
        } catch (Exception e) {
            e.printStackTrace();
            notificarError("Error inesperado al modificar la cita");
        }
    }

    public void buscar(int idCita) {
        CitaDao dao = new CitaDao();
        CitaDto citaDto = dao.buscar(idCita);

        if (citaDto != null) {
            Cita cita = new Cita(
                    idCita,
                    citaDto.getFecha(),
                    citaDto.getHora(),
                    citaDto.getIdVehiculo()
            );

            vista.cargarDatos(cita);
            vista.notificar("Cita encontrada", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("Cita no encontrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarTodo() {
        CitaDao dao = new CitaDao();
        ArrayList<CitaDto> lista = dao.obtenerTodo();
        if (lista != null) {
            vista.mostrarTodo(lista);
        }
    }

    // Deja este método vacío, todavía no he hecho el Frame de Citas
    public void clear() {
        vista.txtFecha.setText("");
        vista.txtHora.setText("");
        vista.txtPlaca.setText("");
    }

    private void notificarExito(String mensaje) {
        vista.notificar(mensaje, JOptionPane.INFORMATION_MESSAGE);
    }

    private void notificarError(String mensaje) {
        vista.notificar(mensaje, JOptionPane.ERROR_MESSAGE);
    }

}
