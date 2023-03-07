package Transaccion;

import Cuenta.Cuenta;

public class Deposito extends Transaccion{
    public Deposito(String fecha, String hora, double valor, Cuenta cuentaAsociada) {
        super(fecha, hora, valor, cuentaAsociada);
    }
}
