package homework.lessonSixth;

public class Main {

    public static void main(String[] args) {

        FactorialTask taskOne = new FactorialTask(10);
        FactorialTask taskTwo = new FactorialTask(10);
        FactorialTask taskThree = new FactorialTask(10);

        Thread threadOne = new Thread(taskOne);
        Thread threadTwo = new Thread(taskTwo);
        Thread threadThree = new Thread(taskThree);

        threadOne.start();
        threadTwo.start();
        threadThree.start();

//        try{
//            threadOne.join();
//            threadTwo.join();
//            threadThree.join();
//        }catch (InterruptedException e){
//
//        }

        threadOne.interrupt();
        threadTwo.interrupt();
        threadThree.interrupt();

        System.out.println(Runtime.getRuntime().availableProcessors());

        Thread thr = Thread.currentThread();
        System.out.println(thr.getName() + " STOP");
    }
}
