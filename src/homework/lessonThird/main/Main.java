package homework.lessonThird.main;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] a = generateArray();

        int[] b = generateArray();

        int[] c = generateArray();
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));

        System.out.println("Sum " + getSum(a, b, c));
    }

    public static int[] generateArray() {

        Random rn = new Random();

        int[] array = new int[5 + rn.nextInt(6)];

        for (int i =0; i < array.length; i++) {

            array[i] = rn.nextInt(10);
        }

        return array;
    }

    public static int getSum(int[] a, int[] b, int[] c) {

        int sum = 0;

        int length = 0;

        if (a.length > b.length && a.length > c.length) {

            length = a.length;

        } else if (b.length > a.length && b.length > c.length) {

            length = b.length;

        } else {

            length = c.length;
        }

        for (int i = 0; i < length; i ++) {

            if (a.length > i ) {

                sum = sum + a[i];
            }

            if (b.length > i ) {

                sum = sum + b[i];
            }

            if (c.length > i ) {

                sum = sum + c[i];
            }

        }

        return sum;
    }
}
