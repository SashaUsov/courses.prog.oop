package homework.lessonOne.firstTask;

public class Main {

    public static void main(String[] args) {

        Cat tom = new Cat("black", "Tom", "man", 2, 15, 30, 7, "blue");

        Cat lucy = new Cat();

        lucy.setColor("foxy");
        lucy.setName("Lucy");
        lucy.setGender("female");
        lucy.setAge(1);
        lucy.setTailLength(16);
        lucy.setBodyLength(25);
        lucy.setWeight(4);
        lucy.setEyeColor("green");

        System.out.println(Cat.voice());

        System.out.println();

        System.out.println(tom.representationOfCat());
        System.out.println(lucy.representationOfCat());

        System.out.println();

        System.out.println(tom.catAge());
        System.out.println(lucy.catAge());

        System.out.println();

        System.out.println(tom.askCatAboutWeight());
        System.out.println(lucy.askCatAboutWeight());

        System.out.println();

        System.out.println(tom.catSize());
        System.out.println(lucy.catSize());

        System.out.println();

        System.out.println(tom);
        System.out.println(lucy);
    }
}
