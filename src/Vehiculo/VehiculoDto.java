package Vehiculo;

import java.sql.Date;

public class VehiculoDto {

    private String numeroPlaca;
    private String marca;
    private String modelo;
    private int anio;
    private Date fechaInscripcion;
    private String cedulaPropietario;
    private String nombrePropietario;

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public String getCedulaPropietario() {
        return cedulaPropietario;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public VehiculoDto(String numeroPlaca, String marca, String modelo, int anio, Date fechaInscripcion, String cedulaPropietario, String nombrePropietario) {
        this.numeroPlaca = numeroPlaca;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.fechaInscripcion = fechaInscripcion;
        this.cedulaPropietario = cedulaPropietario;
        this.nombrePropietario = nombrePropietario;
    }

}
