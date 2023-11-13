import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class SelectionSort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int min = i;
            for (int j = i; j < arr.length ; j++) {
                if (arr[j] < arr[min]) min = j;
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = new int[]{13, 46, 24, 52, 20, 9};
        selectionSort.sort(arr);

        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}