package homework.lessonThird.exc;

public class NegativeValueException extends Exception {

    @Override
    public String getMessage() {
        return "Negative value impossible";
    }
}
