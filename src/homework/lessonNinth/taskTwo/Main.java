package homework.lessonNinth.taskTwo;

import homework.lessonNinth.taskTwo.exc.GroupIsEmptyException;
import homework.lessonNinth.taskTwo.exc.GroupOverflowException;
import homework.lessonNinth.taskTwo.exc.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Student studentOne = new Student("Olga", "Golovko", "female", 23,
                16483647, 4);

        Student studentThird = new Student("Sasha", "Kot", "male", 18,
                48593294, 4);

        Student studentFourth = new Student("Vera", "Vera","female", 21,
                23057493, 4);

        Student studentFifth = new Student("Nick", "Nick", "male", 17,
                18439045, 4);

        Student studentSixth = new Student("Den", "Den", "male", 20,
                30573748, 4);

        Student studentSeventh = new Student("Sem", "Sem", "male", 19,
                28453709, 4);


        Student studentTenth = new Student("Igor", "Rogi", "male", 22,
                12345678, 4);

        Student studentEleventh = new Student("Ivan", "Navi", "male",17,
                87654321, 4);

        Student studentTwo = new Student("Oleg", "Skripka", "male", 20,
                24680864, 4.5);

        List<Student> students = new ArrayList<>();

        students.add(studentOne);
        students.add(studentThird);
        students.add(studentFourth);
        students.add(studentFifth);
        students.add(studentSixth);
        students.add(studentSeventh);
        students.add(studentTenth);
        students.add(studentEleventh);

        Group groupOne = new Group(students);

        /*
        * Alphabetical student information
        * */
        System.out.println(groupOne.toString());

        System.out.println();

        /*
        * Get student type object by first match last name
        * */
        System.out.println(groupOne.findStudentByLastName("Golovko") + "\n");

        /*
        * Add the eleventh student to the group
        * GroupOverflowException extends Exception
        * */
        try {
            groupOne.addStudentToGroup(studentTwo);
        } catch (GroupOverflowException e) {
            System.out.println(e.getMessage());
        }

        /*
        * Remove student from group by first match
        * */
        try {
            groupOne.removeStudentFromGroup(studentOne);
        } catch (StudentNotFoundException | GroupIsEmptyException e) {
            System.out.println(e.getMessage());
        }

        /*
        * Add new student to the group
        * */
        try {
            groupOne.addStudentToGroup(studentTwo);
        } catch (GroupOverflowException e) {
            System.out.println(e.getMessage());
        }

        /*
        * Remove student from group by first match
        * */
        try {
            groupOne.removeStudentFromGroup(studentTwo);
        } catch (StudentNotFoundException | GroupIsEmptyException e) {
            System.out.println(e.getMessage());
        }

        Group groupTwo = new Group();

        /*
        * Throw GroupIsEmptyException extends Exception with message "No students in the group"
        * */
        try {
            groupTwo.removeStudentFromGroup(studentTwo);
        } catch (StudentNotFoundException | GroupIsEmptyException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        /*
        * Alphabetical student information by lastName
        * */
        System.out.println(groupOne.toString());
    }
}
