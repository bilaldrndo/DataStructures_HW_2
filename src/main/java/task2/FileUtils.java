package task2;

import task1.Student;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtils {
    public static RedBlackTree<Integer, Student> readFile(String filePath) throws FileNotFoundException {
        RedBlackTree<Integer, Student> redBlackTree = new RedBlackTree<>();
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
            redBlackTree.put(studentId, student);
        }
        scanner.close();

        return redBlackTree;
    }
}
