package Persona;

import Persona.Empleado.Empleado;
import Cuenta.Cuenta;

import java.util.HashMap;

public class Cliente extends Persona{
    private Empleado empleadoAsociado;
    private HashMap<Cuenta,String> listaCuentasCliente;
    public Cliente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, Empleado empleadoAsociado, HashMap<Cuenta,String> listaCuentasCliente) {
        super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento);
        this.empleadoAsociado = empleadoAsociado;
        this.listaCuentasCliente= listaCuentasCliente;
    }
    public Empleado getEmpleadoAsociado() {return empleadoAsociado;}
    public void setEmpleadoAsociado(Empleado empleadoAsociado) {this.empleadoAsociado = empleadoAsociado;}
    public HashMap<Cuenta, String> getListaCuentasCliente() {return listaCuentasCliente;}
    public void setListaCuentasCliente(HashMap<Cuenta, String> listaCuentasCliente) {this.listaCuentasCliente = listaCuentasCliente;}
    public void addCuenta(Cuenta cuenta) {

    }
}
