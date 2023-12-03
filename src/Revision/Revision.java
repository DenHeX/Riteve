package Revision;

import java.sql.Time;
import java.sql.Date;

public class Revision {
    private int idRevision;
    private Date fecha;
    private Time hora;
    private String idTecnico;
    private int idCita;
    private String tipoRevision;
    private String observaciones;
    private String estado;

    public Revision(int idRevision, Date fecha, Time hora, String idTecnico, int idCita, String tipoRevision, String observaciones, String estado) {
        this.idRevision = idRevision;
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

    public void setIdRevision(int idRevision) {
        this.idRevision = idRevision;
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

    public String getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(String idTecnico) {
        this.idTecnico = idTecnico;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getTipoRevision() {
        return tipoRevision;
    }

    public void setTipoRevision(String tipoRevision) {
        this.tipoRevision = tipoRevision;
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