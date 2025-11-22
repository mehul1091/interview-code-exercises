package org.self.dp.twod;

public class NinjaTrainingDp7 {

    public static void main(String[] args) {

        int[][] points = new int[3][3];
        points[0] = new int[]{1,2,5};
        points[1] = new int[]{3,1,1};
        points[2] = new int[]{3,3,3};

        System.out.println(ninjaTraining(3, points));
    }

    public static int ninjaTraining(int n, int points[][]) {

        int[][] dp = new int[n+1][4];

        //populate for base case, 1st row for day 0
        for(int i=0; i<3; i++){
            dp[0][i] = points[0][i];
        }

        //start from day 1
        for(int day=1; day<n; day++){

            for(int i=0; i<3; i++){

                if(i == 0){
                    dp[day][0] = points[day][0] + Math.max(dp[day-1][1], dp[day-1][2]);
                }
                else if(i == 1){
                    dp[day][1] = points[day][1] + Math.max(dp[day-1][0], dp[day-1][2]);
                }
                else{
                    dp[day][2] = points[day][2] + Math.max(dp[day-1][0], dp[day-1][1]);
                }
            }
        }

        //written after debug
        int max = Integer.MIN_VALUE;
        for(int i=0; i<3; i++){
            max = Math.max(max, dp[n-1][i]);
        }

        return max;
    }
}
