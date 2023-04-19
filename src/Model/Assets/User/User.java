package Model.Assets.User;

import Model.Assets.Song.Song;
import Model.Structures.CircularList.CircularList;

public class User implements User_Interface{
    private String username = "";
    private String password = "";
    private String email = "";
    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
    private CircularList<Song> mySongs = new CircularList<Song>();
    @Override
    public int compareTo(User o) {
        return 0;
    }
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public CircularList<Song> getMySongs() {return mySongs;}
    public void setMySongs(CircularList<Song> mySongs) {this.mySongs = mySongs;
    }
}
