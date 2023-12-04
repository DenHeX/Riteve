package Tecnico;

public class Tecnico {

    private String cedula;
    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String correo;
    private double salario;
    private int contrasena;

    public Tecnico(String cedula, String nombre, String fechaNacimiento, String telefono, String correo, double salario, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = salario;
        this.contrasena = encrypt(contrasena);
    }

    public Tecnico(String cedula, String nombre, String fechaNacimiento, String telefono, String correo, double salario, int contrasena) {

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

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = encrypt(contrasena);
    }

    private int encrypt(String contrasena) {
        return contrasena.hashCode();
    }

}
