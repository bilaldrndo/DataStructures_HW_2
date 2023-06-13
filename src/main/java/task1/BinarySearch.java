package task1;

public class BinarySearch {
    public static int numSteps = 0;

    public static int search(Student[] students, int key) {
        int left = 0;
        int right = students.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (students[mid].getStudentId() == key) {
                numSteps++;
                return mid;
            }

            if (students[mid].getStudentId() < key) {
                numSteps++;
                left = mid + 1;
            } else {
                numSteps++;
                right = mid - 1;
            }
        }

        return -1;
    }
}
