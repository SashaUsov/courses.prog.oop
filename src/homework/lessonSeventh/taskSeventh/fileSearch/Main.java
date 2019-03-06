package homework.lessonSeventh.taskSeventh.fileSearch;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String fileName = "file.txt";

        File folder = new File("folderOne");

        File[] files = folder.listFiles();

        FileSearch fileSearch = new FileSearch(fileName, files);

        Thread thread = new Thread(fileSearch);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
