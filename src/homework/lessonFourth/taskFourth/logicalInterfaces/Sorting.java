package homework.lessonFourth.taskFourth.logicalInterfaces;

import homework.lessonFourth.taskFourth.Student;

public interface Sorting {

    Boolean accept(String sortingOptions);

    Student[] sort(Student[] students, int sortingType);
}
