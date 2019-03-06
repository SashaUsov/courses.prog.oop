package homework.lessonSeventh;

public class PushPullTask implements Runnable {

    private Action action;

    private String text;

    boolean m;

    public PushPullTask(Action action, String text, boolean m) {
        this.action = action;
        this.text = text;
        this.m = m;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            action.printText(text, m);
        }
    }
}
