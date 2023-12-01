/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoDB;

import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rsand
 */
public class DaoBD {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultset;

    public DaoBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connect();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver");
        }
    }

    public void createCallableStatement(String sql) {
        try {
            this.statement = this.connection.prepareCall(sql);
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento almacenado" + ex.toString());
        }
    }

    private void connect() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/riteve", "java", "123");
        } catch (SQLException ex) {
            System.out.println("Error al conectar");
        }
    }

    public void createStatement(String sql) {
        try {
            this.statement = this.connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia" + ex.toString());
        }
    }

    public void set(int index, Object param) {
        try {
            this.statement.setObject(index, param);
        } catch (SQLException ex) {
            System.out.println("Error al agregar parametro" + ex.toString());
        }
    }

    public boolean execute(boolean result) {
        if (result) {
            try {
                this.resultset = this.statement.executeQuery();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error al ejecutar" + ex.toString());
                return false;
            }
        } else {
            try {
                int cont = this.statement.executeUpdate();
                this.resultset = statement.getGeneratedKeys();
                return cont > 0;
            } catch (SQLException ex) {
                System.out.println("Error al ejecutar" + ex.toString());
                return false;
            }
        }
    }

    public ResultSet executeQuery() {
        try {
            this.resultset = this.statement.executeQuery();
            return this.resultset;
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar consulta: " + ex.toString());
            return null;
        }
    }

    public void setOutputParameter(int index, int sqlType) {
        try {
            ((CallableStatement) this.statement).registerOutParameter(index, sqlType);
        } catch (SQLException ex) {
            System.out.println("Error al agregar parámetro de salida: " + ex.toString());
        }
    }

    public int getOutputParameterValue(int index) {
        try {
            return ((CallableStatement) this.statement).getInt(index);
        } catch (SQLException ex) {
            System.out.println("Error al obtener valor de parámetro de salida: " + ex.toString());
            return 0; // Otra opción: lanzar una excepción o manejar de otra manera
        }
    }

    public ResultSet getData() {
        return this.resultset;
    }
}
