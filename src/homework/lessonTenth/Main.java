package homework.lessonTenth;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();

        Random rn = new Random();

        for (int i = 0; i < 100; i++) {
            numberList.add(rn.nextInt(10));
        }

        Map<Integer, Integer> stat = new HashMap<>();

        for (Integer number : numberList) {

                if (stat.get(number) != null) {
                    final int i = numberList.get(number);
                    stat.put(number, i + 1);
                } else {
                    stat.put(number, 1);
                }
        }

        System.out.println(stat);
    }
}
