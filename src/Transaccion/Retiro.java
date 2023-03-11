package Transaccion;

import Cuentas.*;

public class Retiro extends Transaccion{

    public Retiro(String fecha, double valor, Cuenta cuentaAsociada) {
        super(fecha, valor, cuentaAsociada);
    }
}
