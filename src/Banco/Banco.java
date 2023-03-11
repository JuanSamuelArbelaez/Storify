package Banco;

import Cuentas.Cuenta;
import Persona.*;
import Persona.Empleado.*;
import Transaccion.Transaccion;


import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Banco implements IBanco, Serializable {
    private HashSet<Cliente> listaClientes = new HashSet<>();
    private TreeSet<Empleado> listaEmpleados = new TreeSet<>();
    private HashMap<String,Cuenta> listaCuentas = new HashMap<>();
    private HashMap<String, Transaccion> listaTransaccionesAsociadas = new HashMap<>();
    public HashSet<Cliente> getListaClientes() {
        return listaClientes;
    }

    public TreeSet<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public HashMap<String, Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public HashMap<String, Transaccion> getListaTransaccionesAsociadas() {
        return listaTransaccionesAsociadas;
    }

    @Override
    public void crearEmpleado(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario) throws Exception {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getNombre().equals(nombre) && empleado.getCodigo().equals(codigo) && empleado.getCedula().equals(cedula)){
                throw new Exception("Este empleado ya existe");
            }
        }
        listaEmpleados.add(new Empleado(nombre, apellido, cedula, direccion, telefono,correo, fechaNacimiento, codigo, salario, new HashSet<Cliente>()));
    }

    @Override
    public void actualizarEmpleado(String codigo, String cedula, String direccion, String telefono, String correo, Double salario, HashSet<Cliente> clientes) {
        try{
            Empleado empleado = obtenerEmpleado(codigo, cedula);
            if(direccion!=null)empleado.setDireccion(direccion);
            if(telefono!=null)empleado.setTelefono(telefono);
            if(correo!=null)empleado.setCorreo(correo);
            if(salario==null)empleado.setSalario(salario);
            if(clientes!=null)empleado.setClientes(clientes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminarEmpleado(String codigo, String cedula) {
        try{
            Empleado empleado = obtenerEmpleado(codigo, cedula);
            listaEmpleados.remove(empleado);
            for(Cliente cliente: listaClientes){
                if(cliente.getEmpleadoAsociado().equals(empleado))cliente.setEmpleadoAsociado(null);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Empleado obtenerEmpleado(String codigo, String cedula) throws Exception {
        for (Empleado empleado : listaEmpleados) {
            if(empleado.getCodigo().equals(codigo)&&empleado.getCedula().equals(cedula)) return empleado;
        }
        throw new Exception("Empleado no encontrado");
    }
    @Override
    public void crearCliente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento) throws Exception {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equals(nombre) && cliente.getCedula().equals(cedula)){
                throw new Exception("Este cliente ya existe");
            }
        }
        listaClientes.add(new Cliente(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento, null, null, null));
    }

    @Override
    public void actualizarCliente(String cedula, String direccion, String telefono, String correo, Empleado empleadoAsociado) {
        try{
            Cliente cliente = obtenerCliente(cedula);
            if(direccion!=null)cliente.setDireccion(direccion);
            if(telefono!=null)cliente.setTelefono(telefono);
            if(correo!=null)cliente.setCorreo(correo);
            if(empleadoAsociado!=null)cliente.setEmpleadoAsociado(empleadoAsociado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminarCliente(String cedula) {
        try{
            Cliente empleado = obtenerCliente(cedula);
            listaClientes.remove(empleado);
            for(Empleado cliente: listaEmpleados){
                try {
                    cliente.removeClient(empleado);
                } catch (Exception e) {}
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cliente obtenerCliente(String cedula) throws Exception{
        for (Cliente cliente : listaClientes) {
            if(cliente.getCedula().equals(cedula)) return cliente;
        }
        throw new Exception("Cliente no encontrado");
    }

    @Override
    public void realizarTransaccion(String type, double valor, int numeroCuenta) throws IllegalArgumentException{
        switch(type){
            case "retiro":
                realizarRetiroCuenta(valor, numeroCuenta);
                break;
            case "deposito":
                depositarDineroCuenta(valor, numeroCuenta);
                break;
            case "consulta":
                consultarSaldoCuenta(numeroCuenta);
                break;
            default:
                throw new IllegalArgumentException("Operacion no valida");
        }
    }

    @Override
    public boolean realizarRetiroCuenta(double valor, int numeroCuenta) {
        try{
            return obtenerCuenta(numeroCuenta).retirarDinero(valor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean depositarDineroCuenta(double valor, int numeroCuenta) {
        try{
            return obtenerCuenta(numeroCuenta).depositarDinero(valor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double consultarSaldoCuenta(int numeroCuenta) {
        try{
            return obtenerCuenta(numeroCuenta).getSaldo();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cuenta obtenerCuenta(int numeroCuenta) throws Exception{
        if(!listaCuentas.containsKey(numeroCuenta))throw new Exception("Cuenta no encontrada");
        return listaCuentas.get(numeroCuenta);
    }
}
