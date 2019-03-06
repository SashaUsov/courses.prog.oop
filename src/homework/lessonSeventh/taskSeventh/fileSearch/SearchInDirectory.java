package homework.lessonSeventh.taskSeventh.fileSearch;

import java.io.File;

public class SearchInDirectory implements Runnable {
    private FileSearch fileSearch;
    private File[] files;

    public SearchInDirectory(FileSearch fileSearch, File[] files) {
        this.fileSearch = fileSearch;
        this.files = files;
    }

    @Override
    public void run() {
        fileSearch.searching(files);
    }
}
