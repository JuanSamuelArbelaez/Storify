package Storify;

import Model.Assets.Admin.Admin;
import Model.Assets.Artist.Artist;
import Model.Assets.Song.Song;
import Model.Assets.User.User;
import Model.Structures.BinaryTree.BinaryTree;
import Model.Structures.HashMap.HashMap;
import Model.Structures.CircularList.CircularList;
import Model.Tools.FileManager;

import java.io.Serializable;
public class Storify implements Serializable {
    private final BinaryTree<Artist> artists = new BinaryTree<Artist>();
    private final HashMap<String, User> users = new HashMap<String, User>();
    private final Admin admin = new Admin("RobinsMaster", "0paraTodos", "robinson@storify.com");
    public BinaryTree<Artist> getArtists() {return artists;}
    public HashMap<String, User> getUsers() {return users;}
    public Admin getAdmin() {return admin;}
    public Storify(){
        try {
            User user = new User("lola", "pswd", "lol@mail.com");

            Artist artist1 = new Artist("1082", "marti", "usa", false);
            artist1.addSong(new Song("hula", "0909", "carter", artist1, "2020", "300", "pop", "https://www.youtube.com/watch?v=ceXHH9sYIkk"));
            artist1.addSong(new Song("party", "ony1b2", "carter", artist1, "2020", "300", "pop", "https://www.youtube.com/watch?v=Qz0KTGYJtUk"));

            Artist artist2 = new Artist("9291", "Ariana", "usa", false);
            artist2.addSong(new Song("cancion1", "bbbb", "a1", artist2, "2000", "340", "pop", "https://www.youtube.com/watch?v=FucPPCPDd2Y"));
            artist2.addSong(new Song("cancion2", "laos", "a1", artist2, "2000", "350", "pop", "https://www.youtube.com/watch?v=6jSGqVtudgI"));

            user.getMySongs().add(artist1.getSongs().get(0));
            user.getMySongs().addAll(artist2.getSongs());

            this.artists.add(artist1);
            this.artists.add(artist2);

            this.users.put(user.getUsername(), user);

            FileManager.writeFile(this);
        } catch (Exception ignored) {
        }
    }
}
