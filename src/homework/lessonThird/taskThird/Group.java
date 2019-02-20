package homework.lessonThird.taskThird;

import homework.lessonThird.taskThird.exc.GroupIsEmptyException;
import homework.lessonThird.taskThird.exc.GroupOverflowException;
import homework.lessonThird.taskThird.exc.StudentNotFoundException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Group {

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

    public boolean addStudentToGroup(Student student) {

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

                    return true;

                }
            }

        } catch (GroupOverflowException e) {

            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean removeStudentFromGroup(Student student) {

        int freePlaces = 0;

        for (int i = 0; i < groupMembers.length; i++) {

            try {

                if (freePlaces == 9) throw new GroupIsEmptyException();

                if (groupMembers[i] == null) {

                    freePlaces++;

                } else {

                    if (groupMembers[i].getGradebookNumber() == student.getGradebookNumber()) {

                        groupMembers[i] = null;

                        System.out.println("Student removed from group");

                        return true;
                    }

                }

            } catch (GroupIsEmptyException e) {

                System.out.println(e.getMessage());
            }

        }

        return false;
    }

    public Student findStudentByLastName(String lastName) {

        for (Student student : groupMembers) {

            if (student != null) {

                if (lastName.equals(student.getLastName())) {

                    return student;

                }
            }

        }

        throw new StudentNotFoundException();

    }

    @Override
    public String toString() {

        final List<Student> collect = Arrays.stream(groupMembers).filter(Objects::nonNull)
                .sorted(Comparator.comparing(Student::getLastName))
                .collect(Collectors.toList());

        StringBuilder info = new StringBuilder();

        for (Student student : collect) {

            info.append(student.toString()).append("\n");
        }

        return info.toString();
    }
}
