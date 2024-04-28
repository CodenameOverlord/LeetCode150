package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals) {
        List<int [] > solList = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->{return a[0]-b[0];});
        solList.add(intervals[0]);
        for(int i=1; i< intervals.length; i++){
            if(solList.get(solList.size()-1)[1]<intervals[i][0]){
                int [] newMerged = new int [2];
                newMerged[0]= Math.min(solList.get(solList.size()-1)[0], intervals[i][0]);
                newMerged[1] = Math.min(solList.get(solList.size()-1)[1], intervals[i][1]);
                solList.remove(solList.size()-1);
                solList.add(newMerged);
            }
            else{
                solList.add(intervals[i]);
            }
        }

        return (int[][]) solList.toArray();

    }
}
