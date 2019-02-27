package homework.lessonFifth.taskFifth.copyFile;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        FileFilter dFF = new DocFileFilter();

        File folder = new File("folderOne");

        CopyFileUtil.copyFile(folder, dFF, "folderTwo");

    }
}
