package homework.lessonFifth.taskFifth.copyFile;

import java.io.File;
import java.io.FileFilter;

public class DocFileFilter implements FileFilter{

    private final String EXTENSION = "doc";

    private boolean check(String ext) {
        return ext.endsWith(EXTENSION);
    }

    @Override
    public boolean accept(File pathname) {

        int pointerIndex = pathname.getName().lastIndexOf(".");

        if (pointerIndex == -1) {
            return false;
        }
        String ext = pathname.getName().substring(pointerIndex + 1);
        return check(ext);
    }
}
