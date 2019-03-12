package homework.lessonEighth.taskEighth.stackWithBlackList.entity;

public class Mouse {
    private String name;
    private int age;

    public Mouse(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
