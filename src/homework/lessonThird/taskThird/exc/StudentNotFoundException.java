package homework.lessonThird.taskThird.exc;

public class StudentNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Student not found";
    }
}
