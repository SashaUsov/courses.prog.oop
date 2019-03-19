package homework.lessonTenth.taskOne;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Translate {

    private EnUaMap map;

    public Translate(EnUaMap map) {
        this.map = map;
    }

    private String getTextAsString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
    }

    private String withoutSymbol(String str) {
        return str.replaceAll("[0-9^\\W]+", "");
    }

    public String translate(String path) throws IOException {
        String str = getTextAsString(path);
        String[] strings = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        replaceEnUa(strings, stringBuilder);
        return stringBuilder.toString();
    }

    private void replaceEnUa(String[] strings, StringBuilder stringBuilder) {
        for (String s : strings) {
            if (withoutSymbol(s).length() > 0) {
                ifStringHasLetters(stringBuilder, s);
            } else {
                stringBuilder.append(s).append(" ");
            }
        }
    }

    private void ifStringHasLetters(StringBuilder stringBuilder, String s) {
        String clearWord = withoutSymbol(s);
        String toSearch = clearWord.trim().toLowerCase();
        Map<String, String> enUa = map.getEnUa();
        if (s.contains("\n")) {
            ifWordContainsLineBreak(stringBuilder, s);
        } else if (enUa.containsKey(toSearch)) {
            ifPresentInMap(stringBuilder, s, clearWord, toSearch, enUa);
        } else {
            stringBuilder.append(s).append(" ");
        }
    }

    private void ifWordContainsLineBreak(StringBuilder stringBuilder, String s) {
        final String s1 = containsALineBreak(s);
        stringBuilder.append(s1).append(" ");
    }

    private void ifPresentInMap(StringBuilder stringBuilder, String s,
                                String clearWord, String toSearch,
                                Map<String, String> enUa) {
        String ua;
        ua = enUa.get(toSearch);
        String replace = s.replace(clearWord, ua);

        stringBuilder.append(replace).append(" ");
    }

    private String containsALineBreak(String str) {
        String[] split = str.split("\n");
        String repl = str;
        for (String s : split) {
            String s1 = withoutSymbol(s);
            if (map.getEnUa().containsKey(s1.toLowerCase())) {
                repl = str.replace(s1, map.getEnUa().get(s1.toLowerCase()));
            }
        }
        return repl;
    }

    public void saveText(String text, String path) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(new FileOutputStream(path))) {
            out.print(text);
        }
    }
}
