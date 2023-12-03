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
    private int contrasena;

    public TecnicoDto(String cedula, String nombre, String fechaNacimiento, String telefono, String correo, double salario,String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = salario;
        this.contrasena = encrypt(contrasena);
    }
        public TecnicoDto(String cedula, String nombre, String fechaNacimiento, String telefono, String correo, double salario, int contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = salario;
        this.contrasena = contrasena;
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

    public int getContrasena() {
        return contrasena;
    }

    private int encrypt(String contrasena) {
        return contrasena.hashCode();
    }
    
}
