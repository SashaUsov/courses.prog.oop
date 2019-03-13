package homework.lessonNinth.taskThree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Service {

    public static String loadTextFromFile(File file) {
        if (file == null) {
            throw new IllegalArgumentException("The file does not exist");
        }

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String text;

            for (; (text = br.readLine()) != null;) {
                stringBuilder.append(text);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return stringBuilder.toString();
    }
}
