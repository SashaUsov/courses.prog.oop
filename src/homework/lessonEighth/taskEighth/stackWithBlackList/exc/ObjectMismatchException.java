package homework.lessonEighth.taskEighth.stackWithBlackList.exc;

public class ObjectMismatchException extends Exception{

    @Override
    public String getMessage() {
        return "Object is in the blacklist";
    }
}
