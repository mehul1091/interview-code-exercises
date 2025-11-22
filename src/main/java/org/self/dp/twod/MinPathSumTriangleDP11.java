package org.self.dp.twod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinPathSumTriangleDP11 {
    public static void main(String[] args) {
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row1 = Arrays.asList(2);
        List<Integer> row2 = Arrays.asList(3,4);
        List<Integer> row3 = Arrays.asList(6,5,7);
        List<Integer> row4 = Arrays.asList(4,1,8,3);
        triangle.add(row1);
        triangle.add(row2);
//        triangle.add(row3);
//        triangle.add(row4);

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();

        int[][] dp = new int[N][N];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));

        dp[0][0] = triangle.get(0).get(0);

        //1st col
        for(int row=1; row<N; row++){
            dp[row][0] = triangle.get(row).get(0) + dp[row-1][0];
        }

        //start from 1,1
        for(int row=1; row<N; row++){

            for(int col=1; col<triangle.get(row).size(); col++){
                dp[row][col] = triangle.get(row).get(col) + Math.min(dp[row-1][col], dp[row-1][col-1]);
            }
        }

        int min = 0;
        for (int col = 0; col < N; col++) {
            min = Math.min(min, dp[N-1][col]);
        }

        return min;
    }

    public static int minimumTotalRecursion(List<List<Integer>> triangle) {

        int N = triangle.size();
        int M = triangle.get(N-1).size();

        return solve(N-1, M-1, triangle);
    }

    public static int solve(int row, int col, List<List<Integer>> triangle){
        //base case
        if(row == 0 && col== 0)
            return triangle.get(0).get(0);

        if(row<0 || col <0)
            return Integer.MAX_VALUE;

        //top
        int top = Integer.MAX_VALUE;
        if(triangle.get(row-1) != null && triangle.get(row-1).get(col) != null)
            top = triangle.get(row).get(col) + solve(row-1, col, triangle);

        int left = Integer.MAX_VALUE;
        if(triangle.get(row-1) != null && triangle.get(row-1).get(col-1) != null)
            left = triangle.get(row).get(col) + solve(row-1, col-1, triangle);

        return Math.min(top, left);
    }
}
