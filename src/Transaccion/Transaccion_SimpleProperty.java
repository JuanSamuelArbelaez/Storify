package Transaccion;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Transaccion_SimpleProperty {
    private SimpleStringProperty type = new SimpleStringProperty("");
    private SimpleStringProperty date = new SimpleStringProperty("");
    private SimpleDoubleProperty amount = new SimpleDoubleProperty(0);
    public Transaccion_SimpleProperty(String fecha, String tipo, double cantidad){
        setType(tipo);
        setDate(fecha);
        setAmount(cantidad);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public double getAmount() {
        return amount.get();
    }
    public void setAmount(double amount) {
        this.amount.set(amount);
    }
}
