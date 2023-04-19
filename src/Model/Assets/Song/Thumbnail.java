package Model.Assets.Song;

import Model.Tools.ImageManager;
import javafx.scene.image.Image;

public class Thumbnail {
    private Image img = null;
    private String url = "";
    private  String iD = "";
    public Thumbnail(Song song){
        this.url = ImageManager.generateImgURL(song.getUrl());
        this.iD = song.getiD();
        try {
            this.img = ImageManager.getThumbnail(url, iD + ".jpg");
        }catch (Exception e){}
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }
}
