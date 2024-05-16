package rotateArray;

import java.util.Arrays;

public class UsingReverseLogic {
    public static void main(String[] args) {
        rotate(new int []{1,2,3,4,5,6,7},3);
    }
    public static void rotate(int[] nums, int k) {
        k=k%nums.length;
        if(nums.length==1|| nums.length==0){
            return;
        }
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int [] a, int sI, int eI){
        while(sI<=eI){
            int temp = a[sI];
            a[sI]= a[eI];
            a[eI] = temp;
            sI++; eI--;
        }
    }
}
