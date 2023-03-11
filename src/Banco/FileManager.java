package Banco;

import Banco.Banco;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManager {

    public static Banco readFile() throws Exception {
        FileInputStream fis = new FileInputStream("Banco.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        return (Banco) ois.readObject();
    }

    public static void writeFile(Banco banco) throws Exception {
        FileOutputStream fos = new FileOutputStream("Banco.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // write object to file
        oos.writeObject(banco);
        oos.close();
    }
}
