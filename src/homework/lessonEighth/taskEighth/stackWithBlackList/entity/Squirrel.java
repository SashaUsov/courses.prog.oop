package homework.lessonEighth.taskEighth.stackWithBlackList.entity;

public class Squirrel {
    private String name;
    private int age;

    public Squirrel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Squirrel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
