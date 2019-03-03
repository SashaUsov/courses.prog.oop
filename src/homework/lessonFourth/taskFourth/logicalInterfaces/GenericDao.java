package homework.lessonFourth.taskFourth.logicalInterfaces;

import homework.lessonFourth.taskFourth.exc.GroupOverflowException;

import java.io.IOException;

public interface GenericDao<ID, ENTITY> {

    ID save(ENTITY entity, String targetLocation) throws IOException;

    void read(ENTITY entity, String targetLocation) throws IOException, GroupOverflowException;
}
