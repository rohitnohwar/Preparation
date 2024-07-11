// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class QuickSort {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        
        int pivot = arr[low];
        
        while (i < j) {
            while (i <= j && arr[i] <= pivot) i++;
            while (j >= i && arr[j] > pivot) j--;
            
            if (i < j) swap(arr, i, j);
        }
        
        swap(arr, low, j);
        
        return j;
    }
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);

            quicksort(arr, low, partition - 1);
            quicksort(arr, partition + 1, high);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = { 13, 18, 27, 2, 19, 25 };
        QuickSort.quicksort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + ", ");
    }
}