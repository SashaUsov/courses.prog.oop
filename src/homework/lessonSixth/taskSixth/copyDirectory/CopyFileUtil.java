package homework.lessonSixth.taskSixth.copyDirectory;

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

        for (File file : files) {
            try (InputStream in = new FileInputStream(file);
                 OutputStream out = new FileOutputStream(targetLocation + "/" + file.getName())) {

                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        copyFile();
    }
}
