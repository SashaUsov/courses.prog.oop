package homework.lessonFifth.taskFifth.concatenationOfFiles;

import java.io.*;

public class TextWriter {

    public static void writeToFile(String targetLocation, String text) {

        File out = new File(targetLocation);

        if (!out.exists()) {
            out.mkdir();
        }

        String result = "";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(out))){

            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
