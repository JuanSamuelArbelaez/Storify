package Transaccion;

import Cuentas.Cuenta;

public class Deposito extends Transaccion{
    public Deposito(String fecha, double valor, Cuenta cuentaAsociada) {
        super(fecha, valor, cuentaAsociada);
    }
}
