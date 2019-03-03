package homework.lessonFourth.taskFourth.dao;

import homework.lessonFourth.taskFourth.Group;
import homework.lessonFourth.taskFourth.Student;
import homework.lessonFourth.taskFourth.exc.GroupOverflowException;
import homework.lessonFourth.taskFourth.logicalInterfaces.GenericDao;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class GroupDAO implements GenericDao<String, Group> {

    @Override
    public String save(Group group, String targetLocation) throws IOException {
        int i = targetLocation.lastIndexOf(".");
        Path tempFile = Files.createTempFile(targetLocation.substring(0, i), targetLocation.substring(i));
        Student[] members = group.getGroupMembers();
        Set<Student> students = Arrays.stream(members).filter(Objects::nonNull).collect(Collectors.toSet());

        try (FileWriter f = new FileWriter(tempFile.toFile())) {
            writeStudents(f, students);
            return tempFile.toUri().getPath();
        }
    }

    private void writeStudents(FileWriter f, Set<Student> students) throws IOException {
        String delimiter = "";
        for (Student student : students) {
            f.write(delimiter);
            writeStudent(f, student);
            delimiter = "\n";
        }
    }

    private void writeStudent(FileWriter f, Student student) throws IOException {
        encodeAndWriteToFile(f,
                student.getName(),
                student.getLastName(),
                student.getSex(),
                student.getAge(),
                student.getGradeBookNumber(),
                student.getGradePointAverage());
    }

    private void encodeAndWriteToFile(FileWriter writer, Object... values) throws IOException {

        Base64.Encoder encoder = Base64.getEncoder();

        String delimiter = "";
        for (Object value : values) {
            writer.append(delimiter).append(encoder.encodeToString(value.toString().getBytes()));
            delimiter = " ";
        }
    }

    @Override
    public void read(Group group, String targetLocation) throws IOException, GroupOverflowException {
        String content = new String(Files.readAllBytes(Paths.get(targetLocation)), StandardCharsets.UTF_8);
        List<String> studentsGroup = Arrays.stream(content.split("\n")).collect(Collectors.toList());

        for (String studentData : studentsGroup) {
            group.addStudentToGroup(createStudent(studentData));
        }
    }

    private Student createStudent(String studentData) {
        String[] studentInfo = studentData.split(" ");

        return new Student(decodeString(studentInfo[0]),
                decodeString(studentInfo[1]),
                decodeString(studentInfo[2]),
                Integer.valueOf(decodeString(studentInfo[3])),
                Integer.valueOf(decodeString(studentInfo[4])),
                Double.parseDouble(decodeString(studentInfo[5])));
    }

    private String decodeString(String str) {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(str.getBytes()));
    }
}