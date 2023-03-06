package Transaccion;

import Persona.Cliente;

public class Deposito extends Transaccion{

    public Deposito(String fecha, String hora, double valor, Cliente clienteAsociado) {
        super(fecha, hora, valor, clienteAsociado);
    }
}
