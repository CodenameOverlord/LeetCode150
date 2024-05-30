package setMatrixZero;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public void setZeroes(int[][] matrix) {
        List<Pair> zeroLoc  = findAllZeroes(matrix);
        setAllRowColZero(matrix, zeroLoc);
    }
    List<Pair> findAllZeroes(int [] [] matrix){
        ArrayList<Pair> resultList = new ArrayList<>();
        for(int i = 0; i< matrix.length; ++i){
            for(int j = 0; j< matrix[0].length; ++j){
                if(matrix[i][j]==0){
                    Pair p = new Pair(i, j);
                    resultList.add(p);
                }
            }
        }
        return resultList;
    }

    void setAllRowColZero(int [][] matrix, List<Pair>zeroLoc){
        for(int i = 0; i< zeroLoc.size();++i){
            Pair p = zeroLoc.get(i);
            int row = p.row;
            int col = p.col;
            setAllRowColZero(matrix, row, col);
        }
    }

    void setAllRowColZero(int [][] matrix,int row, int col) {
        //setting the current row = zero
        for (int i = 0; i < matrix[row].length; ++i) {
            matrix[row][i] = 0;
        }
        //setting all col zero
        for (int i = 0; i < matrix.length; ++i) {
            matrix[i][col] = 0;
        }
    }

}
