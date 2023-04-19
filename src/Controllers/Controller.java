package Controllers;
import Model.Assets.User.User;
import Model.Tools.FileManager;
import Storify.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;

public class Controller {
    public Storify storify;
    public Stage stage;
    public Scene scene;
    public Parent root;
    public FXMLLoader loader;
    public Controller(){setData();}
    public void setData() {
        try {
            this.storify = FileManager.readFile();
        } catch (Exception ignored) {
        }
    }
}
