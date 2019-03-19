package homework.lessonNinth.taskThree;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("English.in.txt");

        Stat stat = new Stat();
        stat.loadFromFile(file);
        System.out.println(stat);
    }
}
