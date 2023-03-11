package Persona;

import Persona.Empleado.Empleado;
import Cuenta.Cuenta;
import Transaccion.Transaccion;
import Persona.Persona;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Objects;

public class Cliente extends Persona{
    private Empleado empleadoAsociado;
    private HashMap<Integer, Cuenta> listaCuentasCliente;
    private HashMap<String, Transaccion> listaTransacciones;
    public Cliente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, Empleado empleadoAsociado, HashMap<Integer, Cuenta> listaCuentasCliente, HashMap<String, Transaccion> listaTransacciones) {
        super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento);
        this.empleadoAsociado = empleadoAsociado;
        this.listaCuentasCliente = Objects.requireNonNullElseGet(listaCuentasCliente, () -> new HashMap<Integer, Cuenta>());
        this.listaTransacciones = Objects.requireNonNullElseGet(listaTransacciones, () -> new HashMap<String, Transaccion>());
    }
    public Empleado getEmpleadoAsociado() {return empleadoAsociado;}
    public void setEmpleadoAsociado(Empleado empleadoAsociado) {this.empleadoAsociado = empleadoAsociado;}
    public HashMap<Integer, Cuenta> getListaCuentasCliente() {return listaCuentasCliente;}
    public void setListaCuentasCliente(HashMap<Integer, Cuenta> listaCuentasCliente) {this.listaCuentasCliente = listaCuentasCliente;}
    public void addCuenta(Cuenta cuenta) throws IllegalArgumentException {
        if (cuenta==null) throw new IllegalArgumentException("Cuenta no puede ser nula");
        if(containsCuenta(cuenta)) throw new IllegalArgumentException("La cuenta ya se encuentra en la lista");
        this.listaCuentasCliente.put(cuenta.getNumeroCuenta(), cuenta);
    }
    public void removeCuenta(Cuenta cuenta) throws IllegalArgumentException {
        if(cuenta==null) throw new IllegalArgumentException("La cuenta no puede ser nula");
        if(!containsCuenta(cuenta)) throw new IllegalArgumentException("La cuenta no se encuentra en la lista");
        this.listaCuentasCliente.remove(cuenta.getNumeroCuenta());
    }
    public boolean containsCuenta(Cuenta cuenta) {
        return this.listaCuentasCliente.containsKey(cuenta.getNumeroCuenta());
    }
}
