package rotateArray;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
    }


    public static int [] rotate(int[] nums, int k) {
        int n = nums.length;
        int [] temp = new int [n];
        for(int i =0; i< n; ++i){
            temp[(i+k)%n]= nums[i];
        }

        for(int i = 0; i<n; ++i){
            nums [i] = temp [i];
        }

        return nums;
    }
}
