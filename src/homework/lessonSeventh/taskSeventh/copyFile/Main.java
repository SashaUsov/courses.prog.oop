package homework.lessonSeventh.taskSeventh.copyFile;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File folder = new File("folderOne");

        CopyFileUtil copyFile = new CopyFileUtil(folder, "folderTwo");
        Thread thread = new Thread(copyFile);
        thread.start();

    }
}
