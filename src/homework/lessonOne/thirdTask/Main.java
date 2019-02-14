package homework.lessonOne.thirdTask;

public class Main {

    public static void main(String[] args) {

        Vector3d vectorOne = new Vector3d(2, 1, -3);

        Vector3d vectorTwo = new Vector3d();

        vectorTwo.setX(0);
        vectorTwo.setY(-1);
        vectorTwo.setZ(1);

        System.out.println(vectorOne);
        System.out.println(vectorTwo + "\n");

        System.out.println("The sum of two vectors: ");

        System.out.println(vectorOne.vectorSum(vectorTwo));
        System.out.println(vectorTwo.vectorSum(vectorOne) + "\n");

        System.out.println("Scalar vectors multiplication: ");

        System.out.println(vectorOne.scalarProductOfVectors(vectorTwo));
        System.out.println(vectorTwo.scalarProductOfVectors(vectorOne) + "\n");

        System.out.println("Vector multiplication of vectors: ");

        System.out.println(vectorOne.vectorProductOfVectors(vectorTwo));
        System.out.println(vectorTwo.vectorProductOfVectors(vectorOne));
    }
}
