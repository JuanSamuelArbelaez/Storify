package Cuentas;

public interface ICuenta {
    boolean retirarDinero(double valor);

    boolean depositarDinero(double valor);

    double consultarSaldo();
}
