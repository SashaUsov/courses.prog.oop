package homework.lessonTenth.taskFourth;

import java.io.*;
import java.util.*;

public class Art {

    private Map<Character, List<String>> font;
    private int fontHeight;

    public Art(String artStyleDirectory) {
        this.font = new TreeMap<>();
        createFontCatalog(artStyleDirectory);
        char x = 'a';
        fontHeight = font.get(x).size();
    }

    public String makeArtText(String text) {
        final char[] chars = text.toLowerCase().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < fontHeight; i++) {
            writeOneString(chars, stringBuilder, i);
        }
        return stringBuilder.toString();
    }

    private void createFontCatalog(String directory){
        File folder = new File(directory);
        File[] folderEntries = folder.listFiles();
        assert folderEntries != null;
        Arrays.stream(folderEntries)
                .forEach(x -> font.put(x.getName()
                        .replace(directory + "/", "").charAt(0), setFontStyle(x)));
    }

    private List<String> setFontStyle(File file) {
        List<String> letters = new ArrayList<>();
        String str;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((str = br.readLine()) != null) {
                    letters.add(str.replace("\n", ""));
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return letters;
    }

    public Map<Character, List<String>> getFont() {
        return font;
    }

    private void writeOneString(char[] chars, StringBuilder stringBuilder, int i) {
        for (int k = 0; k < chars.length; k++) {
            writeString(chars[k], stringBuilder, i);
        }
        stringBuilder.append("\n");
    }

    private void writeString(char aChar, StringBuilder stringBuilder, int i) {
        if (font.containsKey(aChar)) {
            List<String> strings = font.get(aChar);
            final String[] toArray = strings.stream().toArray(String[]::new);
            stringBuilder.append(toArray[i]).append(" ");
        } else {
            stringBuilder.append(aChar);
        }
    }

}
