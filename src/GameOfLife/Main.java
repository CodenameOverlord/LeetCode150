package GameOfLife;

public class Main {
    public void gameOfLife(int[][] board) {
        int [][] newBoard = new int [board.length][board[0].length];
        for(int i =0; i< board.length; i++){
            for(int j =0; j<board[0].length; ++j){
                if(formulateLogic(board, i, j))
                    newBoard[i][j] = 1;
            }
        }
        for(int i =0; i< board.length; i++){
            for(int j =0; j<board[0].length; ++j){
                board[i][j] = newBoard[i][j];
            }
        }
    }

    boolean formulateLogic(int [][]board, int i, int j){
        int ans = calculate(board, i,j);
        if(board[i][j]==1){
            if(ans==2|| ans ==3){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(ans==3){
                return true;
            }
            else{
                return false;
            }
        }

    }

    int calculate(int [][] board, int i, int j){
        int ans = 0; int n = board.length; int m = board[0].length;
        if(i<n-1 && j<m-1)
            ans+=board[i+1][j+1];
        if(i<n-1)
            ans+=board[i+1][j];
        if(i<n-1 && j>0)
            ans+=board[i+1][j-1];
        if(i>0 && j>0)
            ans+=board[i-1][j-1];
        if(i>0)
            ans+=board[i-1][j];
        if(i>0 && j<m-1)
            ans+=board[i-1][j+1];
        if(j<m-1)
            ans+=board[i][j+1];
        if(j>0)
            ans+=board[i][j-1];

        return ans;
    }
}
