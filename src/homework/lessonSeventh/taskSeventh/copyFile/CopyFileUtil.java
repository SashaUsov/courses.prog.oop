package homework.lessonSeventh.taskSeventh.copyFile;

import java.io.*;

public class CopyFileUtil implements Runnable{
    private File fileDirectory;
    private String targetLocation;

    public CopyFileUtil(File fileDirectory, String targetLocation) {
        this.fileDirectory = fileDirectory;
        this.targetLocation = targetLocation;
    }

    public void copyFile() {

        File[] files = fileDirectory.listFiles();


        for (int i =0 ; i < files.length; i++) {
            try (InputStream in = new FileInputStream(files[i]);
                 OutputStream out = new FileOutputStream(targetLocation + "/" + files[i].getName())) {

                double progress = 0;
                double fileSize = in.available();
                int len;

                byte[] buf = new byte[1024];

                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                    progress = progress + len;
                    double percentage = (progress / fileSize) * 100;

                    System.out.print("File " + (i + 1) + " of " + files.length + " copying in progress "
                            + String.format("%.2f", percentage) + " % \n");

                    Thread.sleep(1000);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("\nFile " + (i + 1) + " copy completed. " + (files.length - (i + 1)) + " files left \n");
        }
        System.out.println("\n Copying All Files Completed!");
    }

    @Override
    public void run() {
        copyFile();
    }
}
