package task1;

import java.util.Comparator;

public class MergeSort {

    public static void sort(Student[] students) {
        mergeSort(students, 0, students.length - 1);
    }

    private static void mergeSort(Student[] students, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(students, start, mid);
            mergeSort(students, mid + 1, end);
            merge(students, start, mid, end);
        }
    }

    private static void merge(Student[] students, int start, int mid, int end) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        Student[] leftArray = new Student[leftSize];
        Student[] rightArray = new Student[rightSize];

        for (int i = 0; i < leftSize; i++)
            leftArray[i] = students[start + i];

        for (int j = 0; j < rightSize; j++)
            rightArray[j] = students[mid + 1 + j];

        int i = 0, j = 0;
        int k = start;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                students[k] = leftArray[i];
                i++;
            } else {
                students[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            students[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            students[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
