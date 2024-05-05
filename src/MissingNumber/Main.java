package MissingNumber;

public class Main {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int [] {9,6,4,2,3,5,7,0,1}));
    }

    public static int missingNumber(int[] nums) {
        int [] arr = new int [nums.length+1];
        for(int i =0; i<nums.length; ++i){
            arr[nums[i]]=1;
        }

        for(int i =0; i< arr.length;++i){
            if(arr[i]==0)
                return i;
        }
        return -1;
    }
}
