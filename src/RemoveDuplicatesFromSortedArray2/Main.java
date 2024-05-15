package RemoveDuplicatesFromSortedArray2;

public class Main {
    public static void main(String[] args) {
        removeDuplicates(new int []{1,2,3,4,5,6,6,6});
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int i =0; int j = 1; int n = nums.length;
        int count=1; boolean arrFlag = false;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                if(count==2){
                    while(j<n && nums[i]==nums[j]){
                        j++;
                    }
                    if(j<n){
                        i++;
                        nums[i]= nums[j];
                        j++;
                        count=1;
                    }
                }
                else{
                    count++;
                    i++;
                    nums[i]=nums[j];
                    j++;
                }
            }else{
                i++;
                nums[i]=nums[j];
                j++;
                count=1;
            }
        }

        return i+1;
    }
}
