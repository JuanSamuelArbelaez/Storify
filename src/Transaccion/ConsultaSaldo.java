package Transaccion;

import Persona.Cliente;

public class ConsultaSaldo extends Transaccion{

    public ConsultaSaldo(String fecha, String hora, double valor, Cliente clienteAsociado) {
        super(fecha, hora, valor, clienteAsociado);
    }
}
