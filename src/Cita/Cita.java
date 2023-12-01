/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cita;

import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author ´Felipe Chacón
 */
public class Cita {

    private int idCita;
    private Date fecha;
    private Time hora;
    private String idVehiculo;

    // Constructor para nuevas citas
    public Cita(Date fecha, Time hora, String idVehiculo) {
        this.idCita = 0;  // Al ser autoincremental, el valor se asignará automáticamente en la base de datos
        this.fecha = fecha;
        this.hora = hora;
        this.idVehiculo = idVehiculo;
    }

    // Constructor para citas existentes (cargadas desde la base de datos)
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
