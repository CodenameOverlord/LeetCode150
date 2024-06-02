package RotateImage;

public class Main {

    public static void main(String[] args) {
        int matrix [][] = new int [4][4];
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = count; count++;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        rotate(matrix);
        System.out.println("\n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        System.out.println("");
        System.out.println("");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        reverseRows(matrix);
    }

    static void transposeMatrix(int [][] matrix){
        for(int i =0; i< matrix.length; ++i){
            for(int j = 0; j< i; ++j){
                int temp = matrix [i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    static void reverseRows(int [][] matrix){
        int n = matrix.length;
        for(int i =0; i< n; ++i){
            for(int j = 0; j< n/2; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
