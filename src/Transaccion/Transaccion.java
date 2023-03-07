package Transaccion;

import Persona.Cliente;
import Cuenta.*;


public class Transaccion implements Comparable<Transaccion> {
    private String fecha;
    private String hora;
    private double valor;
    private Cuenta cuentaAsociada;
    public Transaccion(String fecha, String hora, double valor, Cuenta cuentaAsociada) {
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
        this.cuentaAsociada = cuentaAsociada;
    }
    public String getFecha() {return fecha;}
    public void setFecha(String fecha) {this.fecha = fecha;}
    public String getHora() {return hora;}
    public void setHora(String hora) {this.hora = hora;}
    public double getValor() {return valor;}
    public void setValor(double valor) {this.valor = valor;}
    public Cuenta getCuentaAsociada() {return cuentaAsociada;}
    public void setCuentaAsociada(Cuenta cuentaAsociada) {this.cuentaAsociada = cuentaAsociada;}
    @Override
    public int compareTo(Transaccion o) {
        return getFecha().compareTo(o.getFecha());
    }
}
