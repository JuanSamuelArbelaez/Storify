package Model.Assets.Artist;

import Model.Assets.Song.Song;
import Model.Structures.DoubleLinkedList.DoubleLinkedList;

public class Artist implements Artist_Interface{
    private String code = "";
    private String name = "";
    private String country = "";
    private boolean group = false;
    private DoubleLinkedList<Song> songs = new DoubleLinkedList<>();
    public Artist(String code, String name, String country, boolean isGroup){
        this.code = code;
        this.name = name;
        this.country = country;
        this.group = isGroup;
    }
    @Override public int compareTo(Artist o) {return this.name.compareTo(o.getName());}
    @Override public void addSong(Song song){this.songs.add(song);}
    @Override public void addSong(String name, String iD, String album, String year, String duration, String genre, String url){
        addSong(new Song(name,iD,album,this,year,duration,genre,url));
    }
    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}
    public boolean isGroup() {return group;}
    public void setGroup(boolean group) {this.group = group;}
    public DoubleLinkedList<Song> getSongs() {
        return songs;
    }

    public void setSongs(DoubleLinkedList<Song> songs) {
        this.songs = songs;
    }
}
