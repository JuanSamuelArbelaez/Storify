package Cuenta;

public interface ICuenta {
    boolean retirarDinero(double valor) throws IllegalArgumentException;

    boolean depositarDinero(double valor) throws IllegalArgumentException;

    double consultarSaldo();
}
