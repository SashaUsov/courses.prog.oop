package homework.lessonNinth.taskOne;

import java.util.ArrayList;
import java.util.List;

public class ListCombo {
    public static void comboListOperation() {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int n = (int) (Math.random() * 11);
            arr.add(n);
        }
        arr.remove(0);
        arr.remove(1);
        arr.remove(7);
        arr.forEach((temp) -> System.out.print(temp + " "));
    }
}
