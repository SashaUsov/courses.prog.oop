package homework.lessonFifth;

import java.io.*;

public class TextHelper {

    public static String readFromFile(File in) throws IOException {

        String result = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(in))){

            String temp = "";

            for(;(temp = reader.readLine())!=null;) {

                result += temp + System.lineSeparator();
            }
            return result;
        }

    }

    public static int countLetter(String text, char letter) {

        int count = 0;

        char[] letters = text.toCharArray();

        for (int i =0; i < letters.length; i++) {

            count+=1;
        }
        return count;
    }

//    public static String getStat(String text) {
//
//        String result = "";
//
//        text = text.toLowerCase();
//
//        for (char letter = 'a'; letter <= 'z'; letter++){
//
//        }
//    }
}
