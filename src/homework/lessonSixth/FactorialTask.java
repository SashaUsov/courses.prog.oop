package homework.lessonSixth;

import java.math.BigInteger;

public class FactorialTask implements Runnable {
    private int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    public FactorialTask() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigInteger factorialCalculate(int n) {

        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigInteger("" + i));
        }
        return fact;
    }

    @Override
    public void run() {
        Thread thr = Thread.currentThread();

        for(int i = 1 ; i <= this.number; i++) {
            if (thr.isInterrupted()) {
                System.out.println(thr.getName() + " is Interrupted");
                return;
            }
            System.out.println(thr.getName() + " => " + i + " != " + factorialCalculate(i));
        }
    }
}
