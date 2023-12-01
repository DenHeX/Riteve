/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cita;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author ´Felipe Chacón
 */
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

    // Constructor para nuevas citas
    public CitaDto(Date fecha, Time hora, String idVehiculo) {
        this.idCita = 0;  // Al ser autoincremental, el valor se asignará automáticamente en la base de datos
        this.fecha = fecha;
        this.hora = hora;
        this.idVehiculo = idVehiculo;
    }

    // Constructor para citas existentes (cargadas desde la base de datos)
    public CitaDto(int idCita, Date fecha, Time hora, String idVehiculo) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.idVehiculo = idVehiculo;
    }

}
