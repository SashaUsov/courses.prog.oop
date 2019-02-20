package homework.lessonThird.taskThird;

public class Student extends Person {

    private int gradebookNumber;

    private double gradePointAverage;


    public Student(String name, String surname,
                   int gradebookNumber, double gradePointAverage
    ) {

        super(name, surname);
        this.gradebookNumber = gradebookNumber;
        this.gradePointAverage = gradePointAverage;
    }

    public int getGradebookNumber() {
        return gradebookNumber;
    }

    public void setGradebookNumber(int gradebookNumber) {
        this.gradebookNumber = gradebookNumber;
    }

    public double getGradePointAverage() {
        return gradePointAverage;
    }

    public void setGradePointAverage(int gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    @Override
    public String toString() {
        return super.toString() + " Kind of activity : Student, " +
                "gradebookNumber - " + gradebookNumber +
                ", gradePointAverage - " + gradePointAverage +
                '.';
    }
}
