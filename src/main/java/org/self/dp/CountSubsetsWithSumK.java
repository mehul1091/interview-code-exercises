package org.self.dp;

import java.util.Arrays;

public class CountSubsetsWithSumK {

    public static void main(String[] args) {

        int[] arr = new int[] {0,1,3};
        int result = findWays(arr, 4);
        System.out.println(result);
    }

    public static int findWays(int num[], int tar) {
        int n = num.length;
        //0-->n-1 * 0 ---> target
        int[][] dp = new int[n][tar+1];
        Arrays
                .stream(dp)
                .forEach(row -> Arrays.fill(row, -1));

        return solve(n-1, tar, num, dp);
    }

    //memoization
    public static int solve(int curr, int target, int[] arr, int[][] dp){

        if(target < 0 || curr < 0){
            return 0;
        }

        if(arr[curr] == 0){
            return 2;
        }

        //base case
        if(target == 0){
            return 1;
        }
        //base case
        if(curr == 0){
            return arr[0] == target ? 1 : 0;
        }

        if(dp[curr][target] != -1){
            return dp[curr][target];
        }

        //not pick
        int notpick = solve(curr-1, target, arr, dp);

        //pick
        int pick = 0;
        if(target - arr[curr] >= 0){
            pick = solve(curr-1, target-arr[curr], arr, dp);
        }

        return dp[curr][target] = notpick + pick;
    }

    //recursion
    public static int solveWithRecursion(int curr, int target, int[] arr){

        //base case
        if(target == 0){
            return 1;
        }
        //base case
        if(curr == 0){
            return arr[0] == target ? 1 : 0;
        }

        if(target < 0 || curr < 0){
            return 0;
        }

        //not pick
        int notpick = solveWithRecursion(curr-1, target, arr);

        //pick
        int pick = solveWithRecursion(curr-1, target-arr[curr], arr);

        return notpick + pick;
    }
}
