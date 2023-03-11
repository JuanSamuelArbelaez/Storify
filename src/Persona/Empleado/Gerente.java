package Persona.Empleado;

import Persona.Cliente;

import java.util.HashSet;
public class Gerente extends Empleado{
    public Gerente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario, HashSet<Cliente> clientes) {
        super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento, codigo, salario, clientes);
        setManager(true);
        this.setPassword("Estructura");
    }
}
