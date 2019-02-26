package homework.lessonFourth.taskFourth;

import homework.lessonFourth.taskFourth.logicalInterfaces.Voencom;

public class Main {

    public static void main(String[] args) {

        Student studentOne = new Student("Olga", "Golovko", "female", 23,
                16483647, 4);

        Student studentThird = new Student("Sasha", "Kot", "male", 18,
                48593294, 4);

        Student studentFourth = new Student("Vera", "female","female", 21,
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

        Group groupOne = new Group(new Student[]{studentOne, studentThird, studentFourth, studentFifth, studentSixth,

                                    studentSeventh, studentTenth, studentEleventh});

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
        groupOne.addStudentToGroup(studentTwo);

        /*
        * Remove student from group by first match
        * */
        groupOne.removeStudentFromGroup(studentOne);

        /*
        * Add new student to the group
        * */
        groupOne.addStudentToGroup(studentTwo);

        /*
        * Remove student from group by first match
        * */
        groupOne.removeStudentFromGroup(studentFourth);

        Group groupTwo = new Group();

        /*
        * Throw GroupIsEmptyException extends Exception with message "No students in the group"
        * */
        groupTwo.removeStudentFromGroup(studentTwo);

        System.out.println();

        /*
        * Alphabetical student information
        * */
        System.out.println(groupOne.toString());

        System.out.println();

        /*
        * Get a list of young men suitable for military service
        * */
        Voencom smallArmy = groupOne;

        for (Student futureSoldier : smallArmy.getRecruits()) {

            System.out.println(futureSoldier);
        }

        System.out.println();

        /*
        * The method allows you to add a student to the group during runtime
        * */
        groupTwo.interactiveAddingStudent();

        System.out.println(groupTwo.toString());


        /*
        * Sort students by age in reverse order.
        * You can also sort the group by the "name",
        * "last name",
        * "grade book number" and
        * "grade point average".
        * To sort in reverse order, the type must match the number < 0
        * in natural order the type must match the number > 0
        * */
        for (Student futureSoldier : groupOne.userDefinedSorting("age", -1)) {

            System.out.println(futureSoldier);
        }

        System.out.println();

        /*
        * Sort students by age in natural order
        * */
        for (Student futureSoldier : groupOne.userDefinedSorting("age", 1)) {

            System.out.println(futureSoldier);
        }
    }
}
