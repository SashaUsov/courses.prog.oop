package homework.lessonEighth.taskEighth.groupSerialization.dao;

import homework.lessonEighth.taskEighth.groupSerialization.Group;
import homework.lessonEighth.taskEighth.groupSerialization.exc.GroupOverflowException;
import homework.lessonEighth.taskEighth.groupSerialization.logicalInterfaces.GenericDao;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class GroupDAO implements GenericDao<String, Group> {

    @Override
    public String save(Group group, String targetLocation) throws IOException {
        int i = targetLocation.lastIndexOf(".");
        Path tempFile = Files.createTempFile(targetLocation.substring(0, i), targetLocation.substring(i));

        try (ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(tempFile.toFile()))) {
            oos.writeObject(group);
            return tempFile.toUri().getPath();
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public Group read(String targetLocation) throws IOException, GroupOverflowException, ClassNotFoundException {
        try (ObjectInput ois =
                     new ObjectInputStream(new FileInputStream(targetLocation))) {

            return (Group) ois.readObject();

        } catch (IOException e) {
            throw e;
        }
    }
}
