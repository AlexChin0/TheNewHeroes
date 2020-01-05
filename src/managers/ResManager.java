package managers;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResManager {

    private static final long serialVersionUID = 1L;

    /**Save method that write to disk.
    @param data the object to be written
    @param fileName the name of the file
    @throws Exception no catch here
    */
    public static void save(Serializable data, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            oos.writeObject(data);
        } catch (Exception e) {
            System.out.println("save error");
        }
    }

    /**Load method that loads object from disk.
    @param fileName the name of the file
    @return the object that was read.
    @throws Exception no catch here
    */
    public static Object load(String fileName) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return ois.readObject();
        }
    }

}
