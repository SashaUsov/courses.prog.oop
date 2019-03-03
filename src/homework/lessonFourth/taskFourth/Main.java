package homework.lessonFourth.taskFourth;

import homework.lessonFourth.taskFourth.dao.GroupDAO;
import homework.lessonFourth.taskFourth.exc.GroupOverflowException;
import homework.lessonFourth.taskFourth.logicalInterfaces.GenericDao;

import java.io.IOException;

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

        Group groupOne = new Group(new Student[]{studentOne, studentThird, studentFourth, studentFifth, studentSixth,

                                    studentSeventh, studentTenth, studentEleventh});

        GenericDao<String, Group> dao = new GroupDAO();

        String location = "";

        try {
            /*
            * Saves the group to a file and returns the path to the file.
            * */
            location = dao.save(groupOne, "Group.txt");
            System.out.println(location);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Group groupCopy = new Group();

        try {
            /*
            * Fills a group with students from a saved file.
            * */
            dao.read(groupCopy, location);
        } catch (IOException | GroupOverflowException e) {
            e.printStackTrace();
        }

        System.out.println(groupCopy.toString());
    }
}
