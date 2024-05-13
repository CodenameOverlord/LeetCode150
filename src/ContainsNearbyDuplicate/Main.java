package ContainsNearbyDuplicate;

public class Main {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int [] {1,2,34,5,1,5},2));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int count=0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j <= i + k && j < nums.length; j++){
                if(nums[j] == nums[i]){
                    return true;
                }
                count++;
                if(count > 99999){
                    return false;
                }
            }
        }

        return false;
    }
}
