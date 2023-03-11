package Cuentas;

import Persona.Cliente;
import Transaccion.Transaccion;

import java.util.HashMap;

public class CuentaAhorro extends Cuenta{

    public CuentaAhorro(String numeroCuenta, double saldo, HashMap<String, Transaccion> listaTransacciones, Cliente clienteAsociado) {
        super(numeroCuenta, saldo, listaTransacciones, clienteAsociado);
    }
}
