package homework.lessonTenth.taskOne;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class SaveMap {

    public static String save(EnUaMap map, String targetLocation) throws IOException {
        int i = targetLocation.lastIndexOf(".");
        Path tempFile = Files.createTempFile(targetLocation.substring(0, i), targetLocation.substring(i));

        try (ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(tempFile.toFile()))) {
            oos.writeObject(map);
            return tempFile.toUri().getPath();
        } catch (IOException e) {
            throw e;
        }
    }
}
