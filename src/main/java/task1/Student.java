package task1;

//5069012;Lucy Dumas;17-01-1993;Global University of France;AM;Applied Mathematics;2018

public class Student implements Comparable<Student> {
    // implement the relevant student data attributes
    private int studentId;
    private String fullName;
    private String dateOfBirth;
    private String universityName;
    private String departmentCode;
    private String departmentName;
    private int yearOfEnrollment;

    public Student(int studentId, String fullName, String dateOfBirth, String universityName, String departmentCode, String departmentName, int yearOfEnrollment) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.universityName = universityName;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.yearOfEnrollment = yearOfEnrollment;
    }

    public int getStudentId() {return this.studentId;}
    public String getFullName() {return this.fullName;}
    public String getDateOfBirth() {return this.dateOfBirth;}
    public String getUniversityName() {return this.universityName;}
    public String getDepartmentCode() {return this.departmentCode;}
    public String getDepartmentName() {return this.departmentName;}
    public int getYearOfEnrollment() {return this.yearOfEnrollment;}

    @Override
    public int compareTo(Student o) {
        // implement the actual compareTo logic (remove next line)
        return Integer.compare(studentId, o.studentId);
//        return 0;
    }
}
