package homework.lessonFourth.taskFourth;

import homework.lessonFourth.taskFourth.exc.GroupIsEmptyException;
import homework.lessonFourth.taskFourth.exc.GroupOverflowException;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

public class Group implements Voencom{

    private Student[] groupMembers = new Student[10];

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

        Student newStudent = new Student();

        try {

            String name = JOptionPane.showInputDialog("Input student name");

            newStudent.setName(name);

            String lastName = JOptionPane.showInputDialog("Input student last name");

            newStudent.setLastName(lastName);

            String sex = JOptionPane.showInputDialog("Input student sex(male/female)");

            newStudent.setSex(sex);

            int age = Integer.parseInt(JOptionPane.showInputDialog("Input student age"));

            newStudent.setAge(age);

            int gradeBookNumber = Integer.parseInt(JOptionPane.showInputDialog("Input student grade book number"));

            newStudent.setGradeBookNumber(gradeBookNumber);

            double gradePointAverage = Double.parseDouble(JOptionPane.showInputDialog("Input student grade point average"));

            newStudent.setGradePointAverage(gradePointAverage);

            addStudentToGroup(newStudent);

        } catch (NumberFormatException e) {

            System.out.println("Data Entry Error");
        }
    }

    public Student[] sortGroupByLastName(int type) {

        final Stream<Student> studentStream = Arrays.stream(groupMembers).filter(Objects::nonNull);

        if (type < 0) {

            return studentStream.sorted(Comparator.comparing(Student::getLastName).reversed())
                    .toArray(Student[]::new);
        } else {

            return studentStream
                    .sorted(Comparator.comparing(Student::getLastName))
                    .toArray(Student[]::new);
        }

    }

    public Student[] userDefinedSorting(String sortingOptions, int type) {

        final Stream<Student> studentStream = Arrays.stream(groupMembers).filter(Objects::nonNull);

        if ("age".equalsIgnoreCase(sortingOptions.trim())) {

            if (type < 0) {

                return studentStream.sorted(Comparator.comparing(Student::getAge).reversed())
                        .toArray(Student[]::new);
            } else {

                return studentStream
                        .sorted(Comparator.comparing(Student::getAge))
                        .toArray(Student[]::new);
            }

        }
        if ("name".equalsIgnoreCase(sortingOptions.trim())) {

            if (type < 0) {

                return studentStream.sorted(Comparator.comparing(Student::getName).reversed())
                        .toArray(Student[]::new);
            } else {

                return studentStream
                        .sorted(Comparator.comparing(Student::getName))
                        .toArray(Student[]::new);
            }

        }
        if ("last name".equalsIgnoreCase(sortingOptions.trim())) {

            return sortGroupByLastName(type);
        }
        if ("grade book number".equalsIgnoreCase(sortingOptions.trim())) {

            if (type < 0) {

                return studentStream.sorted(Comparator.comparing(Student::getGradeBookNumber).reversed())
                        .toArray(Student[]::new);
            } else {

                return studentStream
                        .sorted(Comparator.comparing(Student::getGradeBookNumber))
                        .toArray(Student[]::new);
            }
        }
        if ("grade point average".equalsIgnoreCase(sortingOptions.trim())) {

            if (type < 0) {

                return studentStream.sorted(Comparator.comparing(Student::getGradePointAverage).reversed())
                        .toArray(Student[]::new);
            } else {

                return studentStream
                        .sorted(Comparator.comparing(Student::getGradePointAverage))
                        .toArray(Student[]::new);
            }

        }

        return null;
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
