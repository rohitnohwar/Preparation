import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class MergeSort {
    private void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int tempInd = 0;

        int left = l;
        int right = mid + 1;

        while (left <= mid && right <= r) {
            if (arr[left] < arr[right]) {
                temp[tempInd] = arr[left];
                left++;
                tempInd++;
            }
            else {
                temp[tempInd] = arr[right];
                right++;
                tempInd++;
            }
        }

        while (left <= mid) {
            temp[tempInd] = arr[left];
            tempInd++;
            left++;
        }
        while (right <= r) {
            temp[tempInd] = arr[right];
            tempInd++;
            right++;
        }

        for (int i = l; i <= r; i++) {
            arr[i] = temp[i - l];
        }
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MergeSort selectionSort = new MergeSort();
        int[] arr = new int[]{13, 46, 24, 52, 20, 9};
        selectionSort.mergeSort(arr, 0 , arr.length - 1);

        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}