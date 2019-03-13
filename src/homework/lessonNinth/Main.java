package homework.lessonNinth;

public class Main {

    public static void main(String[] args) {
        Container<Integer> a = new Container<>(100);

        int number = 5 + a.getEle();

        System.out.println(number);

        Container<String> b =new Container<>("Hello");
    }
}
