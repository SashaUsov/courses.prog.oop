package homework.lessonFifth.taskFifth.concatenationOfFiles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TextConcat {

    public static String concatText(String firstText, String secondText) {

        Set<String> finalText = new HashSet<>();

        final String[] arrayOne = stringToArray(firstText);
        final String[] arrayTwo = stringToArray(secondText);

        for (String one : arrayOne) {
            for (String two : arrayTwo) {
                if(one.equalsIgnoreCase(two)) {
                    finalText.add(one.toLowerCase());
                }
            }
        }
        return finalText.stream().collect(Collectors.joining(", "));
    }

    private static String[] stringToArray(String text) {

        String[] array = text.split(" ");

        return Arrays.stream(array)
                .map(a -> a.replaceAll("\\P{L}+", ""))
                .toArray(String[]::new);
    }
}
