package homework.lessonFifth.taskFifth.concatenationOfFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {

    public static String readFromFile(String targetLocation) {

        File in = new File(targetLocation);

        if (in.exists()) {

            String result = "";

            try (BufferedReader reader = new BufferedReader(new FileReader(in))) {

                String temp = "";

                for (; (temp = reader.readLine()) != null; ) {

                    result += temp + System.lineSeparator();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }
        return null;
    }
}
