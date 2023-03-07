package Transaccion;

import Cuenta.*;

public class Retiro extends Transaccion{

    public Retiro(String fecha, String hora, double valor, Cuenta cuentaAsociada) {
        super(fecha, hora, valor, cuentaAsociada);
    }
}
