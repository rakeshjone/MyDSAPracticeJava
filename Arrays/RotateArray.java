package Arrays;

public class RotateArray {
    //right rotate array
    public static void main(String[] args) {
        int[] nums = new int[]{10,20,30,40,50};
        int k = 3;

        if (nums.length == 0) {
            k=0;
        } else {
            k = k% nums.length; //effective rotation needed
        }

        int[] rotatedArr = new int[nums.length];
        System.arraycopy(nums,nums.length-k,rotatedArr,0,k);
        System.arraycopy(nums,0,rotatedArr,k,nums.length-k);

        for (int a : rotatedArr) {
            System.out.println(a);
        }
    }
}
