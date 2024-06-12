package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Main {
    int dir; int top; int bottom; int left; int right; List<Integer> ans;
    public List<Integer> spiralOrder(int[][] matrix) {
        initialize(matrix);
        while(left<=right && top <= bottom){
            appendAns(matrix);
        }
        return ans;
    }
    void initialize(int [][] matrix){
        left = 0;
        right = matrix[0].length-1;
        dir = 0;
        bottom = matrix.length-1;
        top = 0;
        ans = new ArrayList<>();
    }

    void appendAns(int [][] m){
        switch(dir){
            case 0: { moveRight(m);
                top++;
                break;
            }
            case 1: {
                moveDown(m);
                right--;
                break;
            }
            case 2: {
                moveLeft(m);
                bottom--;
                break;
            }
            case 3: { moveUp(m);
                left++;
                break;
            }
        }
        dir+=1;dir%=4;
    }

    void moveRight(int [][] m){
        int j = left;
        for(;j<=right; ++j){
            ans.add(m[top][j]);
        }
    }
    void moveDown(int m [][]){
        int i = top;
        for(;i<=bottom;++i){
            ans.add(m[i][right]);
        }

    }
    void moveLeft(int m [][]){
        int j = right;
        for(;j>=left;--j){
            ans.add(m[bottom][j]);
        }
    }
    void moveUp(int m [][]){
        int i = bottom;
        for(;i>=top;--i){
            ans.add(m[i][left]);
        }
    }
}
