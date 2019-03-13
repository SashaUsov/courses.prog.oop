package homework.lessonNinth;

public class Container<T> {
    private T ele;

    public Container(T ele) {
        this.ele = ele;
    }

    public T getEle() {
        return ele;
    }

    public void setEle(T ele) {
        this.ele = ele;
    }
}
