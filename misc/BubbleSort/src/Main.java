import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class BubbleSort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BubbleSort selectionSort = new BubbleSort();
        int[] arr = new int[]{13, 46, 24, 52, 20, 9};
        selectionSort.sort(arr);

        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}