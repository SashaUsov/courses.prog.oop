package homework.lessonEighth;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Cat catOne = new Cat("Bob", 3, "black");
        Cat catTwo = new Cat("Bob", 3, "black");
        System.out.println(catOne.hashCode());
        System.out.println(catTwo.hashCode());

        File file = new File("file.txt");

        try {
            Serial.saveToFile(file, catOne);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Cat cat = null;

        try {
            cat = (Cat)Serial.loadFromFile(file);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(cat);
    }
}
