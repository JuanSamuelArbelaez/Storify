package Persona;


import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.util.Comparator;

public class Persona implements Comparable<Persona>, Serializable {
    private String password;
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellido;
    private SimpleStringProperty cedula;
    private SimpleStringProperty direccion;
    private SimpleStringProperty telefono;
    private SimpleStringProperty correo;
    private SimpleStringProperty fechaNacimiento;
    public Persona(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.cedula = new SimpleStringProperty(cedula);
        this.direccion = new SimpleStringProperty(direccion);
        this.telefono = new SimpleStringProperty(telefono);
        this.correo = new SimpleStringProperty(correo);
        this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento);
    }

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getNombre() {
        return nombre.get();
    }
    public void setNombre(String nombre) {this.nombre.set(nombre);}
    public String getApellido() {
        return apellido.get();
    }
    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }
    public String getCedula() {return cedula.get();}
    public void setCedula(String cedula) {this.cedula.set(cedula);}
    public String getDireccion() {return direccion.get();}
    public void setDireccion(String direccion) {this.direccion.set(direccion);}
    public String getTelefono() {return telefono.get();}
    public void setTelefono(String telefono) {this.telefono.set(telefono);}
    public String getCorreo() {return correo.get();}
    public void setCorreo(String correo) {this.correo.set(correo);}
    public String getFechaNacimiento() {return fechaNacimiento.get();}
    public void setFechaNacimiento(String fechaNacimiento) {this.fechaNacimiento.set(fechaNacimiento);}
    @Override
    public int compareTo(Persona o) {
        return getNombre().compareTo(o.getNombre());
    }
    public static Comparator getComparator_Nombre(){
        return new Comparator<Persona>(){
            @Override
            public int compare(Persona o1, Persona o2){
                return o1.getNombre().compareTo(o2.getNombre());
            }
        };
    }
    public static Comparator getComparator_Apellido(){
        return new Comparator<Persona>(){
            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getApellido().compareTo(o2.getApellido());
            }
        };
    }
    public static Comparator getComparator_Cedula(){
        return new Comparator<Persona>(){
            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getCedula().compareTo(o2.getCedula());
            }
        };
    }
    public static Comparator getComparator_Direccion(){
        return new Comparator<Persona>(){
            @Override
            public int compare(Persona o1, Persona o2){
                return o1.getDireccion().compareTo(o2.getDireccion());
            }
        };
    }
    public static Comparator getComparator_Telefono(){
        return new Comparator<Persona>(){
            @Override
            public int compare(Persona o1, Persona o2){
                return o1.getTelefono().compareTo(o2.getTelefono());
            }
        };
    }
    public static Comparator getComparator_Correo(){
        return new Comparator<Persona>(){
            @Override
            public int compare(Persona o1, Persona o2){
                return o1.getCorreo().compareTo(o2.getCorreo());
            }
        };
    }
    public static Comparator getComparator_FechaNacimiento(){
        return new Comparator<Persona>(){
            @Override
            public int compare(Persona o1, Persona o2){
                return o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento());
            }
        };
    }
}
