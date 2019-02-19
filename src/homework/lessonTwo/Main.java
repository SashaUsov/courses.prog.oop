package homework.lessonTwo;

public class Main {

    public static void main(String[] args) {

        Cat cat = new Cat(4, 6, true, "Milk", "Vaska", "Home cat");

        System.out.println(cat.getAge());

        cat.getVoice();

        System.out.println(cat);

    }
}
