package homework.lessonTenth.taskOne;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        EnUaMap map = new EnUaMap();

        Translate translate = new Translate(map);

        map.addToMap("live", "жити");

        String pathToMap = "";
        try {
            pathToMap = SaveMap.save(map, "map.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(pathToMap + "\n");

        String textAsString = "";

        try {
            textAsString = translate.translate("English.in.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        * Path to the received translation
        * */
        System.out.println(textAsString);

        try {
            translate.saveText(textAsString, "Ukrainian.out.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
