package homework.lessonFourth;

public class Ball implements BabyToy, Comparable {

    private int size;

    private String color;

    public Ball(int size, String color) {
        this.size = size;
        this.color = color;
    }

    public Ball() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String play() {

        return "Bamz";
    }

    @Override
    public boolean canPlay() {

        return true;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "size=" + size +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {

        Ball ball = (Ball) o;

        if (this.size > ball.size) {

            return 1;

        }
        if (this.size < ball.size) {

            return -1;
        }

        return 0;
    }
}
