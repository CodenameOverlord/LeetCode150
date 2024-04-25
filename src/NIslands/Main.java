package NIslands;

public class Main {
    public static void main(String[] args) {
        char [][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int count = 0;
        int n = grid[0].length;
        for(int i =0; i<m; ++i ){
            for(int j = 0; j< n; ++j){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;

    }


    public static void dfs(char [] [] arr, int i, int j){
        // check valid i and j
        if(i>=0 && i<arr.length && j>=0 && j< arr[0].length)
            if(arr[i][j]=='1'){
                arr[i][j]='x';
                dfs(arr, i+1, j);
                dfs(arr, i-1, j);
                dfs(arr, i, j+1);
                dfs(arr, i, j-1);



            }



    }
}
