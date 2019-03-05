package homework.lessonSixth.taskSixth.fileMonitor;

import java.io.File;

public class FileMonitor implements Runnable{

    @Override
    public void run() {
        int previous = new File("folderOne").listFiles().length;

        while (!Thread.interrupted()) {
            int current = new File("folderOne").listFiles().length;

            if (previous < current) {
                System.out.println("Created new file! " + current);
                break;
            } else if (previous > current) {
                System.out.println("Deleted file! " + current);
                break;
            } else {
                System.out.println("Files in a directory " + current);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread t = new Thread(new FileMonitor());
        t.start();
    }
}
