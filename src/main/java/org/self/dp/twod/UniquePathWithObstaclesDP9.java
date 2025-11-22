package org.self.dp.twod;

public class UniquePathWithObstaclesDP9 {

    public static void main(String[] args) {
        int[][] obs = new int[][]{{0,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(obs));
    }

    public static int uniquePathsWithObstacles(int[][] obs) {

        int M = obs.length;
        int N = obs[0].length;

        int[][] dp = new int[M][N];

        if(obs[0][0] == 1)
            return 0;
        else
            dp[0][0] = 1;

        //base case, 1st row
        boolean hasObs = false;
        for(int i=1; i<M; i++){
            if(obs[0][i] == 1)
                hasObs = true;

            if(hasObs == false)
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
        }

        hasObs = false;
        //basecase 1st column
        for(int j=1; j<N; j++){
            if(obs[j][0] == 1)
                hasObs = true;

            if(hasObs == false)
                dp[j][0] = 1;
            else
                dp[j][0] = 0;
        }

        //start at 1,1

        for(int i=1; i<M; i++){

            for(int j=1; j<N; j++){
                if(obs[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[M-1][N-1];
    }
}
