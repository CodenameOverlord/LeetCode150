package setMatrixZero;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OptimizedSoln {
    public static void main(String[] args) {
        int [][] matrix = new int [3][3];
        for(int i =0; i< matrix.length; ++i){
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j]=1;
            }
        }

        matrix [1][1] = 0;
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix) {
        Map<String, Set<Integer>> zeroRowCol = getZeroes(matrix);
        Set <Integer> allRows = zeroRowCol.get("rows");
        Set <Integer> allCols = zeroRowCol.get("cols");
        setRowsZero(matrix, allRows);
        setColsZero(matrix, allCols);
    }

    static void setRowsZero(int[][] matrix, Set<Integer> rows){
        for(int row: rows){
            for(int i = 0; i< matrix[0].length; ++i){
                matrix[row][i]=0;
            }
        }
    }

    static void setColsZero(int[][] matrix, Set<Integer> cols){
        for(int col: cols){
            for(int i = 0; i< matrix.length; ++i){
                matrix[i][col]=0;
            }
        }
    }

    static Map<String, Set<Integer>> getZeroes(int[][] matrix){
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        Map<String, Set<Integer>> hMap = new HashMap<>();
        hMap.put("rows", rows);
        hMap.put("cols", cols);
        for(int i =0; i<matrix.length; ++i){
            for(int j = 0; j<matrix[0].length; ++j){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        return hMap;
    }
}
