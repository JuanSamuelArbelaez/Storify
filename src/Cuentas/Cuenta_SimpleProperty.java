package Cuentas;

import Persona.Cliente;
import Transaccion.Transaccion;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.HashMap;

public class Cuenta_SimpleProperty {
    public Cuenta_SimpleProperty(String numeroCuenta, double saldo, String tipo){
        setNumeroCuenta(numeroCuenta);
        setTipo(tipo);
        setSaldo(saldo);
    }
    private SimpleStringProperty numeroCuenta = new SimpleStringProperty("");
    private SimpleDoubleProperty saldo = new SimpleDoubleProperty(0);
    private SimpleStringProperty tipo = new SimpleStringProperty("");

    public String getNumeroCuenta() {
        return numeroCuenta.get();
    }
    public double getSaldo() {
        return saldo.get();
    }

    public String getTipo() {
        return tipo.get();
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta.set(numeroCuenta);
    }

    public void setSaldo(double saldo) {
        this.saldo.set(saldo);
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }
}
