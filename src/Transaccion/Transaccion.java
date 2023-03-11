package Transaccion;

import Cuentas.*;

import java.io.Serializable;


public class Transaccion implements Comparable<Transaccion>, Serializable {
    private String fecha;
    private double valor;
    private Cuenta cuentaAsociada;
    public Transaccion(String fecha, double valor, Cuenta cuentaAsociada) {
        this.fecha = fecha;
        this.valor = valor;
        this.cuentaAsociada = cuentaAsociada;
    }
    public String getFecha() {return fecha;}
    public void setFecha(String fecha) {this.fecha = fecha;}
    public double getValor() {return valor;}
    public void setValor(double valor) {this.valor = valor;}
    public Cuenta getCuentaAsociada() {return cuentaAsociada;}
    public void setCuentaAsociada(Cuenta cuentaAsociada) {this.cuentaAsociada = cuentaAsociada;}
    @Override
    public int compareTo(Transaccion o) {
        return getFecha().compareTo(o.getFecha());
    }

    public String getTipo() {
        return this.getClass().getSimpleName();
    }
}
