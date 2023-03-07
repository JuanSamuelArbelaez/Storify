package Banco;

import Cuenta.Cuenta;
import Persona.Cliente;
import Persona.Empleado.Empleado;
import Transaccion.Transaccion;

import java.util.HashMap;
import java.util.HashSet;

public interface IBanco {
    void crearEmpleado(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario);
    void actualizarEmpleado(String direccion, String telefono, String correo, double salario, HashSet<Cliente> clientes);
    void eliminarEmpleado(String codigo);
    Empleado obtenerEmpleado(String codigo);
    void crearCliente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento);
    void actualizarCliente(String direccion, String telefono, String correo, Empleado empleadoAsociado);
    void eliminarCliente(String cedula);
    Cliente obtenerCliente(String cedula);
    void realizarTransaccion();
    boolean realizarRetiroCuenta(double valor, double numeroCuenta);
    boolean depositarDineroCuenta(double valor, double numeroCuenta);
    double consultarSaldoCuenta(double numeroCuenta);
}
