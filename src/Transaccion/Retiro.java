package Transaccion;

import Persona.Cliente;

public class Retiro extends Transaccion{

    public Retiro(String fecha, String hora, double valor, Cliente clienteAsociado) {
        super(fecha, hora, valor, clienteAsociado);
    }
}
