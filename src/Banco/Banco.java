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
}
