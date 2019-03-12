package homework.lessonEighth;

import java.io.*;

public class Serial {

    public static void saveToFile(File file, Object o) throws IOException {
        try(ObjectOutput oos =
                    new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(o);

        } catch (IOException e) {
            throw e;
        }
    }

    public static Object loadFromFile(File file) throws IOException, ClassNotFoundException {
        try(ObjectInput ois =
                    new ObjectInputStream(new FileInputStream(file))) {

            return ois.readObject();

        } catch (IOException e) {
            throw  e;
        }
    }
}
