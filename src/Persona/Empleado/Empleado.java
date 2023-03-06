package Persona.Empleado;

import Persona.Cliente;

import java.util.HashSet;

public class Empleado extends Persona.Persona{
    private String codigo;
    private Double salario;
    private HashSet<Cliente> clientes;
    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}
    public Double getSalario() {return salario;}
    public void setSalario(Double salario) {this.salario = salario;}
    public HashSet<Cliente> getClientes() {return clientes;}
    public void setClientes(HashSet<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Empleado(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario, HashSet<Cliente> clientes) {
        super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento);
        this.codigo=codigo;
        this.salario=salario;
        this.clientes=clientes;
    }
    public void addClient(Cliente cliente) throws Exception {
        if(containsCliente(cliente)) throw new Exception("El cliente ya se encuentra en la lista");
        this.clientes.add(cliente);
    }
    public void removeClient(Cliente cliente) throws Exception {
        if(!containsCliente(cliente)) throw new Exception("El cliente no se encuentra en la lista");
        this.clientes.remove(cliente);
    }
    public boolean containsCliente(Cliente cliente){
        return this.clientes.contains(cliente);
    }
}
