package homework.lessonSeventh;

public class Main {

    public static void main(String[] args) {
        Action action = new Action(false);

        PushPullTask push = new PushPullTask(action, "push ", true);
        PushPullTask pull = new PushPullTask(action, "pull ", false);

        Thread threadOne = new Thread(push);
        Thread threadTwo = new Thread(pull);

        threadOne.start();
        threadTwo.start();

    }
}
