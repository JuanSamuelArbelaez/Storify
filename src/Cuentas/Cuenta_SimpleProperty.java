package Cuentas;

import Persona.Cliente;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cuenta_SimpleProperty {
    public Cuenta_SimpleProperty(Cuenta cuenta){
        setNumeroCuenta(cuenta.getNumeroCuenta());
        setTipo(cuenta.getTipo());
        setSaldo(cuenta.getSaldo());
        setNombre(cuenta.getClienteAsociado().getNombre()+" "+cuenta.getClienteAsociado().getApellido());
        setId(cuenta.getClienteAsociado().getCedula());
    }
    private SimpleStringProperty numeroCuenta = new SimpleStringProperty("");
    private SimpleDoubleProperty saldo = new SimpleDoubleProperty(0);
    private SimpleStringProperty tipo = new SimpleStringProperty("");
    private SimpleStringProperty nombre = new SimpleStringProperty("");
    private SimpleStringProperty id = new SimpleStringProperty("");

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

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }
}
