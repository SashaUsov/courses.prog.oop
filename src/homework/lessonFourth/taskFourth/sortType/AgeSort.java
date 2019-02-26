package homework.lessonFourth.taskFourth.sortType;

import homework.lessonFourth.taskFourth.Student;
import homework.lessonFourth.taskFourth.logicalInterfaces.Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

public class AgeSort implements Sorting {

    @Override
    public Boolean accept(String sortingOptions) {

        return "age".equalsIgnoreCase(sortingOptions);
    }

    @Override
    public Student[] sort(Student[] students, int sortingType) {

        final Stream<Student> studentStream = Arrays.stream(students).filter(Objects::nonNull);

        if (sortingType < 0) {

            return studentStream.sorted(Comparator.comparing(Student::getAge).reversed())
                    .toArray(Student[]::new);
        } else {

            return studentStream
                    .sorted(Comparator.comparing(Student::getAge))
                    .toArray(Student[]::new);
        }
    }
}
