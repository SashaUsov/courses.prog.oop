package homework.lessonNinth.taskTwo.logicalInterfaces;

import homework.lessonNinth.taskTwo.Student;

import java.util.List;

public interface Sorting {

    Boolean accept(String sortingOptions);

    List<Student> sort(List<Student> students, int sortingType);
}
