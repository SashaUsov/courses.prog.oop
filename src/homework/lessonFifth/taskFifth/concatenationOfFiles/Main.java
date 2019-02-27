package homework.lessonFifth.taskFifth.concatenationOfFiles;

public class Main {

    public static void main(String[] args) {

        String one = TextReader.readFromFile("TextOne.txt");

        String two = TextReader.readFromFile("TextTwo.txt");

        String resultText = TextConcat.concatText(one, two);

        TextWriter.writeToFile("TextFinal.txt", resultText);
    }
}
