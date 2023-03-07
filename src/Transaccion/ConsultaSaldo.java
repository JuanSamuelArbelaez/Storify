package Transaccion;


import Cuenta.Cuenta;

public class ConsultaSaldo extends Transaccion{
    public ConsultaSaldo(String fecha, String hora, double valor, Cuenta cuentaAsociada) {
        super(fecha, hora, valor, cuentaAsociada);
    }
}
