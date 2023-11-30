/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculo;

import java.sql.Date;

public class Vehiculo {

    private String numeroPlaca;
    private String marca;
    private String modelo;
    private int anio;
    private Date fechaInscripcion;
    private String cedulaPropietario;
    private String nombrePropietario;

    // Constructor
    public Vehiculo(String numeroPlaca, String marca, String modelo, int anio, Date fechaInscripcion,
            String cedulaPropietario, String nombrePropietario) {
        this.numeroPlaca = numeroPlaca;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.fechaInscripcion = fechaInscripcion;
        this.cedulaPropietario = cedulaPropietario;
        this.nombrePropietario = nombrePropietario;
    }

    // Métodos getter y setter

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getCedulaPropietario() {
        return cedulaPropietario;
    }

    public void setCedulaPropietario(String cedulaPropietario) {
        this.cedulaPropietario = cedulaPropietario;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    // Otros métodos si es necesario
}
