package homework.lessonSeventh.taskSeventh.fileSearch;

import java.io.File;

public class FileSearch implements Runnable {
    private String fileName;
    private File[] files;
    private int count = 0;

    public FileSearch(String fileName, File[] files) {
        this.fileName = fileName;
        this.files = files;
    }

    public void searching(File[] files) {

        if (files == null) return;
        for (File file : files) {
            if (file.isFile() && file.getName().equalsIgnoreCase(fileName)) {
                count++;
                System.out.format(Thread.currentThread().getName() + " has found "
                        + file.getName() + ". The path to the file " + file.getAbsolutePath() + "\n");
            } else if (file.isDirectory()) {
                searchInDirectory(file);
            }
        }
    }

    private void searchInDirectory(File file) {
        Thread newThread = new Thread(new SearchInDirectory(this, file.listFiles()));
        newThread.start();
        try {
            newThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        searching(files);
        if (count == 0) {
            System.out.println("File not found!");
        }
    }
}
