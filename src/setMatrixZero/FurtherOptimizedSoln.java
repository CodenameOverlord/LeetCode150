package setMatrixZero;

public class FurtherOptimizedSoln {
    public void setZeroes(int[][] matrix) {
        boolean zeroRow = false; boolean zeroCol = false;
        for(int i =0; i< matrix.length; ++i){
            if(matrix[i][0]==0){
                zeroRow = true;
            }
        }
        for(int j =0; j< matrix[0].length; ++j){
            if(matrix[0][j]==0){
                zeroCol = true;
            }
        }
        for(int i = 0; i<matrix.length; ++i){
            for(int j = 0; j< matrix[0].length ; ++j){
                if(matrix[i][j]==0){
                    matrix[i][0] =0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i = 1; i< matrix.length; ++i){
            if(matrix[i][0]==0){
                for(int j=0; j< matrix[0].length; ++j){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j = 1; j< matrix[0].length ;++j){
            if(matrix[0][j]==0){
                for(int i =0; i< matrix.length; ++i){
                    matrix[i][j]=0;
                }
            }
        }
        if(zeroRow){
            for(int i =0; i< matrix.length; ++i)
                matrix[i][0]= 0;
        }
        if(zeroCol){
            for(int j =0; j< matrix[0].length; ++j)
                matrix[0][j]= 0;
        }
    }
}