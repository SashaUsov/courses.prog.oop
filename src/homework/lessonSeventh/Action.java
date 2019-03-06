package homework.lessonSeventh;

public class Action {
    private boolean b = true;

    public Action(boolean b) {
        this.b = b;
    }

    //    public synchronized void setText(String str, boolean m) {
//        while (b) {
//            try {
//                b = m;
//                wait();
//            } catch (InterruptedException e) {
//            }
//        }
//        text = str;
//        b = m;
//        notifyAll();
//    }

    public synchronized void printText(String text, boolean m) {
        while (b == m) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        b = m;
        System.out.println(text);
        notifyAll();
    }
}

