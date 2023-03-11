package Cuentas;

import Persona.Cliente;
import Transaccion.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Objects;

public class Cuenta implements Comparable<Cuenta>, ICuenta, Serializable {
    private final String numeroCuenta;
    private double saldo;
    private String tipo= this.getClass().getSimpleName();
    private HashMap<String, Transaccion> listaTransacciones;
    private Cliente clienteAsociado;
    public Cuenta(String numeroCuenta, double saldo, HashMap<String, Transaccion> listaTransacciones, Cliente clienteAsociado) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.listaTransacciones = Objects.requireNonNullElseGet(listaTransacciones, () -> new HashMap<String, Transaccion>());
        this.clienteAsociado = clienteAsociado;
    }
    public String getNumeroCuenta() {return numeroCuenta;}
    public double getSaldo() {return saldo;}
    public HashMap<String, Transaccion> getListaTransacciones() {return listaTransacciones;}
    public Cliente getClienteAsociado() {return clienteAsociado;}
    public void crearTransaccion(Transaccion t) throws Exception {
        if(t==null) throw new IllegalArgumentException("La transaccion no puede ser nula");
        if(containsTransaccion(t)) throw new IllegalArgumentException("");
        this.clienteAsociado.crearTransaccion(t);
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
        try {
            crearTransaccion(new Retiro(getDate(), valor, this));
            return true;
        } catch (Exception e){
            return false;
        }
    }
    @Override
    public boolean depositarDinero(double valor) throws IllegalArgumentException{
        String[] date = getDate().split(" ");
        try {
            crearTransaccion(new Deposito(getDate(), valor, this));
            return true;
        } catch (Exception e){
            return false;
        }
    }
    @Override
    public double consultarSaldo() {
        return this.getSaldo();
    }
    public void setSaldo(double valor) {this.saldo=valor;}
    private static String getDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    public String getTipo() {
        return tipo;
    }}
