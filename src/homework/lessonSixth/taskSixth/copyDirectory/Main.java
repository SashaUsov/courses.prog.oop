package homework.lessonSixth.taskSixth.copyDirectory;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File folder = new File("folderOne");

        long startTimeOne = System.currentTimeMillis();

        CopyFileUtil copyFile = new CopyFileUtil(folder, "folderTwo");
        Thread thread = new Thread(copyFile);
        thread.start();

        long stopTimeOne = System.currentTimeMillis() - startTimeOne;

        System.out.println("Runtime in multithreaded mode " + stopTimeOne + "\n");

        File folderTwo = new File("folderThree");

        long startTimeTwo = System.currentTimeMillis();

        CopyFileUtil copyFiletwo = new CopyFileUtil(folderTwo, "folderFour");

         copyFiletwo.copyFile();

        long stopTimeTwoo = System.currentTimeMillis() - startTimeTwo;

        System.out.println("Single threaded execution time " + stopTimeTwoo + "\n");
    }

    /*
    * Single threaded execution time 4 ms
    * Runtime in multithreaded mode 2 ms
    * */
}
