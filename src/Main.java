import Controllers.Home_Controller;
import Banco.*;
import Persona.*;
import Cuentas.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;

public class Main extends Application {
    private Banco banco;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Controllers/Home_View.fxml"));
        Parent root = loader.load();

        banco = new Banco();
        //banco = FileManager.readFile();

        Home_Controller homeController = loader.getController();
        homeController.setBanco();
        stage.setScene(new Scene(root));
        stage.setTitle("Home");
        stage.show();
    }
}