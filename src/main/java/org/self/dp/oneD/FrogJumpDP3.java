package org.self.dp.oneD;

import java.util.Arrays;

public class FrogJumpDP3 {

    public static void main(String[] args) {
        int[] arr = new int[]{10,20,30,10};
        int N = 4;
        System.out.println(frogJump(N, arr));//20


        arr = new int[]{30, 10, 60, 10, 60, 50};
        N = 6;
        System.out.println(frogJump(N, arr));//40

    }

    public static int frogJump(int N, int[] arr){
//        return frogJumpWithMemoization(N, arr);

//        return frogJumpWithTabulation(N, arr);

        return frogJumpWithSpaceOptimization(N, arr);
    }

    public static int frogJumpWithSpaceOptimization(int N, int[] arr){
        int dpMinus2 = 0;
        int dpMinus1 = Math.abs(arr[1] - arr[0]);

        for (int index = 2; index < N; index++) {

            int option1 = Math.abs(arr[index] - arr[index-1]) + dpMinus1;

            int option2 = Math.abs(arr[index] - arr[index-2]) + dpMinus2;

            int dpCurr = Math.min(option1, option2);

            dpMinus2 = dpMinus1;
            dpMinus1 = dpCurr;
        }

        return dpMinus1;
    }

    public static int frogJumpWithTabulation(int N, int[] arr){
        int[] dp = new int[N];
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);

        for (int index = 2; index < N; index++) {

            int option1 = Math.abs(arr[index] - arr[index-1]) + dp[index-1];
            int option2 = Math.abs(arr[index] - arr[index-2]) + dp[index-2];

            dp[index] = Math.min(option1, option2);
        }

        return dp[N-1];
    }

    public static int frogJumpWithMemoization(int N, int[] arr){
        int[] dp = new int[N];
        Arrays.fill(dp, -1);

        return solve(N-1, arr, dp);
    }

    public static int solve(int N, int[] arr, int[] dp){

        //base case
        if(N == 0)
            return 0;

        if(dp[N] != -1)
            return dp[N];

        //option 1
        int option1 = Integer.MAX_VALUE;
        if(N-1 >= 0)
            option1 = Math.abs(arr[N] - arr[N-1]) + solve(N-1, arr, dp);

        //option 2
        int option2 = Integer.MAX_VALUE;
        if(N-2 >= 0)
            option2 = Math.abs(arr[N] - arr[N-2]) + solve(N-2, arr, dp);

        return dp[N] = Math.min(option1, option2);
    }
}
