package homework.lessonEighth.taskEighth.stackWithBlackList.entity;

public class Hamster {
    private String name;
    private int age;

    public Hamster(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Hamster{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
