package homework.lessonTwo.task;

import java.math.BigDecimal;

public class Triangle extends Shape {

    private Point vertexA;

    private Point vertexB;

    private Point vertexC;

    public Triangle(Point vertexA, Point vertexB, Point vertexC) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
    }

    public Triangle() {
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

    @Override
    public double getPerimetr() {

        double aB = Math.sqrt(Math.pow(vertexB.getX() - vertexA.getX(), 2) + Math.pow(vertexB.getY() - vertexA.getY(), 2));

        double bC = Math.sqrt(Math.pow(vertexC.getX() - vertexB.getX(), 2) + Math.pow(vertexC.getY() - vertexB.getY(), 2));

        double aC = Math.sqrt(Math.pow(vertexC.getX() - vertexA.getX(), 2) + Math.pow(vertexC.getY() - vertexA.getY(), 2));

        return new BigDecimal(aB + bC + aC)
                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public double getArea() {

        return Math.abs((vertexA.getX() - vertexC.getX()) * (vertexB.getY() - vertexC.getY()) -
                (vertexB.getX() - vertexC.getX()) * (vertexA.getY() - vertexC.getY())) * 0.5;

    }

    @Override
    public String toString() {
        return "Triangle{" +
                "vertexA: x = " + vertexA.getX() + ", " + "y = " + vertexA.getY() +
                ", vertexB: x = " + vertexB.getX() + ", " + "y = " + vertexB.getY() +
                ", vertexC: x = " + vertexC.getX() + ", " + "y = " + vertexC.getY() +
                ", trianglePerimetr = " + getPerimetr() + ", triangleArea = " + getArea() +
                '}';
    }
}