package Tecnico;

import DaoDB.DaoBD;
import java.sql.SQLException;
import java.util.ArrayList;

public class TecnicoDao {

    // Insertar
    public boolean insertar(TecnicoDto tecnico) {
        DaoBD bd = new DaoBD();

        bd.crateStatement("INSERT INTO tecnicos VALUES (?, ?, ?, ?, ?, ?, ?)");
        bd.set(1, tecnico.getCedula());
        bd.set(2, tecnico.getNombre());
        bd.set(3, tecnico.getFechaNacimiento());
        bd.set(4, tecnico.getTelefono());
        bd.set(5, tecnico.getCorreo());
        bd.set(6, tecnico.getSalario());
        bd.set(7, tecnico.getContrasena());

        return bd.execute(false);
    }

    // Eliminar
    public boolean eliminar(String cedula) {
        DaoBD bd = new DaoBD();
        bd.crateStatement("DELETE FROM tecnicos WHERE cedula = ?");
        bd.set(1, cedula);
        return bd.execute(false);
    }

    // Modificar
    public boolean modificar(TecnicoDto tecnico) {
        DaoBD bd = new DaoBD();
        bd.crateStatement("UPDATE tecnicos SET nombre = ?, fecha_nacimiento = ?, telefono = ?, correo = ?, salario = ?, contrasena = ? WHERE cedula = ?");
        bd.set(1, tecnico.getNombre());
        bd.set(2, tecnico.getFechaNacimiento());
        bd.set(3, tecnico.getTelefono());
        bd.set(4, tecnico.getCorreo());
        bd.set(5, tecnico.getSalario());
        bd.set(6, tecnico.getContrasena());
        bd.set(7, tecnico.getCedula());
        return bd.execute(false);
    }

    // Buscar
    public TecnicoDto buscar(String cedula) {
        try {
            DaoBD bd = new DaoBD();

            bd.crateStatement("SELECT * FROM tecnicos WHERE cedula = ?");
            bd.set(1, cedula);
            bd.execute(true);

            if (bd.getData().next()) {
                String nombre = bd.getData().getString("nombre");
                String fechaNacimiento = bd.getData().getString("fecha_nacimiento");
                String telefono = bd.getData().getString("telefono");
                String correo = bd.getData().getString("correo");
                double salario = bd.getData().getDouble("salario");
                String contrasena = bd.getData().getString("contrasena");

                return new TecnicoDto(cedula, nombre, fechaNacimiento, telefono, correo, salario, contrasena);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // Obtener todos
    public ArrayList<TecnicoDto> obtenerTodo() {
        try {
            DaoBD bd = new DaoBD();

            bd.crateStatement("SELECT * FROM tecnicos");
            bd.execute(true);

            ArrayList<TecnicoDto> lista = new ArrayList<>();
            while (bd.getData().next()) {
                String cedula = bd.getData().getString("cedula");
                String nombre_completo = bd.getData().getString("nombre_completo");
                String fecha_nacimiento = bd.getData().getString("fecha_nacimiento");
                String telefono = bd.getData().getString("telefono");
                String correo_electronico = bd.getData().getString("correo_electronico");
                double salario = bd.getData().getDouble("salario");
                String contrasena = bd.getData().getString("contrasena");

                TecnicoDto tecnico = new TecnicoDto(cedula, nombre_completo, fecha_nacimiento, telefono, correo_electronico, salario, contrasena);
                lista.add(tecnico);
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

