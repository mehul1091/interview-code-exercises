package org.self.dp.subsets;

import java.util.Arrays;

public class Knapsack01DP19 {
    public static void main(String[] args) {

/*
        Assertions are disabled by default.
        To enable:

        Command-line
        java -ea YourClassName

        OR

        Add JVM argument to enable assertions
        -ea
        (or -enableassertions, both work)
*/

        long startTime = System.nanoTime();

        // Testcase 1: classic knapsack sample
        {
            int bagCapacity = 10; int n = 4;
            int[] weights = new int[]{5,4,6,3};
            int[] values = new int[]{10,40,30,50};
            int result = knapsack01(weights, values, bagCapacity, n);
            assert result == 90 : "Testcase 1 failed: expected 90, got " + result;
        }

// Testcase 2: capacity exactly matches a single item
        {
            int bagCapacity = 3; int n = 3;
            int[] weights = new int[]{3,4,5};
            int[] values = new int[]{30,40,50};
            int result = knapsack01(weights, values, bagCapacity, n);
            assert result == 30 : "Testcase 2 failed: expected 30, got " + result;
        }

// Testcase 3: capacity allows combination picking
        {
            int bagCapacity = 7; int n = 4;
            int[] weights = new int[]{1,4,3,5};
            int[] values  = new int[]{15,30,20,50};
            int result = knapsack01(weights, values, bagCapacity, n);
            assert result == 65 : "Testcase 3 failed: expected 65, got " + result;

        }

// Testcase 4: choose multiple small items over one big expensive item
        {
            int bagCapacity = 8; int n = 4;
            int[] weights = new int[]{2,3,4,5};
            int[] values  = new int[]{20,30,60,80};
            int result = knapsack01(weights, values, bagCapacity, n);
            assert result == 110 : "Testcase 4 failed: expected 110, got " + result;
        }

// Testcase 5: zero capacity = zero value
        {
            int bagCapacity = 0; int n = 3;
            int[] weights = new int[]{2,3,4};
            int[] values  = new int[]{20,30,40};
            int result = knapsack01(weights, values, bagCapacity, n);
            assert result == 0 : "Testcase 5 failed: expected 0, got " + result;
        }

// Testcase 6: no item fits
        {
            int bagCapacity = 1; int n = 3;
            int[] weights = new int[]{2,3,4};
            int[] values  = new int[]{20,30,40};
            int result = knapsack01(weights, values, bagCapacity, n);
            assert result == 0 : "Testcase 6 failed: expected 0, got " + result;
        }

// Testcase 7: all items fit – pick everything
        {
            int bagCapacity = 15; int n = 4;
            int[] weights = new int[]{2,3,4,5};
            int[] values  = new int[]{10,20,30,40};
            int result = knapsack01(weights, values, bagCapacity, n);
            assert result == 100 : "Testcase 7 failed: expected 100, got " + result;
        }

// Testcase 8: tricky case – item with high weight but low value
        {
            int bagCapacity = 10; int n = 4;
            int[] weights = new int[]{9,5,4,3};
            int[] values  = new int[]{8,20,30,50};
            int result = knapsack01(weights, values, bagCapacity, n);
            assert result == 80 : "Testcase 8 failed: expected 80, got " + result;
        }

        System.out.println("All testcases passed!");
        long endTime = System.nanoTime();
        System.out.println("total runtime in nano seconds: " + (endTime - startTime));

    }

    public static int knapsack01(int[] weights, int[] values, int bagCapacity, int n){


        int[][] dp = new int[n][bagCapacity+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

//        return solveMemoization(n-1, bagCapacity, weights, values, dp);

//                return solveRecursion(n-1, bagCapacity, weights, values);

        return solveTabulation(weights, values, bagCapacity, n);

    }

    //using tabulation
    public static int solveTabulation(int[] weights, int[] values, int bagCapacity, int n){

        System.out.println("solving using tabulation");
        int[][] dp = new int[n][bagCapacity+1];

        //fill dp where bagCapacity = 0
        for(int i=0; i<n; i++){
            dp[i][0] = 0;
        }

        //fill dp, for 1st element
        for(int b=1; b<bagCapacity+1; b++){

            if(weights[0] <= b){
                dp[0][b] = values[0];
            }
        }

        //start from 1,1
        for(int index=1; index<n; index++){

            for(int capacityLeft = 1; capacityLeft<bagCapacity+1; capacityLeft++){

                int notpick = 0 + dp[index-1][capacityLeft];

//                int pick = Integer.MIN_VALUE;
                //This is dangerous because:
                //values[index] + dp[..]
                //can overflow and wrap around to a large positive number!

                //better: use -1e9 or -10^9 (safe sentinel)
                int pick = (int) -1e9;

                if(capacityLeft - weights[index] >= 0)
                    pick = values[index] + dp[index-1][capacityLeft - weights[index]];

                dp[index][capacityLeft] = Math.max(notpick, pick);
            }
        }

        return dp[n-1][bagCapacity];
    }

    //using memoization
    public static int solveMemoization(int index, int weightLeft, int[] weights, int[] values, int[][] dp){

        //base case
        //→ no items left → valid, contributes 0.
        if(index < 0)
            return 0;

        //invalid overweight → kill this path
        if(weightLeft < 0)
            return Integer.MIN_VALUE;

        //take only 1 element as example and calculate
        //You forgot to store the result in dp for index==0
        //This means you're missing ~bagCapacity + 1 entries of caching.
//        if(index == 0){
//            if(weightLeft >= weights[index])
//                return values[0];
//            else
//                return 0;
//        }

        //corrected code
        if(index == 0){
            if(weightLeft >= weights[index])
                return dp[index][weightLeft] = values[0]; // single item picked
            else
                return dp[index][weightLeft] = 0; // single item not picked
        }

        if(dp[index][weightLeft] != -1)
            return dp[index][weightLeft];

        //notpick
        int notpick = 0 + solveMemoization(index-1, weightLeft, weights, values, dp);

        //pick
        int pick = Integer.MIN_VALUE;
        if(weightLeft - weights[index] >= 0)
            pick = values[index] + solveMemoization(index-1, weightLeft - weights[index], weights, values, dp);

        return dp[index][weightLeft] = Math.max(notpick, pick);

    }


    //using recursion
    public static int solveRecursion(int index, int weightLeft, int[] weights, int[] values){

        //base case
        //→ no items left → valid, contributes 0.
        if(index < 0)
            return 0;

        //invalid overweight → kill this path
        if(weightLeft < 0)
            return Integer.MIN_VALUE;

        //take only 1 element as example and calculate
        if(index == 0){
            if(weightLeft >= weights[index])
                return values[0]; // single item picked
            else
                return 0; // single item not picked
        }

        //notpick
        int notpick = 0 + solveRecursion(index-1, weightLeft, weights, values);

        //pick
        int pick = Integer.MIN_VALUE;
        if(weightLeft - weights[index] >= 0)
            pick = values[index] + solveRecursion(index-1, weightLeft - weights[index], weights, values);

        return Math.max(notpick, pick);

    }

}
