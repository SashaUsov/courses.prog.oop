package homework.lessonEighth.taskEighth.stackWithBlackList.entity;

public class Birdie {
    private String name;
    private int age;

    public Birdie(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Birdie{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
