package homework.lessonNinth.taskThree;

public class MyCharacter {
    private char letter;
    private int count = 0;

    public MyCharacter(char letter, int count) {
        this.letter = letter;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyCharacter that = (MyCharacter) o;

        if (letter != that.letter) return false;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        int result = (int) letter;
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "letter=" + letter +
                ", count=" + count + " ";
    }
}
