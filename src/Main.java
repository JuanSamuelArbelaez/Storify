import Controllers.Home_Controller;
import Banco.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;

import java.io.*;

public class Main extends Application {
    private Banco banco;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Controllers/Home_View.fxml"));
        Parent root = loader.load();

        Home_Controller homeController = loader.getController();
        banco = readFile();
        homeController.setBanco(banco);
        System.out.println(banco.obtenerCliente("1234567890").getNombre());

        stage.setScene(new Scene(root));
        stage.setTitle("Home");
        stage.show();
    }

    public static Banco readFile() throws Exception {
        FileInputStream fis = new FileInputStream("Banco.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        return (Banco) ois.readObject();
    }

    public static void writeFile(Banco banco) throws Exception {
        FileOutputStream fos = new FileOutputStream("Banco.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
            // write object to file
        oos.writeObject(banco);
        oos.close();
    }
}