package homework.lessonSixth.taskSixth.arraySum;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int arrLength = 1000;
        int[] arr = new int[arrLength];

        for (int i = 0; i < arrLength; i++) {
            arr[i] = i;
        }
        long startTimeOne = System.currentTimeMillis();

        ArraySum arraySum = new ArraySum(arr);
        arraySum.sum();
        System.out.println("Single threaded sum " + arraySum.getResultSum());

        long stopTimeOne = System.currentTimeMillis() - startTimeOne;

        System.out.println("Single threaded execution time " + stopTimeOne);

        /*
        * Beginning of multithread sum calculation
        * */
        long startTimeTwo = System.currentTimeMillis();

        int point = arrLength/4;
        Long result = 0l;

        for (int i = 0; i < arrLength; i++) {
            /*
            * We transfer the necessary part of the array Arrays.copyOfRange
            * */
            ArraySum arraySumThr = new ArraySum(Arrays.copyOfRange(arr, i, point + 1));
            Thread thread = new Thread(arraySumThr);
            thread.start();

            try{
                thread.join();
            }catch (InterruptedException e){

            }
            result = result + arraySumThr.getResultSum();
            i = point;
            point = point + (arrLength/4);
        }

        System.out.println("Multithread sum " + result);

        long stopTimeTwo = System.currentTimeMillis() - startTimeTwo;

        System.out.println("Runtime in multithreaded mode " + stopTimeTwo);
    }
}
