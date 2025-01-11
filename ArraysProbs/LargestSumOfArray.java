package ArraysProbs;

import java.util.Arrays;

public class LargestSumOfArray {
    public static int maxSumSubArr(int[] arr) {
        int currSum = arr[0];
        int globalSum = currSum;

        for (int i = 1; i < arr.length; i++) {
            if (currSum < 0) {
                currSum = arr[i];
            } else {
                currSum = currSum + arr[i];
            }
            if (globalSum < currSum) {
                globalSum = currSum;
            }
        }
        
        return globalSum;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 2, 3, 3, 1, 4},
                {2, 2, 1},
                {4, 1, 2, 1, 2},
                {-4, -1, -2, -1, -2},
                {-4, 2, -5, 1, 2, 3, 6, -5, 1},
                {25}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tArray: " + Arrays.toString(inputs[i]));
            System.out.println("\tMaximum Sum: " + maxSumSubArr(inputs[i]));
            System.out.println(new String(new char[75]).replace('\0', '-'));
        }
    }
}
