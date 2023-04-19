import Controllers.Home.Home_Controller;
import Model.Assets.Artist.Artist;
import Model.Assets.Song.Song;
import Model.Assets.User.User;
import Storify.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;

public class Main extends Application {
    private Storify storify;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Controllers/Home/Home_View.fxml"));
        Parent root = loader.load();
        storify = new Storify();
        //banco = FileManager.readFile();


        Home_Controller homeController = loader.getController();
        homeController.setData(storify.getUsers().get("lola"));
        stage.setScene(new Scene(root));
        stage.setTitle("Home");
        stage.show();
    }
}