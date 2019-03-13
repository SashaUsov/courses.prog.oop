package homework.lessonNinth.taskTwo;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (gradeBookNumber != student.gradeBookNumber) return false;
        return Double.compare(student.gradePointAverage, gradePointAverage) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = gradeBookNumber;
        temp = Double.doubleToLongBits(gradePointAverage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
