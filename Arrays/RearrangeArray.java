package Arrays;

public class RearrangeArray {
    //Implement a function that rearranges elements in an array so that all negative elements appear to the left and all positive elements (including zero)
    //appear to the right. It’s important to note that maintaining the original sorted order of the input array is not required for this task.
    public static void main(String[] args) {
        int firstPosElementIndex = 0;
        int[] arr = new int[]{1,-2,3,-4,5};
        //{10, 4, 6, 23, 7},
        //            {-3, 20, -1, 8},
        //            {2, -5, -4, 43, 2},
        //            {-3, -10, -19, 21, -17},
        //            {25, 50, 75, 100, 400}

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != firstPosElementIndex) {
                    //swap numbers
                    int temp = arr[i];
                    arr[i] = arr[firstPosElementIndex];
                    arr[firstPosElementIndex] = temp;
                }
                firstPosElementIndex++;
            }
        }
    }
}
