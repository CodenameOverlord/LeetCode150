package SearchA2DMatrix;

public class Main {
    class Pair{
        int key; boolean val;
        Pair(int key, boolean val){
            this.key = key;
            this.val = val;
        }
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target<matrix[0][0]|| target> matrix[matrix.length-1][matrix[0].length-1]){
            return false;
        }
        Pair colMap = findInCol(matrix, target);
        if(colMap.val==true){
            return true;
        }
        return findInRow(matrix[colMap.key], target);
    }

    boolean findInRow(int arr[], int target){
        int start = 0; int end = arr.length-1;
        if(arr[end]==target){
            return true;
        }
        while(start<=end){
            long midL = (start+end)/2;
            int mid = (int)midL;

            if(arr[mid]==target){
                return true;
            }
            if(arr[mid]<target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return false;
    }
    Pair findInCol(int [][] matrix, int target){
        Pair p = new Pair(-1, false);
        int end = matrix.length - 1;
        int start = 0;
        int currentAns = 0;

        while(start<=end){
            long midL = (start+end)/2;
            int mid = (int) midL;
            if(matrix[mid][0]==target){
                p.val = true;
                return p;
            }
            if(matrix[mid][0]<target){
                p.key = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return p;
    }

}
