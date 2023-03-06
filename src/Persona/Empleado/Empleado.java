package Persona.Empleado;

public class Empleado extends Persona.Persona{
    private String codigo;
    private Double salario;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Empleado(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario) {
        super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento);
        this.codigo=codigo;
        this.salario=salario;
    }
}
