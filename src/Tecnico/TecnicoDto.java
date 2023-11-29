package Tecnico;

/**
 *
 * @author ´Ronny Sandino
 */
public class TecnicoDto {

    private String cedula;
    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String correo;
    private double salario;
    private String password;

    public TecnicoDto(String cedula, String nombre, String fechaNacimiento, String telefono, String correo, double salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = salario;
        this.password = "";
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public double getSalario() {
        return salario;
    }

    public String getPassword() {
        return password;
    }

}
