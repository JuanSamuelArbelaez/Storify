package Cuenta;

import Persona.Cliente;
import Transaccion.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Cuenta implements Comparable<Cuenta>, ICuenta {
    private final Integer numeroCuenta;
    private double saldo;
    private HashMap<String, Transaccion> listaTransacciones;
    private Cliente clienteAsociado;
    public Cuenta(int numeroCuenta, double saldo, HashMap<String, Transaccion> listaTransacciones, Cliente clienteAsociado) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.listaTransacciones = listaTransacciones;
        this.clienteAsociado = clienteAsociado;
    }
    public Integer getNumeroCuenta() {return numeroCuenta;}
    public double getSaldo() {return saldo;}
    public HashMap<String, Transaccion> getListaTransacciones() {return listaTransacciones;}
    public Cliente getClienteAsociado() {return clienteAsociado;}
    public void crearTransaccion(Transaccion t){
        if(t==null) throw new IllegalArgumentException("La transaccion no puede ser nula");
        if(containsTransaccion(t)) throw new IllegalArgumentException("");
        this.listaTransacciones.put(t.getFecha(), t);
    }
    public boolean containsTransaccion(Transaccion t){
        return listaTransacciones.containsKey(t.getFecha());
    }
    @Override
    public int compareTo(Cuenta o) {
        return getNumeroCuenta().compareTo(o.getNumeroCuenta());
    }
    @Override
    public boolean retirarDinero(double valor) throws IllegalArgumentException{
        if(this.saldo-valor<0) throw new IllegalArgumentException("Fondos insuficientes");

        String[] date = getDate().split(" ");
        try {
            crearTransaccion(new Retiro(date[0], date[1], valor, this));
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }
    @Override
    public boolean depositarDinero(double valor) throws IllegalArgumentException{
        String[] date = getDate().split(" ");
        try {
            crearTransaccion(new Retiro(date[0], date[1], valor, this));
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }
    @Override
    public double consultarSaldo() {
        return this.getSaldo();
    }
    private static String getDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
