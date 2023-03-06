import Cuenta.Cuenta;
import Persona.*;
import Persona.Empleado.*;
import Transaccion.Transaccion;


import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Banco {
    private HashSet<Cliente> listaClientes = new HashSet<>();
    private TreeSet<Empleado> listaEmpleados = new TreeSet<>();
    private HashMap<Cuenta, Integer> listaCuentas = new HashMap<>();
    private HashMap<Transaccion, String> listaTransaccionesAsociadas = new HashMap<>();
}
