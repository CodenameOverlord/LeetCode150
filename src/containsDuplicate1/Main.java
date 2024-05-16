package containsDuplicate1;

public class Main {
    public static void main(String[] args) {
        removeDuplicates(new int[] {1,1,1,2,2,2,4});
    }
    //clean solution
    public int removeDuplicatesClean(int[] nums) {
        int j = 0;
        for(int i = 0; i< nums.length; ++i){
            if(j<1 || nums[j-1]<nums[i]){
                nums[j++]= nums[i];
            }
        }
        return j;
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length==1 || nums.length == 0){
            return nums.length;
        }
        int i =0;
        int j = 1;
        int n = nums.length;
        boolean duplicate = false;
        while(j<nums.length){
            if(nums[i]== nums[j]){
                duplicate = true;
                while(j<n && nums[i]==nums[j]){
                    j++;
                }
                if(j<n){
                    i++;
                    nums[i]= nums[j];
                    j++;
                }
            }
            else{
                if(duplicate){
                    i++;
                    nums[i]= nums[j];j++;
                }
                else{
                    i++;j++;
                }
            }
        }

        return i+1;


    }
}
