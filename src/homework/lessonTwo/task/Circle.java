package homework.lessonTwo.task;

import java.math.BigDecimal;

public class Circle extends Shape {

    private Point centerOfTheCircle;

    private Point pointOnTheBorder;

    public Circle(Point centerOfTheCircle, Point pointOnTheBorder) {
        this.centerOfTheCircle = centerOfTheCircle;
        this.pointOnTheBorder = pointOnTheBorder;
    }

    public Circle() {
    }

    public Point getCenterOfTheCircle() {
        return centerOfTheCircle;
    }

    public void setCenterOfTheCircle(Point centerOfTheCircle) {
        this.centerOfTheCircle = centerOfTheCircle;
    }

    public Point getPointOnTheBorder() {
        return pointOnTheBorder;
    }

    public void setPointOnTheBorder(Point pointOnTheBorder) {
        this.pointOnTheBorder = pointOnTheBorder;
    }

    private double getRadius() {

        return Math.sqrt(Math.pow((pointOnTheBorder.getX() - centerOfTheCircle.getX()), 2) +
                Math.pow((centerOfTheCircle.getX() - pointOnTheBorder.getY()), 2));
    }

    @Override
    public double getPerimetr() {

        double perimetr = Math.PI * getRadius() * 2;

        return new BigDecimal(perimetr)
                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public double getArea() {

        double area = Math.PI * Math.pow(getRadius(), 2);

        return new BigDecimal(area)
                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        return "Circle{" +
                "centerOfTheCircle: x = " + centerOfTheCircle.getX() + ", " + "y = " + centerOfTheCircle.getY() +
                ", pointOnTheBorder: x = " + pointOnTheBorder.getX() + ", " + "y = " + pointOnTheBorder.getY() +
                ", circlePerimetr = " + getPerimetr() + ", circleArea = " + getArea() +
                '}';
    }
}
