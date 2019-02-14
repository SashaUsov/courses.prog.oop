package homework.lessonOne.secondTask;

/*
The lengths of the sides of the triangle cannot be "<" or "=" 0
*/
public class Triangle {

    private double a;

    private double b;

    private double c;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    /* Formula Heron
    * If the triangle does not exist, returns -1
    * Else return result
    * */
    public double triangleArea() {

        if (a + b > c && a + c > b && b + c > a) {

            double semiPerimeter = (a + b + c) / 2;

            double area = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));

            return Math.round(area);
        } else {

            return -1;
        }
    }

    @Override
    public String toString() {
        return "Triangle:" +
                "triangle side a=" + a +
                ", triangle side b=" + b +
                ", triangle side c=" + c +
                '.';
    }
}
