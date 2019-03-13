package homework.lessonNinth.taskTwo.exc;

public class StudentNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "This student was not found in the group.";
    }
}
