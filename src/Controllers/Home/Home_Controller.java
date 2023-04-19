package Controllers.Home;

import Controllers.Controller;
import Model.Assets.Song.Song;
import Model.Assets.User.User;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class Home_Controller extends Controller {

    @FXML private TextField searchBar;
    @FXML private ImageView songThumbnail;
    @FXML private Label songTitle;
    @FXML private Label songArtist;
    @FXML private Label songAlbum;
    @FXML private Label songYear;
    @FXML private Label songGenre;
    @FXML private Label songDuration;
    @FXML private ImageView prevIcon;
    @FXML private ImageView playIcon;
    @FXML private ImageView nextIcon;
    @FXML private ImageView homeIcon;
    @FXML private ImageView artistIcon;
    @FXML private ImageView favIcon;
    @FXML private HBox homeBox;
    @FXML private HBox artistBox;
    @FXML private HBox favBox;
    private Song song = null;
    private User user = null;
    private int count=0;
    @FXML
    private ImageView pn1;
    @FXML
    private ImageView pn2;
    @FXML
    private ImageView pn3;

    @FXML public void previous(Event event) {
        try {
            if(user.getMySongs().validIndex(count)) song = user.getMySongs().get(count);
            if(count > user.getMySongs().size()) count = 0;
            else count++;
        } catch (IndexOutOfBoundsException e) {
        }
    }
    @FXML public void togglePlayer(Event event) {
    }
    @FXML public void next(Event event) {
    }
    @FXML public void select(Event event) {
        HBox box = (HBox) event.getSource();
        pn1.setVisible(true);
        pn2.setVisible(true);
        pn3.setVisible(true);
        if(!box.getId().contains("fav")) {
            this.favBox.setStyle("-fx-background-color: #FFFFFF; -fx-border-width: 0 0 0 0;");
            pn3.setVisible(false);
        }
        if(!box.getId().contains("artist")){
            this.artistBox.setStyle("-fx-background-color: #FFFFFF; -fx-border-width: 0 0 0 0;");
            pn2.setVisible(false);
        }
        if(!box.getId().contains("home")){
            this.homeBox.setStyle("-fx-background-color: #FFFFFF; -fx-border-width: 0 0 0 0;");
            pn1.setVisible(false);
        }
        box.setStyle("-fx-background-color: #E4E4E4; -fx-border-width: 0 0 3 0; -fx-border-color:  #720d5d;");
    }
    @FXML public void search(MouseEvent mouseEvent) {

    }
    public void setData(User user) {
        super.setData();
        this.user = user;
        if(user.getMySongs().size() > 0) {
            this.song = user.getMySongs().get(0);
        }
    }
}
