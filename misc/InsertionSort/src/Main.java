import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class InsertionSort {
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    j--;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        InsertionSort selectionSort = new InsertionSort();
        int[] arr = new int[]{13, 46, 24, 52, 20, 9};
        selectionSort.sort(arr);

        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}