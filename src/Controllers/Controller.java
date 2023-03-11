package Controllers;
import Banco.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;

public class Controller {
    public Banco banco;
    public Stage stage;

    public Scene scene;
    public Parent root;
    public FXMLLoader loader;

    public void setBanco() {
        try {
            this.banco = FileManager.readFile();
        } catch (Exception e) {
        }
    }
}
