package homework.lessonTwo.task;

public class Square extends Shape{

    private Point vertexA;

    private Point vertexB;

    private Point vertexC;

    private Point vertexD;

    private final double aB;

    private final double bC;

    public Square(Point vertexA, Point vertexB, Point vertexC, Point vertexD) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        this.vertexD = vertexD;
        aB = Math.sqrt(Math.pow(vertexB.getX() - vertexA.getX(), 2) + Math.pow(vertexB.getY() - vertexA.getY(), 2));
        bC = Math.sqrt(Math.pow(vertexB.getX() - vertexC.getX(), 2) + Math.pow(vertexB.getY() - vertexC.getY(), 2));
    }

    public Point getVertexA() {
        return vertexA;
    }

    public void setVertexA(Point vertexA) {
        this.vertexA = vertexA;
    }

    public Point getVertexB() {
        return vertexB;
    }

    public void setVertexB(Point vertexB) {
        this.vertexB = vertexB;
    }

    public Point getVertexC() {
        return vertexC;
    }

    public void setVertexC(Point vertexC) {
        this.vertexC = vertexC;
    }

    public Point getVertexD() {
        return vertexD;
    }

    public void setVertexD(Point vertexD) {
        this.vertexD = vertexD;
    }

    @Override
    public double getPerimetr() {

        return (aB + bC) * 2 ;
    }

    @Override
    public double getArea() {

        return aB * bC;
    }

    @Override
    public String toString() {
        return "Square{" +
                "vertexA: x = " + vertexA.getX() + ", " + "y = " + vertexA.getY() +
                ", vertexB: x = " + vertexB.getX() + ", " + "y = " + vertexB.getY() +
                ", vertexC: x = " + vertexC.getX() + ", " + "y = " + vertexC.getY() +
                ", vertexD: x = " + vertexD.getX() + ", " + "y = " + vertexD.getY() +
                ", squarePerimetr = " + getPerimetr() + ", squareArea = " + getArea() +
                '}';
    }
}
