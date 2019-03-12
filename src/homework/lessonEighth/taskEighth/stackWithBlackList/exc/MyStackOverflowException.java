package homework.lessonEighth.taskEighth.stackWithBlackList.exc;

public class MyStackOverflowException extends Exception{

    @Override
    public String getMessage() {
        return "The stack is already full";
    }
}
