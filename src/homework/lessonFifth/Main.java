package homework.lessonFifth;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        File in = new File("NewFile.txt");
        File out = new File("FileCopy.txt");

        try {
            IOWork.fileCopy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
