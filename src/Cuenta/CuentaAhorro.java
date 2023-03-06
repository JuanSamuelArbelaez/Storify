package Cuenta;

import Transaccion.Transaccion;

import java.util.HashMap;

public class CuentaAhorro extends Cuenta{
    public CuentaAhorro(String numeroCuenta, double saldo, HashMap<Transaccion, String> listaTransacciones) {
        super(numeroCuenta, saldo, listaTransacciones);
    }
}
