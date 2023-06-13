package task2;

import task1.BinarySearch;
import task1.Student;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentSearchV2 {

    private static void println(String text) {
        System.out.println(text);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            RedBlackTree<Integer, Student> redBlackTree = FileUtils.readFile("/Users/bilaldrndo/Desktop/IBU/2nd_Year_2nd_Semester/DataStructs_Algos/Homeworks/Homework_2/Global_University_Students.csv");

            System.out.println("Tree was built with with " + redBlackTree.countRedLinks() + " red links.");
            println("============================");
            println("System is ready");
            println("");

            int studentId;

            while(true) {
                println("Enter the ID of the student you want to retrieve, or -1 to exit: ");
                studentId = scanner.nextInt();
                scanner.nextLine();

                if (studentId == -1) {
                    println("Thank you for using the student search system.");
                    break;
                }

                Student student = redBlackTree.get(studentId);
                if (student == null) {
                    println("The student with the requested ID does not exist.");
                    println("The search was completed in " + BinarySearch.numSteps + " steps.");
                } else {
                    System.out.println("Student ID: " + student.getStudentId());
                    System.out.println("Name and surname: " + student.getFullName());
                    System.out.println("Date of birth: " + student.getDateOfBirth());
                    System.out.println("University: " + student.getUniversityName());
                    System.out.println("Department code: " + student.getDepartmentCode());
                    System.out.println("Department: " + student.getDepartmentName());
                    System.out.println("Year of enrollment: " + student.getYearOfEnrollment());
                    println("");
                    println("The student was retrieved in " + redBlackTree.numSteps + " steps.");
                }

                redBlackTree.numSteps = 0;
            }
        } catch (FileNotFoundException e) {
            println("File not found: " + e.getMessage());
        }
    }
}
