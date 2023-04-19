package Model.Assets.Artist;

import Model.Assets.Song.Song;

import java.io.Serializable;

public interface Artist_Interface extends Comparable<Artist>, Serializable {
    void addSong(Song song);

    void addSong(String name, String iD, String album, String year, String duration, String genre, String url);
}
