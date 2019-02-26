package homework.lessonFourth.taskFourth;

import homework.lessonFourth.taskFourth.exc.GroupIsEmptyException;
import homework.lessonFourth.taskFourth.exc.GroupOverflowException;
import homework.lessonFourth.taskFourth.logicalInterfaces.Sorting;
import homework.lessonFourth.taskFourth.logicalInterfaces.Voencom;
import homework.lessonFourth.taskFourth.sortType.*;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    public void addStudentToGroup(Student student) {

        int occupiedPlaces = 0;

        try {

            for (int i = 0; i < groupMembers.length; i++) {

                if (occupiedPlaces == 9) {

                    throw new GroupOverflowException();

                } else if (groupMembers[i] != null) {

                    occupiedPlaces++;

                } else {

                    groupMembers[i] = student;

                    System.out.println("Student added to group");

                    break;

                }
            }

        } catch (GroupOverflowException e) {

            System.out.println(e.getMessage());
        }

    }

    public void removeStudentFromGroup(Student student) {

        int freePlaces = 0;

        for (int i = 0; i < groupMembers.length; i++) {

            try {

                if (freePlaces == 9) throw new GroupIsEmptyException();

                if (groupMembers[i] == null) {

                    freePlaces++;

                } else {

                    if (groupMembers[i].getGradeBookNumber() == student.getGradeBookNumber()) {

                        groupMembers[i] = null;

                        System.out.println("Student removed from group");
                    }
                }
            } catch (GroupIsEmptyException e) {

                System.out.println(e.getMessage());
            }
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

    public void interactiveAddingStudent() {

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
                .orElseThrow(() ->new RuntimeException("This sorting option is not supported."))
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

        StringBuilder info = new StringBuilder();

        for (Student student : sortGroupByLastName(1)) {

            info.append(student.toString()).append("\n");
        }

        return info.toString();
    }
}
