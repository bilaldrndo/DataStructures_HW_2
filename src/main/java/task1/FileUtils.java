package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static Student[] readFile(String filePath) throws FileNotFoundException {
        List<Student> students = new ArrayList<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            int studentId = Integer.parseInt(parts[0]);
            String fullName = parts[1];
            String dateOfBirth = parts[2];
            String universityName = parts[3];
            String departmentCode = parts[4];
            String departmentName = parts[5];
            int yearOfEnrollment = Integer.parseInt(parts[6]);

            Student student = new Student(
                    studentId,
                    fullName,
                    dateOfBirth,
                    universityName,
                    departmentCode,
                    departmentName,
                    yearOfEnrollment
            );
            students.add(student);
        }
        scanner.close();

        return students.toArray(new Student[0]);
    }

    public static void writeToFile(Student[] students, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);

        for (Student student : students) {
            writer.write(
                    student.getStudentId() + ";"
                    + student.getFullName() + ";"
                    + student.getDateOfBirth() + ";"
                    + student.getUniversityName() + ";"
                    + student.getDepartmentCode() + ";"
                    + student.getDepartmentName() + ";"
                    + student.getYearOfEnrollment() + "\n"
            );
        }

        writer.close();
    }
}
