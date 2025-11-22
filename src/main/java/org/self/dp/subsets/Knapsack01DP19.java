package org.self.dp.subsets;

public class Knapsack01DP19 {
    public static void main(String[] args) {

        int[] weights, values;
        int bagCapacity, n;

        bagCapacity = 10; n = 4;
        weights = new int[]{5,4,6,3};
        values = new int[]{10,40,30,50};
        System.out.println(knapsack01(weights, values, bagCapacity, n));
    }

    public static int knapsack01(int[] weights, int[] values, int bagCapacity, int n){
        return solve(n-1, bagCapacity, weights, values);
    }

    public static int solve(int index, int weightLeft, int[] weights, int[] values){

        //base case

        //take only 1 element as example and calculate
        if(index == 0){
            if(weightLeft >= weights[index])
                return values[0];
            else
                return 0;
        }

        //notpick
        int notpick = 0 + solve(index-1, weightLeft, weights, values);

        //pick
        int pick = Integer.MIN_VALUE;
        if(weightLeft - weights[index] >= 0)
            pick = values[index] + solve(index-1, weightLeft - weights[index], weights, values);

        return Math.max(notpick, pick);

    }

}
