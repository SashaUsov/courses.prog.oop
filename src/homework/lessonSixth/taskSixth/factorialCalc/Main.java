package homework.lessonSixth.taskSixth.factorialCalc;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 101; i++) {
            Thread thread = new Thread(new FactorialCalc(i));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {

            }
        }
        Thread thr = Thread.currentThread();
        System.out.println(thr.getName() + " STOP");
    }
}
