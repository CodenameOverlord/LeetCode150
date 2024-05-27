package InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int [] temp1 = new int []{1,3};
        int [] temp2 = new int []{6,9};
        int [] [] intervals = new int [2][2];
        intervals[0]= temp1;
        intervals[1] = temp2;
        System.out.println(Arrays.toString(insert(intervals, new int [] {2,5}))
        );
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> newIntervalList  = insertIntoInterval(intervals, newInterval);
        List<List<Integer>>solList =  mergeInterval(newIntervalList);
        return convertToArray(solList);
    }
    static int [][] convertToArray(List<List<Integer>> solList){
        int [] [] solArr = new int [solList.size()][2];
        for(int i =0; i< solList.size(); ++i){
            int [] temp = new int [2];
            temp[0]= solList.get(i).get(0);
            temp[1] = solList.get(i).get(1);
            solArr[i]= temp;
        }
        return solArr;
    }
    static List<List<Integer>> mergeInterval (List<List<Integer>> intervals){
        List<List<Integer>> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals.get(0));
        for(int i=1; i< intervals.size(); ++i){
            List<Integer> savedInterval = mergedIntervals.get(mergedIntervals.size()-1);
            List<Integer> currentInterval = intervals.get(i);
            compareAndAddToMergedInterval(savedInterval, currentInterval, mergedIntervals);
        }
        return mergedIntervals;
    }

    static void compareAndAddToMergedInterval(List<Integer> savedInterval,
                                       List<Integer>currInterval,
                                       List<List<Integer>> mergedIntervals){

        if(currInterval.get(1)<savedInterval.get(0) ||
                currInterval.get(0)>savedInterval.get(1)){
            mergedIntervals.add(currInterval);
        }
        else{
            List<Integer> temp = new ArrayList<>();
            temp.add(Math.min(currInterval.get(0), savedInterval.get(0)));
            temp.add(Math.max(currInterval.get(1), savedInterval.get(1)));
            mergedIntervals.remove(mergedIntervals.size()-1);
            mergedIntervals.add(temp);
        }
    }

    static List<List<Integer>> insertIntoInterval(int [][] intervals, int [] newInterval){
        boolean merged  = false;
        List<List<Integer>> includedList = new ArrayList<>();
        for(int i = 0; i< intervals.length; ++i){
            if(merged){
                List<Integer> temp = new ArrayList<>();
                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);
                includedList.add(temp);
            }
            else{
                if(intervals[i][0]<newInterval[0]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(intervals[i][0]);
                    temp.add(intervals[i][1]);
                    includedList.add(temp);
                }
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(newInterval[0]);
                    temp.add(newInterval[1]);
                    includedList.add(temp);
                    List<Integer> temp2 = new ArrayList<>();
                    temp2.add(intervals[i][0]);
                    temp2.add(intervals[i][1]);
                    includedList.add(temp2);
                    merged = true;
                }
            }
        }
        if(!merged){
            List<Integer> temp = new ArrayList<>();
            temp.add(newInterval[0]);
            temp.add(newInterval[1]);
            includedList.add(temp);
        }

        return includedList;
    }
}
