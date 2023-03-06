package Cuenta;

import Transaccion.Transaccion;

import java.util.HashMap;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(String numeroCuenta, double saldo, HashMap<Transaccion, String> listaTransacciones) {
        super(numeroCuenta, saldo, listaTransacciones);
    }
}
