package org.self.dp.twod;

public class MinPathSumDP10 {

    public static void main(String[] args) {
        int[][] obs = new int[][]{{1,3,1},{1,5,1}, {4,2,1}};
        System.out.println(minPathSum(obs));
    }

    public static int minPathSum(int[][] grid) {

        int M = grid.length;
        int N = grid[0].length;

        int[][] dp = new int[M+1][N+1];

        dp[0][0] = grid[0][0];

        for(int i=1; i<M+1; i++){

            for(int j=1; j<N+1; j++){

                dp[i][j] = grid[i-1][j-1] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[M][N];
    }
}
