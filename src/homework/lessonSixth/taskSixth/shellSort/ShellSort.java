package homework.lessonSixth.taskSixth.shellSort;

public class ShellSort implements Runnable{
    private int[] array;

    public ShellSort(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void shellSort() {
        int inner, outer;
        int temp;

        int h = 1;

        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {

            for (outer = h; outer < array.length; outer++) {
                temp = array[outer];
                inner = outer;

                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }

            h = (h - 1) / 3;
        }
    }

    @Override
    public void run() {
        shellSort();
    }
}
