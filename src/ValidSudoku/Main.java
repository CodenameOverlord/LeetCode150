package ValidSudoku;

public class Main {
    public static void main(String[] args) {
        ;
    }
    static boolean isValidSudoku(char[][] board) {
        return isValidAllRows(board) && isValidAllCols(board) && isValidAllSqs(board);
    }

    static boolean isValidAllRows(char[][] board){
        for(char [] c: board){
            if(!isValidRow(c))
                return false;
        }
        return true;
    }

    static boolean isValidRow(char c[]){
        boolean [] checkArr =  new boolean [10];
        for(Character x: c){
            if(x!='.'){
                if(checkArr[Integer.parseInt(x+"")])
                    return false;
                checkArr[Integer.parseInt(x+"")] = true;
            }
        }

        return true;
    }

    static boolean isValidAllCols(char[][] board){
        for(int i = 0; i< board[0].length; ++i){
            if(!isValidCol(board, i))
                return false;
        }
        return true;
    }

    static boolean isValidCol(char[][] board, int col){
        boolean [] checkArr =  new boolean [10];
        for(int i=0; i< board[col].length; ++i){
            char x = board[i][col];
            if(x!='.'){
                if(checkArr[Integer.parseInt(x+"")])
                    return false;
                checkArr[Integer.parseInt(x+"")] = true;
            }
        }

        return true;
    }

    static boolean isValidAllSqs(char[][] board){
        for(int i = 0; i<= board.length-3; i+=3){
            for(int j = 0; j<= board[0].length-3; j+=3){
                if(!isValidSq(board, i, j))
                    return false;
            }
        }

        return true;
    }

    static boolean isValidSq(char[][] board, int sI, int sJ){
        boolean [] checkArr =  new boolean [10];
        for(int i = sI; i< sI+3; ++i){
            for(int j = sJ; j< sJ+3; ++j){
                char x = board[i][j];
                if(x!='.'){
                    if(checkArr[Integer.parseInt(x+"")])
                        return false;
                    checkArr[Integer.parseInt(x+"")] = true;
                }
            }
        }

        return true;
    }

}
