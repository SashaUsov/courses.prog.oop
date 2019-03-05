package homework.lessonSixth.taskSixth.arraySum;

import java.util.Arrays;

public class ArraySum  implements Runnable{
    private int[] arr;
    private Long resultSum;

    public ArraySum(int[] arr) {
        this.arr = arr;
    }

    public Long getResultSum() {
        return resultSum;
    }

    public void sum() {
        resultSum = Arrays.stream(arr).summaryStatistics().getSum();
    }

    @Override
    public void run() {
        sum();
    }
}
