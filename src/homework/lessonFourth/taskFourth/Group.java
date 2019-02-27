package homework.lessonFourth.taskFourth;

import homework.lessonFourth.taskFourth.exc.GroupIsEmptyException;
import homework.lessonFourth.taskFourth.exc.GroupOverflowException;
import homework.lessonFourth.taskFourth.exc.StudentNotFoundException;
import homework.lessonFourth.taskFourth.logicalInterfaces.Sorting;
import homework.lessonFourth.taskFourth.logicalInterfaces.Voencom;
import homework.lessonFourth.taskFourth.sortType.*;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Group implements Voencom {

    private Student[] groupMembers = new Student[10];

    private final Set<Sorting> sort = new HashSet<Sorting>() {{

        add(new AgeSort());
        add(new GradeBookNumberSort());
        add(new GradePointAverageSort());
        add(new LastNameSort());
        add(new NameSort());
    }};

    public Group(Student[] groupMembers) {
        this.groupMembers = groupMembers;
    }

    public Group() {
    }

    public Student[] getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(Student[] groupMembers) {
        this.groupMembers = groupMembers;
    }

    public void addStudentToGroup(Student student) throws GroupOverflowException {

        IntStream.range(0, groupMembers.length)
                .filter(idx -> groupMembers[idx] == null)
                .boxed()
                .findFirst()
                .map(idx -> groupMembers[idx] = student)
                .orElseThrow(GroupOverflowException::new);

        System.out.println("Student added to group");

    }

    public void removeStudentFromGroup(Student student) throws StudentNotFoundException, GroupIsEmptyException {

        if (Arrays.stream(groupMembers).filter(Objects::nonNull).count() != 0) {

            final Optional<Integer> found = IntStream.range(0, groupMembers.length)
                    .filter(idx -> groupMembers[idx] != null && groupMembers[idx].getGradeBookNumber() == student.getGradeBookNumber())
                    .boxed()
                    .findFirst();
            if (found.isPresent()) {
                groupMembers[found.get()] = null;
            } else {
                throw new StudentNotFoundException();
            }

            System.out.println("Student removed from group");
        } else {
            throw new GroupIsEmptyException();
        }
    }

    /*
    * If the search fails, throws an exception StudentNotFoundException extends RuntimeException
    * */
    public Student findStudentByLastName(String lastName) {

        for (Student student : groupMembers) {

            if (student != null) {

                if (lastName.equals(student.getLastName())) {

                    return student;

                }
            }

        }
        return null;
    }

    public void interactiveAddingStudent() throws GroupOverflowException {

        try {

            String name = JOptionPane.showInputDialog("Input student name");

            String lastName = JOptionPane.showInputDialog("Input student last name");

            String sex = JOptionPane.showInputDialog("Input student sex(male/female)");

            int age = Integer.parseInt(JOptionPane.showInputDialog("Input student age"));

            int gradeBookNumber = Integer.parseInt(JOptionPane.showInputDialog("Input student grade book number"));

            double gradePointAverage = Double.parseDouble(JOptionPane.showInputDialog("Input student grade point average"));

            addStudentToGroup(new Student(name, lastName, sex, age, gradeBookNumber, gradePointAverage));

        } catch (NumberFormatException e) {

            System.out.println("Data Entry Error");
        }
    }

    public Student[] sortGroupByLastName(int type) {

        return new LastNameSort().sort(groupMembers, type);

    }

    public Student[] userDefinedSorting(String sortingOptions, int type) {

        return sort.stream().filter(a -> a.accept(sortingOptions)).findFirst()
                .orElseThrow(() -> new RuntimeException("This sorting option is not supported."))
                .sort(groupMembers, type);

    }

    @Override
    public Student[] getRecruits() {

        return Arrays.stream(groupMembers).filter(Objects::nonNull)
                .filter(a -> "male".equals(a.getSex()) && a.getAge() > 18)
                .toArray(Student[]::new);
    }

    @Override
    public String toString() {
        return Arrays.stream(sortGroupByLastName(1))
                .map(Objects::toString)
                .collect(Collectors.joining("\n"));
    }
}
