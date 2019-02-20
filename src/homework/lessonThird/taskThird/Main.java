package homework.lessonThird.taskThird;

public class Main {

    public static void main(String[] args) {

        Student studentOne = new Student("Olga", "Golovko", 674587534, 4);

        Student studentThird = new Student("Sasha", "Kot", 876543, 4);

        Student studentFourth = new Student("Vera", "Vera", 987654534, 4);

        Student studentFifth = new Student("Nick", "Nick", 57575939, 4);

        Student studentSixth = new Student("Den", "Den", 895393598, 4);

        Student studentSeventh = new Student("Sem", "Sem", 8585983, 4);

        Student studentEighth = new Student("Stas", "Stas", 87654465, 4);

        Student studentNinth = new Student("Bob", "Bob", 347657575, 4);

        Student studentTenth = new Student("Igor", "Rogi", 23456789, 4);

        Student studentEleventh = new Student("Ivan", "Navi", 567890987, 4);

        Student studentTwo = new Student("Oleg", "Skripka", 45678999, 4.5);

        Group groupOne = new Group(new Student[]{studentOne, studentThird, studentFourth, studentFifth, studentSixth,

                                    studentSeventh, studentEighth, studentNinth, studentTenth, studentEleventh});

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
        System.out.println(groupOne.addStudentToGroup(studentTwo) + "\n");

        /*
        * Remove student from group by first match
        * */
        System.out.println(groupOne.removeStudentFromGroup(studentOne) + "\n");

        /*
        * Add new student to the group
        * */
        System.out.println(groupOne.addStudentToGroup(studentTwo) + "\n");

        /*
        * Remove student from group by first match
        * */
        System.out.println(groupOne.removeStudentFromGroup(studentTwo) + "\n");


       // System.out.println(groupOne.removeStudentFromGroup(studentTwo));

       /*
       * Trying to find a student who is not in the group.
       * Throw an exception StudentNotFoundException extends the class RuntimeException
       * */
//       System.out.println(groupOne.findStudentByLastName("Skripka"));

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
    }
}
