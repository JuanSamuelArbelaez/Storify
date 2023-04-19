package Model.Tools;


import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageManager {
    public static Image getThumbnail(String url, String fileName) throws IOException {
        String imagePath = "src/images/Thumbnails/" + fileName;
        File imageFile = new File(imagePath);
        Image image = new Image(imageFile.toURI().toString());
        if(!imageFile.exists()) return downloadThumbnail(url, fileName);
        return image;
    }
    private static Image downloadThumbnail(String imageUrl, String fileName) throws IOException {
        URL url = new URL(imageUrl);
        InputStream inputStream = url.openStream();
        Path imagesFolder = Paths.get("src", "images/Thumbnails");
        Files.createDirectories(imagesFolder);
        File imageFile = new File(imagesFolder.toFile(), fileName);
        FileOutputStream outputStream = new FileOutputStream(imageFile);
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.close();
        inputStream.close();

        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (fileExtension.equalsIgnoreCase("jpg") || fileExtension.equalsIgnoreCase("jpeg")) {
            ImageIO.write(ImageIO.read(imageFile), "jpg", imageFile);
        } else if (fileExtension.equalsIgnoreCase("png")) {
            ImageIO.write(ImageIO.read(imageFile), "png", imageFile);
        } else if (fileExtension.equalsIgnoreCase("gif")) {
            ImageIO.write(ImageIO.read(imageFile), "gif", imageFile);
        }
        Image i = SwingFXUtils.toFXImage(ImageIO.read(imageFile), null);
        return i;
    }
    public static String generateImgURL(String url) {
        String imgURL = "https://img.youtube.com/vi/";
        if(url.startsWith("https://www.youtube.com/watch?v=")) return imgURL += url.split("v=")[1] + "/maxresdefault.jpg";
        if(url.startsWith("https://youtu.be/")) return imgURL += url.split("be/")[1] + "/maxresdefault.jpg";
        return url;
    }
}
