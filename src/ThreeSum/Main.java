package ThreeSum;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> soln  = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i< nums.length; ++i){
            int currElement = nums[i];
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            addDistinctElementSol2Sum(nums, i, j, k, -1*currElement, soln);
        }

        return soln;
    }

    private static void addDistinctElementSol2Sum(int [] sortedArr, int currIndex, int startIndex, int endIndex, int target, List<List<Integer>> ansTillNow){
        int j = startIndex; int k = endIndex;
        while(j<k){
            int currentSum = sortedArr[j]+ sortedArr[k];
            if(currentSum==target){
                List<Integer> solList = new ArrayList<>();
                solList.add(sortedArr[currIndex]);
                solList.add(sortedArr[j]);
                solList.add(sortedArr[k]);
                ansTillNow.add(solList);
                while(j<k && sortedArr[j]==sortedArr[j+1]){
                    j++;
                }
                while(j<k && sortedArr[k]==sortedArr[k-1]){
                    k--;
                }
                j++;k--;
            }
            else if(currentSum> target){
                k--;
            }
            else{
                j++;
            }
        }

    }

}
