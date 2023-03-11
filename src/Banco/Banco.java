package Banco;

import Cuentas.*;
import Persona.*;
import Persona.Empleado.*;
import Transaccion.Transaccion;


import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Banco implements IBanco, Serializable {
    public Banco(){
        try {
            crearEmpleado("Robinson", "Arias", "0987654321", "Uniquindio", "300 481 2192", "robinsonarias@uniquindo.com", "1492", "666", 7000000);
            crearCliente("Marta", "Henao", "1234567890", "o", "284", "au@gmail.com", "28/10/1982");
            getEmpleado("666").setManager(true);
            Cliente cliente = getCliente("1234567890");
            cliente.addCuenta(new CuentaAhorro("423101290", 1050000, null, cliente));
            updateAccounts();
            realizarRetiroCuenta(30000, "423101290");
            updateAccounts();
            FileManager.writeFile(this);
        } catch (Exception e) {
        }
    }
    private HashSet<Cliente> listaClientes = new HashSet<>();
    private TreeSet<Empleado> listaEmpleados = new TreeSet<>();
    private HashMap<String,Cuenta> listaCuentas = new HashMap<>(); //Key=AccountNumber
    private HashMap<String, Transaccion> listaTransaccionesAsociadas = new HashMap<>(); //Key=Date
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
    public void realizarTransaccion(String type, double valor, String numeroCuenta) throws Exception {
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
    public boolean realizarRetiroCuenta(double valor, String numeroCuenta) throws Exception {
        Cuenta cuenta = getCuenta(numeroCuenta);
        cuenta.retirarDinero(valor);
        this.updateAccounts();
        cuenta.setSaldo(cuenta.getSaldo()-valor);
        return true;
    }

    @Override
    public boolean depositarDineroCuenta(double valor, String numeroCuenta) throws Exception {
        Cuenta cuenta = getCuenta(numeroCuenta);
        cuenta.depositarDinero(valor);
        this.updateAccounts();
        cuenta.setSaldo(cuenta.getSaldo()+valor);
        return true;
    }

    @Override
    public double consultarSaldoCuenta(String numeroCuenta) {
        try{
            double amount= getCuenta(numeroCuenta).getSaldo();
            this.updateAccounts();
            return amount;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cuenta getCuenta(String numeroCuenta) throws Exception{
        if(!listaCuentas.containsKey(numeroCuenta))throw new Exception("Cuenta no encontrada");
        return listaCuentas.get(numeroCuenta);
    }
    @Override
    public Empleado getEmpleado(String codigo) throws Exception {
        Iterator iterator= this.getListaEmpleados().iterator();
        while(iterator.hasNext()){
            Empleado empleado=(Empleado)iterator.next();
            if(empleado.getCodigo().equals(codigo))return empleado;
        }
        throw new Exception("");
    }
    @Override
    public Cliente getCliente(String cedula) throws Exception {
        Iterator iterator= this.getListaClientes().iterator();
        while(iterator.hasNext()){
            Cliente cliente=(Cliente)iterator.next();
            if(cliente.getCedula().equals(cedula))return cliente;
        }
        throw new Exception("");
    }
    public void updateAccounts(){
        for(Cliente cliente: this.listaClientes){
            for(Cuenta cuenta: cliente.getListaCuentasCliente().values()){
                if(!listaCuentas.containsKey(cuenta.getNumeroCuenta()))listaCuentas.put(cuenta.getNumeroCuenta(),cuenta);
            }
            for(Transaccion tx: cliente.getListaTransacciones().values()){
                if(!this.listaTransaccionesAsociadas.containsKey(tx.getFecha()))listaTransaccionesAsociadas.put(tx.getFecha(),tx);
            }
        }
        try {
            FileManager.writeFile(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
