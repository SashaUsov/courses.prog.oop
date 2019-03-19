package homework.lessonTenth.taskFourth;

public class Main {

    public static void main(String[] args) {

        /*
        * Pass the path to the style directory as a string.
        * */
        Art art = new Art("letters");

        /*
        * Pass the text
        * */
        System.out.println(art.makeArtText("aBc cba aa  cc b a c ba"));

    }
}
