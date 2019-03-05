package homework.lessonSixth.taskSixth.shellSort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = 10000000;

        /*
        * Create the first array of numbers and randomly fill it.
        * */
        int[] array = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(n*5);
//            System.out.print(array[i] + " ");
        }
        long startTimeOne = System.currentTimeMillis();

        /*
        * We will sort in one stream. Get the array sorting time
        * */
        ShellSort shell = new ShellSort(array);
        System.out.println();
        shell.shellSort();

        long stopTimeOne = System.currentTimeMillis() - startTimeOne;

        System.out.println("Single threaded execution time " + stopTimeOne + "\n");

//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }

        /*
        * Create a second array of numbers and randomly fill it.
        * */
        int[] arrayTwo = new int[n];
        Random rndTwo = new Random();
        for (int i = 0; i < arrayTwo.length; i++) {
            arrayTwo[i] = rndTwo.nextInt(n*5);
//            System.out.print(arrayTwo[i] + " ");
        }

        int[] arrOne = new int[arrayTwo.length/2];
        int[] arrTwo = new int[arrayTwo.length/2];

        long startTimeTwo = System.currentTimeMillis();

        /*
        * Let's carry out multithreaded sorting. Get the array sorting time
        * */
        ShellSort sort = new ShellSort(Arrays.copyOfRange(arrayTwo, 0, arrOne.length));
        ShellSort sortSecond = new ShellSort(Arrays.copyOfRange(arrayTwo, arrOne.length + 1, arrayTwo.length));

        Thread threadOne = new Thread(sort);
        Thread threadTwo = new Thread(sortSecond);

        threadOne.start();
        threadTwo.start();

        try{
                threadOne.join();
                threadTwo.join();
            }catch (InterruptedException e){

            }

        arrOne = sort.getArray();
        arrTwo = sortSecond.getArray();

        /*
        * Let's combine two arrays into one. Finish the final sort in the third stream.
        * */
        int[] result = new int[arrOne.length + arrTwo.length];
        System.arraycopy(arrOne, 0, result, 0, arrOne.length);
        System.arraycopy(arrTwo, 0, result, arrOne.length, arrTwo.length);

        ShellSort sortThree = new ShellSort(result);

        Thread threadThree = new Thread(sortThree);

        threadThree.start();

        try{
            threadThree.join();
        }catch (InterruptedException e){

        }

        long stopTimeTwo = System.currentTimeMillis() - startTimeTwo;

//        System.out.println("\n");
//
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + " ");
//        }

        System.out.println("Runtime in multithreaded mode " + stopTimeTwo);
    }
    /*
    * Single threaded execution time 2551
    * Runtime in multithreaded mode 1567
    * */
}
