package task1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StudentSearchV1 {

    private static void println(String text) {
        System.out.println(text);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            println("Loading the students...");
            Student[] students = FileUtils.readFile("/Users/bilaldrndo/Desktop/IBU/2nd_Year_2nd_Semester/DataStructs_Algos/Homeworks/Homework_2/Global_University_Students.csv");
            println("Sorting the student array...");
            MergeSort.sort(students);
            FileUtils.writeToFile(students, "/Users/bilaldrndo/Desktop/IBU/2nd_Year_2nd_Semester/DataStructs_Algos/Homeworks/Homework_2/Sorted_University_Students.csv");
            println("Saving the sorted file...");
            println("============================");
            println("System is ready");
            println("");

            int studentId;

            while(true) {
                println("Enter the ID of the student you want to retrieve, or -1 to exit: ");
                studentId = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (studentId == -1) {
                    println("Thank you for using the student search system.");
                    break;
                }

                int index = BinarySearch.search(students, studentId);
                if (index == -1) {
                    println("The student with the requested ID does not exist.");
                    println("The search was completed in " + BinarySearch.numSteps + " steps.");
                } else {
                    Student foundStudent = students[index];
                    println("Student ID: " + foundStudent.getStudentId());
                    println("Name and surname: " + foundStudent.getFullName());
                    println("Date of birth: " + foundStudent.getDateOfBirth());
                    println("University: " + foundStudent.getUniversityName());
                    println("Department code: " + foundStudent.getDepartmentCode());
                    println("Department: " + foundStudent.getDepartmentName());
                    println("Year of enrollment: " + foundStudent.getYearOfEnrollment());
                    println("");
                    println("The student was retrieved in " + BinarySearch.numSteps + " steps.");
                }

                BinarySearch.numSteps = 0;
            }
        } catch (FileNotFoundException e) {
            println("File not found: " + e.getMessage());
        } catch (IOException e) {
            println("Error occurred while writing to the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

