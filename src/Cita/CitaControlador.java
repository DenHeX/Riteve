package Cita;

import Vehiculo.FrmVehiculos;
import Vehiculo.VehiculoDao;
import Vehiculo.VehiculoDto;
import static Views.FrmMenu.desktopMenu;
import Views.View;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CitaControlador {

    FrmCitas vista;

    public CitaControlador(FrmCitas vista) {
        this.vista = vista;
    }

    public void agregar(Cita cita) {
        if (!validarFechaYHora(cita.getFecha(), cita.getHora())) {
            return;
        }

        if (tieneCitaActiva(cita.getIdVehiculo())) {
            return;
        }

        if (!verificarExistenciaVehiculo(cita.getIdVehiculo())) {
            return;
        }

        if (hayCitasMismoHorario(cita.getFecha(), cita.getHora())) {
            return;
        }

        boolean exito = insertarCita(cita);

        if (exito) {
            vista.cargarDatos(cita);
            cargarTodo();
            vista.notificar("Cita guardada correctamente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.notificar("Error al guardar la cita", JOptionPane.ERROR_MESSAGE);
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
            vista.notificar("Error al modificar la cita", JOptionPane.ERROR_MESSAGE);
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

    public void abrirFrmVehiculos() {
        FrmVehiculos frm = new FrmVehiculos();
        View.showInternalVehiculos(desktopMenu, frm);
    }

    public void clear() {
        vista.txtCita.setText("");
        vista.txtFecha.setText("");
        vista.txtHora.setText("");
        vista.txtPlaca.setText("");
    }

    private boolean validarFechaYHora(Date fecha, Time hora) {
        java.util.Date fechaHoraActual = new java.util.Date();

        if (fecha.before(fechaHoraActual)
                || (fecha.equals(fechaHoraActual) && hora.before(new java.sql.Time(fechaHoraActual.getTime())))) {
            vista.notificar("La fecha y hora de la cita no pueden ser menores a la fecha y hora actual.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean tieneCitaActiva(String idVehiculo) {
        CitaDao citaDao = new CitaDao();
        boolean tieneCitaActiva = citaDao.verificarCitaActiva(idVehiculo);

        if (tieneCitaActiva) {
            vista.notificar("El vehículo ya tiene una cita activa.", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    private boolean verificarExistenciaVehiculo(String idVehiculo) {
        VehiculoDao vehiculoDao = new VehiculoDao();
        VehiculoDto vehiculoDto = vehiculoDao.buscar(idVehiculo);

        if (vehiculoDto == null) {
            vista.notificar("El vehículo no existe. Abriendo el formulario para agregar vehículo.", JOptionPane.WARNING_MESSAGE);
            abrirFrmVehiculos();
            return false;
        }
        return true;
    }

    private boolean hayCitasMismoHorario(Date fecha, Time hora) {
        CitaDao citaDao = new CitaDao();
        boolean hayCitasMismoHorario = citaDao.verificarCitasMismoHorario(fecha, hora);

        if (hayCitasMismoHorario) {
            vista.notificar("Ya hay cuatro citas registradas en la misma fecha y hora.", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    private boolean insertarCita(Cita cita) {
        CitaDao citaDao = new CitaDao();
        CitaDto citaDto = new CitaDto(
                cita.getFecha(),
                cita.getHora(),
                cita.getIdVehiculo()
        );
        return citaDao.insertar(citaDto);
    }

}
