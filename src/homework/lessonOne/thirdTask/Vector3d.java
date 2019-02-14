package homework.lessonOne.thirdTask;

public class Vector3d {

    private double x;

    private double y;

    private double z;

    public Vector3d() {
    }

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    /*
    * Sum of vectors returns new vector
    * */
    public Vector3d vectorSum(Vector3d vector) {

        double finalX = x + vector.getX();
        double finalY = y + vector.getY();
        double finalZ = z + vector.getZ();

        return new Vector3d(finalX, finalY, finalZ);
    }

    /*
    * The scalar product of vectors will return a number
    * */
    public double scalarProductOfVectors(Vector3d vector) {

        return this.x * vector.getX() + y * vector.getY() + z * vector.getZ();

    }

    /*
    * Vector multiplication of vectors returns a new vector
    * */
    public Vector3d vectorProductOfVectors(Vector3d vector) {

        double finalX = y * vector.getZ() - z * vector.getY();
        double finalY = z * vector.getX() - x * vector.getZ();
        double finalZ = x * vector.getY() - y * vector.getX();

        return new Vector3d(finalX, finalY, finalZ);
    }

    @Override
    public String toString() {
        return "Vector coordinates:" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '.';
    }
}
