package Persona;

import Persona.Empleado.Empleado;
import Cuentas.Cuenta;
import Transaccion.Transaccion;
import java.util.HashMap;
import java.util.Objects;

public class Cliente extends Persona{
    private Empleado empleadoAsociado;
    private HashMap<String, Cuenta> listaCuentasCliente;
    private HashMap<String, Transaccion> listaTransacciones;
    public Cliente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, Empleado empleadoAsociado, HashMap<String, Cuenta> listaCuentasCliente, HashMap<String, Transaccion> listaTransacciones) {
        super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento);
        this.empleadoAsociado = empleadoAsociado;
        this.listaCuentasCliente = Objects.requireNonNullElseGet(listaCuentasCliente, () -> new HashMap<String, Cuenta>());
        this.listaTransacciones = Objects.requireNonNullElseGet(listaTransacciones, () -> new HashMap<String, Transaccion>());
    }
    public Empleado getEmpleadoAsociado() {return empleadoAsociado;}
    public void setEmpleadoAsociado(Empleado empleadoAsociado) {this.empleadoAsociado = empleadoAsociado;}
    public HashMap<String, Cuenta> getListaCuentasCliente() {return listaCuentasCliente;}
    public void setListaCuentasCliente(HashMap<String, Cuenta> listaCuentasCliente) {this.listaCuentasCliente = listaCuentasCliente;}

    public HashMap<String, Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(HashMap<String, Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

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
    public void crearTransaccion(Transaccion tx) throws Exception{
            if(tx==null)throw new Exception("");
            if(this.listaTransacciones.containsKey(tx.getFecha()))throw new Exception("");
            this.listaTransacciones.put(tx.getFecha(),tx);

    }
}
