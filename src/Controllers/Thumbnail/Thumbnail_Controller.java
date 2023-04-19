package Controllers.Thumbnail;

import Controllers.Controller;
import Model.Assets.Song.Song;
import Model.Assets.User.User;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Thumbnail_Controller extends Controller implements Initializable {
    private Song song;
    private User user;
    @FXML private ImageView Thumbnail;
    @FXML private Label SongTitle;
    @FXML private Label Artist;
    @FXML private Label Views;
    public void setData(User user, Song song){
        setData();
        this.song = song;
        this.Thumbnail.setImage(song.getCover().getImg());
        this.SongTitle.setText(song.getName());
        this.Artist.setText(song.getArtist().getName());
        this.Views.setText(song.getViews()+"");
        user.getMySongs().add(this.song);
        this.user = user;
    }
    @FXML public void play(Event event) {
    }
    @FXML public void toggleFavorite(MouseEvent mouseEvent) {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
