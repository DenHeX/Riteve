package Cita;

import java.sql.Time;
import java.sql.Date;

public class Cita {

    private int idCita;
    private Date fecha;
    private Time hora;
    private String idVehiculo;

    public Cita(Date fecha, Time hora, String idVehiculo) {
        this.idCita = 0;
        this.fecha = fecha;
        this.hora = hora;
        this.idVehiculo = idVehiculo;
    }

    public Cita(int idCita, Date fecha, Time hora, String idVehiculo) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.idVehiculo = idVehiculo;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int id_cita) {
        this.idCita = idCita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String id_vehiculo) {
        this.idVehiculo = idVehiculo;
    }
    
}
