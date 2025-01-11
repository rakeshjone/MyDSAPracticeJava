package ArraysProbs;

public class RearrangeSoredArray {
    //We're given a sorted array, nums, containing positive integers only. We have to rearrange the array so that when returned, the
    // index of the array will have the largest number, the
    // index will have the smallest number, the
    // index will have the second largest number, the
    // index will have the second smallest number, and so on.
    //In the end, we’ll have the largest remaining numbers in descending order and the smallest in ascending order at even and odd positions, respectively.
    public static int[] rearrangeArray(int[] nums) {
        int[] newArr = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int i = 0;
        while(right>=left) {
            newArr[i] = nums[right];
            if(right>left) {
                i++;
            }
            newArr[i] = nums[left];
            if(right>left) {
                i++;
            }

            left++;
            right--;
        }
        // Replace this placeholder return statement with your code
        return newArr;
    }
}
