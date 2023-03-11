package Banco;

import Cuentas.Cuenta;
import Persona.Cliente;
import Persona.Empleado.Empleado;

import java.util.HashSet;

public interface IBanco {
    void crearEmpleado(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario) throws Exception;
    void actualizarEmpleado(String codigo, String cedula, String direccion, String telefono, String correo, Double salario, HashSet<Cliente> clientes);
    void eliminarEmpleado(String codigo, String cedula);
    Empleado obtenerEmpleado(String codigo, String cedula) throws Exception;
    void crearCliente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento) throws Exception;
    void actualizarCliente(String cedula, String direccion, String telefono, String correo, Empleado empleadoAsociado);
    void eliminarCliente(String cedula);
    Cliente obtenerCliente(String cedula) throws Exception;
    void realizarTransaccion(String type, double valor, String numeroCuenta) throws Exception;
    boolean realizarRetiroCuenta(double valor, String numeroCuenta) throws Exception;
    boolean depositarDineroCuenta(double valor, String numeroCuenta) throws Exception;
    double consultarSaldoCuenta(String numeroCuenta);
    Cuenta getCuenta(String numeroCuenta) throws Exception;
    Cliente getCliente(String cedula) throws Exception;
    Empleado getEmpleado(String cedula) throws Exception;
}
