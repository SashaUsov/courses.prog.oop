package homework.lessonEighth.taskEighth.stackWithBlackList.exc;

public class BlackListOverflowException extends Exception{

    @Override
    public String getMessage() {
        return "The blacklist is already full";
    }
}
