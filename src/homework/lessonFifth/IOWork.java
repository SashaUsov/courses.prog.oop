package homework.lessonFifth;

import java.io.*;

public class IOWork {

    public static void streamCopy(InputStream is, OutputStream os) throws IOException {

        byte[] buffer = new byte[1024 * 1024];

        int n = 0;

        for (;(n = is.read(buffer)) > 0; ) {

            os.write(buffer, 0, n);
        }
    }

    public static void fileCopy(File in, File out) throws IOException {

        try(InputStream is = new FileInputStream(in);
            OutputStream os = new FileOutputStream(out)) {

            streamCopy(is, os);

        } catch (IOException e) {
            throw e;
        }
    }

}
