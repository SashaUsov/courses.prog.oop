package homework.lessonEighth.taskEighth.groupSerialization.exc;

public class GroupIsEmptyException extends Exception {

    @Override
    public String getMessage() {
        return "No students in the group";
    }
}
