package Model.Tools;

import Storify.Storify;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManager {

    public static Storify readFile() throws Exception {
        FileInputStream fis = new FileInputStream("Stor.fy");
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (Storify) ois.readObject();
    }

    public static void writeFile(Storify storify) throws Exception {
        FileOutputStream fos = new FileOutputStream("Stor.fy");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // write object to file
        oos.writeObject(storify);
        oos.close();
    }
}
