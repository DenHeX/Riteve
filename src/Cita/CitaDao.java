/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cita;

import DaoDB.DaoBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author ´Felipe Chacón
 */
public class CitaDao {

    // Insertar
    public boolean insertar(CitaDto cita) {
        DaoBD bd = new DaoBD();

        bd.crateStatement("INSERT INTO citas VALUES (?, ?, ?, ?)");
        bd.set(1, cita.getIdCita());
        bd.set(2, cita.getFecha());
        bd.set(3, cita.getHora());
        bd.set(4, cita.getIdVehiculo());

        return bd.execute(false);
    }

    // Eliminar
    public boolean eliminar(int idCita) {
        DaoBD bd = new DaoBD();
        bd.crateStatement("DELETE FROM citas WHERE id_cita = ?");
        bd.set(1, idCita);
        return bd.execute(false);
    }

    // Modificar
    public boolean modificar(CitaDto cita) {
        DaoBD bd = new DaoBD();
        bd.crateStatement("UPDATE citas SET fecha = ?, hora = ?, id_vehiculo = ? WHERE id_cita = ?");
        bd.set(1, cita.getFecha());
        bd.set(2, cita.getHora());
        bd.set(3, cita.getIdVehiculo());
        bd.set(4, cita.getIdCita());
        return bd.execute(false);
    }

    // Buscar
    public CitaDto buscar(int idCita) {
        try {
            DaoBD bd = new DaoBD();

            bd.crateStatement("SELECT * FROM citas WHERE id_cita = ?");
            bd.set(1, idCita);
            bd.execute(true);

            if (bd.getData().next()) {
                Date fecha = bd.getData().getDate("fecha");
                Time hora = bd.getData().getTime("hora");
                String idVehiculo = bd.getData().getString("id_vehiculo");

                return new CitaDto(idCita, fecha, hora, idVehiculo);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // Obtener todos
    public ArrayList<CitaDto> obtenerTodo() {
        try {
            DaoBD bd = new DaoBD();

            bd.crateStatement("SELECT * FROM citas");
            bd.execute(true);

            ArrayList<CitaDto> lista = new ArrayList<>();
            while (bd.getData().next()) {
                int idCita = bd.getData().getInt("id_cita");
                Date fecha = bd.getData().getDate("fecha");
                Time hora = bd.getData().getTime("hora");
                String idVehiculo = bd.getData().getString("id_vehiculo");

                CitaDto cita = new CitaDto(idCita, fecha, hora, idVehiculo);
                lista.add(cita);
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean verificarCitaActiva(String idVehiculo) {
        DaoBD bd = new DaoBD();
        bd.createCallableStatement("{CALL VerificarCitaActiva(?, ?)}");

        try {
            bd.set(1, idVehiculo);
            bd.set(2, 0); // El segundo parámetro es de salida, inicializado en 0

            bd.execute(true);

            // Obtener el resultado del procedimiento almacenado
            int citaActiva = bd.getData().getInt(2);

            return citaActiva > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int contarCitasEnMismoHorario(Date fecha, Time hora) {
        DaoBD bd = new DaoBD();
        bd.createCallableStatement("{CALL CitasMismoHorario(?, ?, ?)}");

        try {
            bd.set(1, fecha);
            bd.set(2, hora);
            bd.set(3, 0); // El tercer parámetro es de salida, inicializado en 0

            bd.execute(true);

            // Obtener el resultado del procedimiento almacenado
            int citasEnMismoHorario = bd.getData().getInt(3);

            return citasEnMismoHorario;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
