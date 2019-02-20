package homework.lessonThird.taskThird.exc;

public class GroupOverflowException extends Exception {

    @Override
    public String getMessage() {
        return "The group has already been recruited";
    }
}
