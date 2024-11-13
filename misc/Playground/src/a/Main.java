package a;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void find(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int i: nums) {
            if (i != 0) {
                min = Math.min(min, i);
                set.add(i);
            }
//            System.out.println(min);
        }

        for (int i: nums) {
//            if (i != 0) {
//                System.out.println(i);
                if (i != 0 && i != min && !set.contains(i - diff)) {
                    System.out.println(i - diff);
                    break;
                }
//            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10,14,20,12,18,30,28,24,22,0,32,16,26};
        find(nums, 2);
//        [1, ......,  0, .......]
        // List of ints.
        // Rearrange in bell shape.
//        int[] nums = new int[]{1,10,15,5,3,9,22,18,17, 16,25,8};
//        int n = nums.length;
//        Arrays.sort(nums);
//
//        int[] res = new int[n];
//
//        for (int i = 0; i < n; i += 2) {
//            res[i] = nums[i / 2];
//            if (i + 1 < n) {
////                System.out.println(nums[i + 1]);
//                res[(n - (i/2) - 1)] = nums[i + 1];
//            }
//        }
//
//
//        for (int i = 0; i < n; i ++) {
//            System.out.print(res[i]+", ");
//        }

//        for ()
//
//        [1,10,15,5,3,9,22,18,17, 16,25,8]
//
//        [1, 3, 5, 8, 9, 10, 15, 16, 17, 18, 22, 25]
//
//        [1, 5                               8, 3]
    }
}


//[10,14,20,12,18,30,28,24,22,0,32,16,26]
//[0, 1, 3, 5, 7, 9, 13, 15]
//
n(n + 1) / 2




// [

