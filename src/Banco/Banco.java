package Banco;

import Cuenta.Cuenta;
import Persona.*;
import Persona.Empleado.*;
import Transaccion.Transaccion;


import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Banco implements IBanco{
    private static HashSet<Cliente> listaClientes = new HashSet<>();
    private static TreeSet<Empleado> listaEmpleados = new TreeSet<>();
    private static HashMap<Integer,Cuenta> listaCuentas = new HashMap<>();
    private static HashMap<String, Transaccion> listaTransaccionesAsociadas = new HashMap<>();

    public static HashSet<Cliente> getListaClientes() {
        return listaClientes;
    }

    public static TreeSet<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public static HashMap<Integer, Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public static HashMap<String, Transaccion> getListaTransaccionesAsociadas() {
        return listaTransaccionesAsociadas;
    }

    @Override
    public void crearEmpleado(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario) {
        listaEmpleados.add(new Empleado(nombre, apellido, cedula, direccion, telefono,correo, fechaNacimiento, codigo, salario, new HashSet<Cliente>()));
    }

    @Override
    public void actualizarEmpleado(String direccion, String telefono, String correo, double salario, HashSet<Cliente> clientes) {

    }

    @Override
    public void eliminarEmpleado(String codigo) {

    }

    @Override
    public Empleado obtenerEmpleado(String codigo) {
        return null;
    }

    @Override
    public void actualizarCliente(String direccion, String telefono, String correo, Empleado empleadoAsociado) {

    }

    @Override
    public void eliminarCliente(String cedula) {

    }

    @Override
    public Cliente obtenerCliente(String cedula) {
        return null;
    }

    @Override
    public void realizarTransaccion() {

    }

    @Override
    public boolean realizarRetiroCuenta(double valor, double numeroCuenta) {
        return false;
    }

    @Override
    public boolean depositarDineroCuenta(double valor, double numeroCuenta) {
        return false;
    }

    @Override
    public double consultarSaldoCuenta(double numeroCuenta) {
        return 0;
    }

    @Override
    public void crearCliente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento) {
        listaClientes.add(new Cliente(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento, null, null, null));
    }
}
