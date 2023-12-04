package Vehiculo;

import DaoDB.DaoBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class VehiculoDao {

    public boolean insertar(VehiculoDto vehiculo) {
        DaoBD bd = new DaoBD();

        bd.createStatement("INSERT INTO vehiculos VALUES (?, ?, ?, ?, ?, ?, ?)");
        bd.set(1, vehiculo.getNumeroPlaca());
        bd.set(2, vehiculo.getMarca());
        bd.set(3, vehiculo.getModelo());
        bd.set(4, vehiculo.getAnio());
        bd.set(5, vehiculo.getFechaInscripcion());
        bd.set(6, vehiculo.getCedulaPropietario());
        bd.set(7, vehiculo.getNombrePropietario());

        return bd.execute(false);
    }

    public boolean eliminar(String numeroPlaca) {
        DaoBD bd = new DaoBD();
        bd.createStatement("DELETE FROM vehiculos WHERE numero_placa = ?");
        bd.set(1, numeroPlaca);
        return bd.execute(false);
    }

    public boolean modificar(VehiculoDto vehiculo) {
        DaoBD bd = new DaoBD();
        bd.createStatement("UPDATE vehiculos SET marca = ?, modelo = ?, anio = ?, fecha_inscripcion = ?, cedula_propietario = ?, nombre_propietario = ? WHERE numero_placa = ?");
        bd.set(1, vehiculo.getMarca());
        bd.set(2, vehiculo.getModelo());
        bd.set(3, vehiculo.getAnio());
        bd.set(4, vehiculo.getFechaInscripcion());
        bd.set(5, vehiculo.getCedulaPropietario());
        bd.set(6, vehiculo.getNombrePropietario());
        bd.set(7, vehiculo.getNumeroPlaca());
        return bd.execute(false);
    }

    public VehiculoDto buscar(String numeroPlaca) {
        try {
            DaoBD bd = new DaoBD();

            bd.createStatement("SELECT * FROM vehiculos WHERE numero_placa = ?");
            bd.set(1, numeroPlaca);
            bd.execute(true);

            if (bd.getData().next()) {
                String marca = bd.getData().getString("marca");
                String modelo = bd.getData().getString("modelo");
                int anio = bd.getData().getInt("anio");
                Date fechaInscripcion = bd.getData().getDate("fecha_inscripcion");
                String cedulaPropietario = bd.getData().getString("cedula_propietario");
                String nombrePropietario = bd.getData().getString("nombre_propietario");

                return new VehiculoDto(numeroPlaca, marca, modelo, anio, fechaInscripcion, cedulaPropietario, nombrePropietario);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<VehiculoDto> obtenerTodo() {
        try {
            DaoBD bd = new DaoBD();

            bd.createStatement("SELECT * FROM vehiculos");
            bd.execute(true);

            ArrayList<VehiculoDto> lista = new ArrayList<>();
            while (bd.getData().next()) {
                String numeroPlaca = bd.getData().getString("numero_placa");
                String marca = bd.getData().getString("marca");
                String modelo = bd.getData().getString("modelo");
                int anio = bd.getData().getInt("anio");
                Date fechaInscripcion = bd.getData().getDate("fecha_inscripcion");
                String cedulaPropietario = bd.getData().getString("cedula_propietario");
                String nombrePropietario = bd.getData().getString("nombre_propietario");

                VehiculoDto vehiculo = new VehiculoDto(numeroPlaca, marca, modelo, anio, fechaInscripcion, cedulaPropietario, nombrePropietario);
                lista.add(vehiculo);
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
