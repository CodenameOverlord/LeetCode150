package SurroundedRegions;

public class Main {
    public void solve(char[][] board) {
        // top row i=0 perform dfs on all cells to T
        for(int j=0;j<board[0].length;++j){
            dfs(board, 0, j);
        }
        // bottom
        for(int j=0;j<board[0].length;++j){
            dfs(board, board.length-1, j);
        }
        //left
        for(int i=0;i<board.length;++i){
            dfs(board, i, 0);
        }
        //right
        for(int i=0;i<board.length;++i){
            dfs(board, i, board[0].length-1);
        }

        //replace all but T
        replace(board);
    }

    void dfs(char [][] board, int i, int j){
        if(i<0 || i>=board.length||j<0||j>=board[0].length)
            return;
        if(board[i][j]=='O'){
            board[i][j]= 'T';
            dfs(board, i-1,j);
            dfs(board,i+1, j);
            dfs(board, i,j+1);
            dfs(board, i,j-1);
        }
    }

    void replace (char [][] board){
        for (int i=0; i< board.length;++i){
            for(int j = 0; j< board[0].length;++j){
                if(board[i][j]=='T'){
                    board[i][j]= 'O';
                }
                else{
                    board[i][j]= 'X';
                }
            }
        }
    }
}
