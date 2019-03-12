package homework.lessonEighth.taskEighth.groupSerialization.logicalInterfaces;

import homework.lessonEighth.taskEighth.groupSerialization.entity.Student;

public interface Sorting {

    Boolean accept(String sortingOptions);

    Student[] sort(Student[] students, int sortingType);
}
