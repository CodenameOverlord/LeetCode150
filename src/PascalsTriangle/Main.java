package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> solList= generate(
                10
        );

        for(List<Integer> l: solList){
            l.forEach(t-> System.out.print(t+"-"));
            System.out.println();
        }

    }


    public static List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> soln = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        soln.add(first);
        for(int i =1; i<n; ++i){
            List<Integer> past = soln.get(i-1);
            List<Integer> present = new ArrayList<>();
            present.add(1);
            int j = 0; int k = 1;
            while(k<past.size()){
                present.add(past.get(j)+past.get(k));
                j++;k++;
            }
            present.add(1);
            soln.add(present);
        }
        return soln;
    }
}
