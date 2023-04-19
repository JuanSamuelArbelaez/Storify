package Model.Assets.Song;

import Model.Assets.Artist.Artist;

public class Song implements Song_Interface {
    private String name = "";
    private String iD = "";
    private String album = "";
    private Artist artist = null;
    private String year = "";
    private String duration = "";
    private String genre = "";
    private String url = "";
    private Thumbnail cover = null;
    private int views = 0;
    public Song(String name, String iD, String album, Artist artist, String year, String duration, String genre, String url){
        this.name=name;
        this.iD=iD;
        this.album=album;
        this.artist=artist;
        this.year=year;
        this.duration=duration;
        this.genre=genre;
        this.url=url;
        this.cover=new Thumbnail(this);
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getiD() {return iD;}
    public void setiD(String iD) {this.iD = iD;}
    public String getAlbum() {return album;}
    public void setAlbum(String album) {this.album = album;}
    public Artist getArtist() {return artist;}
    public void setArtist(Artist artist) {this.artist = artist;}
    public String getYear() {return year;}
    public void setYear(String year) {this.year = year;}
    public String getDuration() {return duration;}
    public void setDuration(String duration) {this.duration = duration;}
    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}
    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}
    public Thumbnail getCover() {return cover;}
    public void setCover(Thumbnail thumbnail) {this.cover = thumbnail;}
    public int getViews() {return views;}
    @Override public int compareTo(Song o) {
        return this.name.compareTo(o.getName());
    }
    @Override public void addView(){this.views+=1;}
}
