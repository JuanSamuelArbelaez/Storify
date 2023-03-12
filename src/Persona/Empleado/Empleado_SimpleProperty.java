package Persona.Empleado;

import javafx.beans.property.SimpleStringProperty;

public class Empleado_SimpleProperty {
    public Empleado_SimpleProperty(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo){
        setNombre(nombre+" "+apellido);
        setCedula(cedula);
        setDireccion(direccion);
        setTelefono(telefono);
        setCorreo(correo);
        setFechaNacimiento(fechaNacimiento);
        setCodigo(codigo);
    }
    private SimpleStringProperty nombre = new SimpleStringProperty("");
    private SimpleStringProperty cedula = new SimpleStringProperty("");
    private SimpleStringProperty fechaNacimiento = new SimpleStringProperty("");
    private SimpleStringProperty direccion = new SimpleStringProperty("");
    private SimpleStringProperty telefono = new SimpleStringProperty("");
    private SimpleStringProperty correo = new SimpleStringProperty("");
    private SimpleStringProperty codigo = new SimpleStringProperty("");

    public String getNombre() {
        return nombre.get();
    }
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    public String getCedula() {
        return cedula.get();
    }

    public void setCedula(String cedula) {
        this.cedula.set(cedula);
    }

    public String getFechaNacimiento() {
        return fechaNacimiento.get();
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento.set(fechaNacimiento);
    }

    public String getDireccion() {
        return direccion.get();
    }
    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public String getTelefono() {
        return telefono.get();
    }
    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }
    public String getCorreo() {
        return correo.get();
    }
    public void setCorreo(String correo) {
        this.correo.set(correo);
    }

    public String getCodigo() {
        return codigo.get();
    }
    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }
}
