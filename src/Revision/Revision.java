package Revision;

import java.time.LocalDateTime;

public class Revision {
    private LocalDateTime fecha;
    private String tecnico;
    private String tipo;
    private String observaciones;
    private String estado;

    public Revision(LocalDateTime fecha, String tecnico, String tipo, String observaciones, String estado) {
        this.fecha = fecha;
        this.tecnico = tecnico;
        this.tipo = tipo;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

