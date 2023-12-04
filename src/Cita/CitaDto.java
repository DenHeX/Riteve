package Cita;

import java.sql.Date;
import java.sql.Time;

public class CitaDto {

    private int idCita;
    private Date fecha;
    private Time hora;
    private String idVehiculo;

    public int getIdCita() {
        return idCita;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public CitaDto(Date fecha, Time hora, String idVehiculo) {
        this.idCita = 0;
        this.fecha = fecha;
        this.hora = hora;
        this.idVehiculo = idVehiculo;
    }

    public CitaDto(int idCita, Date fecha, Time hora, String idVehiculo) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.idVehiculo = idVehiculo;
    }

}
