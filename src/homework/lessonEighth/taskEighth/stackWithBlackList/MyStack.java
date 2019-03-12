package homework.lessonEighth.taskEighth.stackWithBlackList;



import homework.lessonEighth.taskEighth.stackWithBlackList.exc.MyStackOverflowException;
import homework.lessonEighth.taskEighth.stackWithBlackList.exc.ObjectMismatchException;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class MyStack {

    private Object[] stack = new Object[10];

    private BlackList blackList;

    public MyStack(Object[] stack, BlackList blackList) {
        this.stack = stack;
        this.blackList = blackList;
    }

    public MyStack(BlackList blackList) {
        this.blackList = blackList;
    }

    /*
    * Adding an object to the top of the stack
    * */
    public void add(Object o) throws MyStackOverflowException, ObjectMismatchException {
        if (blackList.inBlackList(o)) {
            IntStream.range(0, stack.length)
                    .filter(idx -> stack[idx] == null)
                    .boxed()
                    .findFirst()
                    .map(idx -> stack[idx] = o)
                    .orElseThrow(MyStackOverflowException::new);
        } else {
            throw new ObjectMismatchException();
        }
    }

    /*
    * Getting an object from the top of the stack without removing it
    * */
    public Object peek() {
        int i = elementPosition();
        return stack[i];
    }

    /*
    * Getting an object from the top of the stack and removing it from the stack
    * */
    public Object pool() {
        int i = elementPosition();
        Object o = stack[i];
        stack[i] = null;
        return o;
    }

    private int elementPosition() {
        for (int i = stack.length - 1; i >= 0; i--) {
            if (stack[i] != null) {
                return i;
            }
        }
        throw new NoSuchElementException("No items in stack");
    }
}
