package homework.lessonNinth.taskFour.CharactersOfTheBigBangTheory;

public abstract class Personage {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Personage{" +
                "name='" + name + '\'' +
                '}';
    }
}
