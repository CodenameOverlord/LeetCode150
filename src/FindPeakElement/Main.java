package FindPeakElement;

public class Main {
    public int findPeakElement(int[] nums) {
        int low  = 0;
        int high = nums.length-1;
        int n = nums.length-1;
        if(n==0){
            return n;
        }
        while(low<=high){
            long midL = (low+high)/2;
            int mid =  (int) midL;
            if((mid>0 && mid<n && nums[mid]> nums[mid-1] && nums[mid]>nums[mid+1] ) ||
                    (mid==0 && nums[mid]>nums[mid+1] || (mid==n && nums[mid]>nums[mid-1]) )){
                return mid;
            }
            if(nums[mid]<nums[mid+1]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}
