package homework.lessonFifth.taskFifth.copyFile;

import java.io.*;

public class CopyFileUtil {

    public static void copyFile(File fileDirectory, FileFilter fileFilter, String targetLocation) {

        File[] files = fileDirectory.listFiles(fileFilter);

        for (File file : files) {
            try (InputStream in = new FileInputStream(file);
                 OutputStream out = new FileOutputStream(targetLocation + "/" + file.getName());) {

                // Copy the bits from input stream to output stream
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
}
