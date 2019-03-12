package homework.lessonEighth.taskEighth.groupSerialization.logicalInterfaces;

import homework.lessonEighth.taskEighth.groupSerialization.exc.GroupOverflowException;

import java.io.IOException;

public interface GenericDao<ID, ENTITY> {

    ID save(ENTITY entity, String targetLocation) throws IOException;

    ENTITY read(String targetLocation) throws IOException, GroupOverflowException, ClassNotFoundException;
}
