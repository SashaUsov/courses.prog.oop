package homework.lessonOne;

public class Main {

    public static void main(String[] args) {

        Car carOne = new Car("Green", 2000, 1981);

        Car carTwo = new Car();

        carTwo.setColor("Red");

        carTwo.setWeight(1500);

        carTwo.setYear(2010);

        System.out.println(carOne);

        System.out.println();

        System.out.println(carTwo);
    }
}
