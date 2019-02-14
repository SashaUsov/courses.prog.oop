package homework.lessonOne.secondTask;

public class Main {

    public static void main(String[] args) {

        Triangle triangle = new Triangle(3, 4, 5);

        System.out.println(triangle.triangleArea() == 6);

        triangle.setB(8);

        System.out.println(triangle.triangleArea() == -1);

        triangle.setA(7);
        triangle.setB(8);
        triangle.setC(9);

        System.out.println(triangle.triangleArea() != 27);
    }
}
