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
}
