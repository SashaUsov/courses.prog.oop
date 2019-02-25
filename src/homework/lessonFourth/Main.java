package homework.lessonFourth;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Baby baby = new Baby("Bob", 3);

        Ball ball = new Ball(15, "Red");

        Ball ball_1 = new Ball(32, "Black");

        Ball ball_2 = new Ball(12, "Blue");

        Ball ball_3 = new Ball(19, "White");

        Ball ball_4 = new Ball(17, "Yellow");

        baby.play(ball);

        Cat cat = new Cat("Tom", "Black", 4);

        Cat catOne = new Cat("Stiv", "Black", 1);

        Cat catThree = new Cat("Soni", "Black", 5);

        Cat[] cats = new Cat[] {cat, catOne, catThree};

        baby.play(cat);

        Ball[] balls = new Ball[] {ball, ball_1, ball_2, ball_3, ball_4};

        for (Ball b : balls) {

            System.out.println(b);
        }

        System.out.println();

        Arrays.sort(balls);

        for (Ball b : balls) {

            System.out.println(b);
        }

        System.out.println();

        for (Cat c : cats) {

            System.out.println(c);
        }

        System.out.println();

        Arrays.sort(cats, Comparator.comparingInt(Cat::getAge));

        for (Cat c : cats) {

            System.out.println(c);
        }
    }
}
