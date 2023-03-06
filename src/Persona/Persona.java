package Persona;

import java.io.Serializable;
import java.util.Comparator;

public class Persona implements Comparable<Persona> {
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String telefono;
    private String correo;
    private String fechaNacimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int compareTo(Persona o) {
        return getNombre().compareTo(o.getNombre());
    }

    public Comparator getComparator_Apellido(){
        return new Comparator<Persona>(){

            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getApellido().compareTo(o2.getApellido());
            }
        };
    }
    public Comparator getComparator_Cedula(){
        return new Comparator<Persona>(){

            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getCedula().compareTo(o2.getCedula());
            }
        };
    }
}