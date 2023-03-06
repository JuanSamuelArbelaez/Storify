package Cuenta;

import Transaccion.Transaccion;

import java.io.Serializable;
import java.util.HashMap;

public class Cuenta implements Comparable<Cuenta> {
    private String numeroCuenta;
    private double saldo;
    private HashMap<Transaccion, String> listaTransacciones;
    public Cuenta(String numeroCuenta, double saldo, HashMap<Transaccion, String> listaTransacciones) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.listaTransacciones = listaTransacciones;
    }
    public String getNumeroCuenta() {return numeroCuenta;}
    public void setNumeroCuenta(String numeroCuenta) {this.numeroCuenta = numeroCuenta;}
    public double getSaldo() {return saldo;}
    public void setSaldo(double saldo) {this.saldo = saldo;}
    public HashMap<Transaccion, String> getListaTransacciones() {return listaTransacciones;}
    public void setListaTransacciones(HashMap<Transaccion, String> listaTransacciones) {this.listaTransacciones = listaTransacciones;}

    @Override
    public int compareTo(Cuenta o) {
        return getNumeroCuenta().compareTo(o.getNumeroCuenta());
    }
}
