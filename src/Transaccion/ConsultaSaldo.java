package Transaccion;


import Cuentas.Cuenta;

public class ConsultaSaldo extends Transaccion{
    public ConsultaSaldo(String fecha, double valor, Cuenta cuentaAsociada) {
        super(fecha, valor, cuentaAsociada);
    }
}
