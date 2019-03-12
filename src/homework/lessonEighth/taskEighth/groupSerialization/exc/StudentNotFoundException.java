package homework.lessonEighth.taskEighth.groupSerialization.exc;

public class StudentNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "This student was not found in the group.";
    }
}
