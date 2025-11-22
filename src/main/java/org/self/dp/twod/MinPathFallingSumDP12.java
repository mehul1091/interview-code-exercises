package org.self.dp.twod;

public class MinPathFallingSumDP12 {

    public static void main(String[] args) {
        int[][] obs = new int[][]{{2,1,3},{6,5,4}, {7,8,9}};
        System.out.println(minFallingPathSum(obs));
    }

    public static int minFallingPathSum(int[][] matrix) {

        int N = matrix.length;

        int min = Integer.MAX_VALUE;
        for (int coli = 0; coli < N; coli++) {
            min = Math.min(solve(0, coli, matrix, N), min);
        }

        return min;
    }

    public static int solve(int row, int col, int[][] matrix, int N){
        //basecase
        if(row>N || col<0 || col>=N)
            return Integer.MAX_VALUE;

        if(row==N)
            return 0;

            int op1 = solve(row+1, col, matrix, N);

            int op2 = solve(row+1, col-1, matrix, N);

            int op3 = solve(row+1, col+1, matrix, N);

            return matrix[row][col] + Math.min(op1, Math.min(op2, op3));

    }
}
