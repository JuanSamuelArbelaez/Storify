package Transaccion;

import Persona.Cliente;


public class Transaccion implements Comparable<Transaccion> {
    private String fecha;
    private String hora;
    private double valor;
    private Cliente clienteAsociado;
    public Transaccion(String fecha, String hora, double valor, Cliente clienteAsociado) {
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
    }
    public String getFecha() {return fecha;}
    public void setFecha(String fecha) {this.fecha = fecha;}
    public String getHora() {return hora;}
    public void setHora(String hora) {this.hora = hora;}
    public double getValor() {return valor;}
    public void setValor(double valor) {this.valor = valor;}
    public Cliente getClienteAsociado() {return clienteAsociado;}
    public void setClienteAsociado(Cliente clienteAsociado) {this.clienteAsociado = clienteAsociado;}
    @Override
    public int compareTo(Transaccion o) {
        return getFecha().compareTo(o.getFecha());
    }
}
