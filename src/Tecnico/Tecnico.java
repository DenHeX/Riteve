package Tecnico;

/**
 *
 * @author ´Ronny Sandino
 */
public class Tecnico {

    private String cedula;
    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String correo;
    private double salario;
    private String contrasena;

    public Tecnico(String cedula, String nombre, String fechaNacimiento, String telefono, String correo, double salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = salario;
        this.contrasena = "";
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

    public String getContrasena() {
        return contrasena;
    }

    public void setPassword(String contrasena) {
        this.contrasena = contrasena;
    }

    public void calcularDeducciones() {
        double enfermedadMaternidad = salario * 0.055;
        double invalidezMuerte = salario * 0.0384;
        double aporteTrabajador = salario * 0.01;
        double aporteSolidarista = salario * 0.033;

        // Impuesto sobre la renta
        double exento = 817000;
        double impuestoRenta = 0;

        if (salario > exento && salario <= 1226000) {
            impuestoRenta = (salario - exento) * 0.1;
        } else if (salario > 1226000) {
            impuestoRenta = (salario - 1226000) * 0.15 + (1226000 - exento) * 0.1;
        }
        // Restar impuesto después del cálculo
        double salarioNeto = salario - enfermedadMaternidad - invalidezMuerte - aporteTrabajador - aporteSolidarista - impuestoRenta;
    }

    public void cambiarContrasena(String contrasenaActual, String nuevaContrasena) {
        if (validarContrasena(contrasenaActual)) {
            this.contrasena = nuevaContrasena;
            System.out.println("Contraseña cambiada exitosamente.");
        } else {
            System.out.println("Error: Contraseña actual incorrecta.");
        }
    }

    public boolean validarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }
}
