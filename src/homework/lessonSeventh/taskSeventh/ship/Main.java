package homework.lessonSeventh.taskSeventh.ship;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Ship shipOne = new Ship("one");
        Ship shipTwo = new Ship("two");
        Ship shipThree = new Ship("three");

        ExecutorService port = Executors.newFixedThreadPool(2);

        port.execute(shipOne);
        port.execute(shipTwo);
        port.execute(shipThree);

        port.shutdown();
    }
}
