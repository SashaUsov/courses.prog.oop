package homework.lessonNinth.taskTwo.sortType;

import homework.lessonNinth.taskTwo.Student;
import homework.lessonNinth.taskTwo.logicalInterfaces.Sorting;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradeBookNumberSort implements Sorting {

    @Override
    public Boolean accept(String sortingOptions) {

        return "name".equalsIgnoreCase(sortingOptions);
    }

    @Override
    public List<Student> sort(List<Student> students, int sortingType) {

        final Stream<Student> studentStream = students.stream().filter(Objects::nonNull);

        if (sortingType < 0) {

            return studentStream.sorted(Comparator.comparing(Student::getGradeBookNumber).reversed())
                    .collect(Collectors.toList());
        } else {

            return studentStream
                    .sorted(Comparator.comparing(Student::getGradeBookNumber))
                    .collect(Collectors.toList());
        }
    }
}
