package homework.lessonNinth.taskThree;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Stat {
    private List<MyCharacter> lettersList;

    public Stat() {
        lettersList = new ArrayList<>();
    }

    public void loadFromFile(File file) {
        String text = Service.loadTextFromFile(file);
        text = text.toUpperCase();

        for (char i = 'A'; i <= 'Z'; i++) {
            int letterCount = letterCount(text, i);

            if (letterCount > 0) {
                lettersList.add(new MyCharacter(i, letterCount));
            }
        }
    }

    private int letterCount(String text, char letter) {
        String l = String.valueOf(letter);
        final String[] strings = text.split("");

        return Arrays.stream(strings).filter(l::equals)
                .collect(Collectors.toList()).size();
    }

    @Override
    public String toString() {
        final List<MyCharacter> collect = lettersList.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(MyCharacter::getCount).reversed())
                .collect(Collectors.toList());

        return "Statistic :" + "\n" + collect ;
    }
}
