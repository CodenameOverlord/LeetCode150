package FindFirstAndLastPosOfElementInSortedArr;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int [] {5,7,7,8,8,10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int startPos = -1;
        int endPos = -1;
        if(nums.length>0){
            startPos = binarySearch("start", nums, target);
            if(startPos != -1){
                endPos = binarySearch("end", nums, target);
            }
        }
        int [] ans = new int [2];
        ans[0] = startPos;
        ans[1] = endPos;
        return ans;
    }

    static int binarySearch(String pos, int [] nums, int target){
        int end = nums.length-1;
        if(target>nums[end] || target<nums[0]){
            return -1;
        }
        switch(pos){
            case "start":
                return findStart(nums, target);
            case "end":
                return findEnd(nums, target);
            default: return -1;
        }

    }

    static int findStart(int [] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int targetStart = Integer.MAX_VALUE;
        while(start<=end){
            long midL = (start+end)/2;
            int mid = (int) midL;
            if(target == nums[mid]){
                targetStart = Math.min(targetStart, mid);
                end = mid-1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return  targetStart == Integer.MAX_VALUE? -1:  targetStart;
    }

    static int findEnd(int [] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int targetEnd = Integer.MIN_VALUE;
        while(start<=end){
            long midL = (start+end)/2;
            int mid = (int) midL;
            if(target == nums[mid]){
                targetEnd = Math.max(targetEnd, mid);
                start = mid+1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return targetEnd == Integer.MIN_VALUE?  -1:  targetEnd;
    }
}
