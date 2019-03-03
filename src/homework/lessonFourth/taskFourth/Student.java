package homework.lessonFourth.taskFourth;

public class Student extends Person {

    private int gradeBookNumber;

    private double gradePointAverage;


    public Student(String name, String surname, String sex, int age,
                   int gradeBookNumber, double gradePointAverage
    ) {

        super(name, surname, sex, age);
        this.gradeBookNumber = gradeBookNumber;
        this.gradePointAverage = gradePointAverage;
    }

    public Student() {
    }

    public Integer getGradeBookNumber() {
        return gradeBookNumber;
    }

    public void setGradeBookNumber(int gradeBookNumber) {
        this.gradeBookNumber = gradeBookNumber;
    }

    public Double getGradePointAverage() {
        return gradePointAverage;
    }

    public void setGradePointAverage(double gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    @Override
    public String toString() {
        return super.toString() + " Kind of activity : Student, " +
                "gradeBookNumber - " + gradeBookNumber +
                ", gradePointAverage - " + gradePointAverage +
                '.';
    }
}
