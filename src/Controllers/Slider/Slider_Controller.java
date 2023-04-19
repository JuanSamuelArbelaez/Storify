package Controllers.Slider;

import Controllers.Controller;
import Controllers.Thumbnail.Thumbnail_Controller;
import Model.Assets.Song.Song;
import Model.Assets.User.User;
import Model.Structures.CircularList.CircularList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Slider_Controller extends Controller implements Initializable {
    @FXML private Label Title;
    @FXML private HBox box;
    private User user;
    private CircularList<Song> songList;
    public void setData(User user) {
        setData();
        this.user = user;
        this.songList = user.getMySongs();
    }

    @Override public void initialize(URL location, ResourceBundle resources) {
        try {
            for (Song song : songList) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Thumbnail_View.fxml"));

                HBox box = fxmlLoader.load();
                Thumbnail_Controller thumbController = fxmlLoader.getController();
                thumbController.setData(user, song);

                box.getChildren().add(box);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
