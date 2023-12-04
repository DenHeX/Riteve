package Revision;

import java.sql.Time;
import java.util.Date;

public class RevisionDto {
    private int idRevision;
    private Date fecha;
    private Time hora;
    private String idTecnico;
    private int idCita;
    private String tipoRevision;
    private String observaciones;
    private String estado;

    public RevisionDto(int idRevision, Date fecha, Time hora, String idTecnico, int idCita, String tipoRevision, String observaciones, String estado) {
        this.idRevision = idRevision;
        this.fecha = fecha;
        this.hora = hora;
        this.idTecnico = idTecnico;
        this.idCita = idCita;
        this.tipoRevision = tipoRevision;
        this.observaciones = observaciones;
        this.estado = estado;
    }
    
    public RevisionDto(Date fecha, Time hora, String idTecnico, int idCita, String tipoRevision, String observaciones, String estado) {
        this.idRevision = 0;
        this.fecha = fecha;
        this.hora = hora;
        this.idTecnico = idTecnico;
        this.idCita = idCita;
        this.tipoRevision = tipoRevision;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public int getIdRevision() {
        return idRevision;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public String getIdTecnico() {
        return idTecnico;
    }

    public int getIdCita() {
        return idCita;
    }

    public String getTipoRevision() {
        return tipoRevision;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getEstado() {
        return estado;
    }
    
}