package homework.lessonSixth.taskSixth.factorialCalc;

import java.math.BigInteger;

public class FactorialCalc implements Runnable {
    private int number;

    public FactorialCalc(int number) {
        this.number = number;
    }

    public FactorialCalc() {
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

        System.out.println(thr.getName() + " != " + factorialCalculate(number));

    }
}
