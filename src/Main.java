import Controllers.Home_Controller;
import Banco.*;
import Persona.*;
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

        banco = FileManager.readFile();
        Cliente c =banco.obtenerCliente("1234567890");
        /*
        banco = new Banco();
        System.out.println(c.getNombre());
        banco.crearCliente("Marta", "Henao", "1234567890", "o","284", "au@gmail.com", "28/10/1982");
        Cliente c =banco.obtenerCliente("1234567890");
        System.out.println(c.getNombre());
        c.addCuenta(new CuentaAhorro("42310", 1000000, null, c));
        Banco.FileManager.writeFile(banco);
        */
        Home_Controller homeController = loader.getController();
        homeController.setBanco();
        stage.setScene(new Scene(root));
        stage.setTitle("Home");
        stage.show();
    }
}