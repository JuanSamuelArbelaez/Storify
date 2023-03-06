package Cuenta;

import Transaccion.Transaccion;

import java.io.Serializable;
import java.util.HashMap;

public class Cuenta implements Serializable {
    private String numeroCuenta;
    private double saldo;
    HashMap<Transaccion, Integer> listaTransacciones = new HashMap<Transaccion, Integer>();
}
