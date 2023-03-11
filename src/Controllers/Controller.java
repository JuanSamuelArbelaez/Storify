package Controllers;
import Persona.*;
import Persona.Empleado.*;
import Banco.*;
import Cuenta.*;
import Transaccion.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;

public class Controller {
    public Banco banco;
    public Stage stage;

    public Scene scene;
    public Parent root;
    public FXMLLoader loader;

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
