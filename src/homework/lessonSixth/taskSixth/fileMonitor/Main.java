package homework.lessonSixth.taskSixth.fileMonitor;

public class Main {

    public static void main(String[] args) {

        Thread t = new Thread(new FileMonitor());
        t.start();
    }

}
