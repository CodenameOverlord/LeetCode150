package SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{1,23,24,25,90}));
    }

    public static List<String> summaryRanges(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        int last =nums[0];
        int first = nums[0];
        List<String> solList = new ArrayList<>();
        for(int i =1; i<nums.length; ++i){
            if(nums[i]==last+1){
                last = nums[i];
            }
            else{
                if(last == first){
                    solList.add(last+"");
                }
                else{
                    solList.add(first+"->"+ last);
                }
                first = nums[i]; last = nums[i];
            }
        }
        if(first==last){
            solList.add(first+"");
        }
        else{
            solList.add(first+"->"+last);
        }
        return solList;
    }
}
