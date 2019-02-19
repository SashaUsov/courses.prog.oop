package homework.lessonTwo.task;

public class Main {

    public static void main(String[] args) {

        /*
        * Creation of the first shape and output to the console of the calculation results
        * */
        Square square = new Square(new Point(1, 1), new Point(1, 2), new Point(2, 2), new Point(2, 1));

        System.out.println("The area of the square is " + square.getArea() + "\n");

        System.out.println("The perimetr of the square is " + square.getPerimetr() + "\n");

         /*
        * Creation of the second shape and output to the console of the calculation results
        * */
        Triangle triangle = new Triangle(new Point(3, -3), new Point(7, -3), new Point(5, 5));

        System.out.println("The area of the triangle is " + triangle.getPerimetr() + "\n");

        System.out.println("The perimetr of the triangle is " + triangle.getArea() + "\n");

         /*
        * Creation of the third shape and output to the console of the calculation results
        * */
        Circle circle = new Circle(new Point(0, 0), new Point(0, 3));

        System.out.println("The area of the circle is " + circle.getPerimetr() + "\n");

        System.out.println("The perimetr of the circle is " + circle.getArea() + "\n");

        /*
        * Creating a board and placing the shapes on the board
        * */
        Board board = new Board(new Shape[]{square, triangle, circle, circle});

        /*
        * Getting information about the shapes on the board
        * */
        System.out.println(board.getShapeInfo() + "\n");

        /*
        * Getting the total area of shapes
        * */
        System.out.println(board.getTheTotalArea() + "\n");

        /*
        * Getting the total perimetr of shapes
        * */
        System.out.println(board.getTheTotalPerimetr() + "\n");

        /*
        * Removing a shape from the board by a given ordinal number
        * */
        System.out.println(board.removeShape(4));

        /*
        * Getting information about the shapes on the board
        * The shape number 4 is not listed
        * */
        System.out.println(board.getShapeInfo() + "\n");

        /*
        * Getting the total area of shapes without shape 4
        * */
        System.out.println(board.getTheTotalArea() + "\n");

        /*
        * Getting the total perimetr of shapes without shape 4
        * */
        System.out.println(board.getTheTotalPerimetr() + "\n");

        /*
        * Adding a triangle to the empty board space
        * */
        System.out.println(board.insertShape(triangle) + "\n");

         /*
        * Getting information about the shapes on the board
        * */
        System.out.println(board.getShapeInfo() + "\n");

         /*
        * Getting the total area of shapes
        * */
        System.out.println(board.getTheTotalArea() + "\n");

        /*
        * Getting the total perimetr of shapes
        * */
        System.out.println(board.getTheTotalPerimetr() + "\n");

        /*
        * Creating a new empty board
        * */
        Board board1 = new Board();

        /*
        * Place a square on the board
        * */
        System.out.println(board1.insertShape(square) + "\n");

        /*
        * Put a triangle on the board
        * */
        System.out.println(board1.insertShape(triangle) + "\n");

        /*
        * Getting information about the shapes on the board
        * The third and fourth places on the board without shapes
        * */
        System.out.println(board1.getShapeInfo() + "\n");

        /*
        * Getting the total area of shapes
        * */
        System.out.println(board1.getTheTotalArea() + "\n");

        /*
        * Getting the total perimetr of shapes
        * */
        System.out.println(board1.getTheTotalPerimetr() + "\n");
    }
}
