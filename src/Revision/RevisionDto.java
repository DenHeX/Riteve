package Revision;

import java.time.LocalDateTime;

public class RevisionDto {
    private LocalDateTime fecha;
    private String tecnico;
    private String tipo;
    private String observaciones;
    private String estado;

    public RevisionDto(LocalDateTime fecha, String tecnico, String tipo, String observaciones, String estado) {
        this.fecha = fecha;
        this.tecnico = tecnico;
        this.tipo = tipo;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getTecnico() {
        return tecnico;
    }

    public String getTipo() {
        return tipo;
    }

    public String getObservaciones() {
        return observaciones;
    }
    
    public String getEstado() {
        return estado;
    }
}

