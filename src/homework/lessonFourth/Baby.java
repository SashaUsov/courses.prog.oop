package homework.lessonFourth;

public class Baby {

    private String name;

    private int age;

    public Baby(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Baby() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Baby{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void play(BabyToy babyToy) {

        System.out.println("Play with " + babyToy.toString());

        if(babyToy.canPlay()) {

            System.out.println(babyToy.play());

        } else {

            System.out.println(":(");
        }

    }
}
