import Cuenta.Cuenta;
import Persona.*;
import Persona.Empleado.*;


import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Banco {
    HashSet<Cliente> listaClientes = new HashSet<>();
    TreeSet<Empleado> listaEmpleados = new TreeSet<>();
    HashMap<Cuenta, Integer> listaCuentas = new HashMap<>();
}
