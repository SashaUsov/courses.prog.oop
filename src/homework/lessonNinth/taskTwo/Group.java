package homework.lessonNinth.taskTwo;

import homework.lessonNinth.taskTwo.exc.GroupIsEmptyException;
import homework.lessonNinth.taskTwo.exc.GroupOverflowException;
import homework.lessonNinth.taskTwo.exc.StudentNotFoundException;
import homework.lessonNinth.taskTwo.logicalInterfaces.Sorting;
import homework.lessonNinth.taskTwo.logicalInterfaces.Voencom;
import homework.lessonNinth.taskTwo.sortType.*;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Group implements Voencom {

    private List<Student> groupMembers = new ArrayList<>();

    private final Set<Sorting> sort = new HashSet<Sorting>() {{

        add(new AgeSort());
        add(new GradeBookNumberSort());
        add(new GradePointAverageSort());
        add(new LastNameSort());
        add(new NameSort());
    }};

    public Group(List<Student> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public Group() {
    }

    public List<Student> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<Student> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public void addStudentToGroup(Student student) throws GroupOverflowException {

        if (groupMembers.size() >= 10) {
            throw new GroupOverflowException();
        } else {
            IntStream.range(0, groupMembers.size())
                    .filter(idx -> groupMembers.get(idx) == null)
                    .boxed()
                    .findFirst()
                    .map(idx -> groupMembers.set(idx, student));

            System.out.println("Student added to group");
        }
    }

    public void removeStudentFromGroup(Student student) throws StudentNotFoundException, GroupIsEmptyException {

        if (groupMembers.stream().filter(Objects::nonNull).count() != 0) {

            final Optional<Integer> found = IntStream.range(0, groupMembers.size())
                    .filter(idx -> groupMembers.get(idx) != null && Objects.equals(groupMembers.get(idx).getGradeBookNumber(), student.getGradeBookNumber()))
                    .boxed()
                    .findFirst();
            if (found.isPresent()) {
                groupMembers.set(found.get(), null);
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

    public List<Student> sortGroupByLastName(int type) {

        return new LastNameSort().sort(groupMembers, type);

    }

    public List<Student> userDefinedSorting(String sortingOptions, int type) {

        return sort.stream().filter(a -> a.accept(sortingOptions)).findFirst()
                .orElseThrow(() -> new RuntimeException("This sorting option is not supported."))
                .sort(groupMembers, type);

    }

    @Override
    public List<Student> getRecruits() {

        return groupMembers.stream().filter(Objects::nonNull)
                .filter(a -> "male".equals(a.getSex()) && a.getAge() > 18)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return sortGroupByLastName(1).stream()
                .map(Objects::toString)
                .collect(Collectors.joining("\n"));
    }
}
