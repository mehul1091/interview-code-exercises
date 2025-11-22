package org.self.dp.substring;

public class LongestCommonSubstringDP27Tabulation implements LongestCommonSubstringDP27{

    @Override
    public int printLengthOfLongestCommonSubstring(String s1, String s2) {
        return printLengthOfLongestCommonSubstringTabulation(s1, s2);
    }
    public static int printLengthOfLongestCommonSubstringTabulation(String s1, String s2){

        char[] txt1 = s1.toCharArray();
        char[] txt2 = s2.toCharArray();

        //create dp[][]
        int N = txt1.length;
        int M = txt2.length;

        //note this length here
        int[][] dp = new int[N + 1][M + 1];

        //initialize 1st row = 0
        for(int i=0; i<N+1; i++){
            dp[i][0] = 0;
        }

        //initialize 1st col = 0
        for(int j=0; j<M+1; j++){
            dp[0][j] = 0;
        }

        int maxLength = 0;
        //start with 1,1
        for(int index1=1; index1<N+1; index1++){

            for(int index2=1; index2<M+1; index2++){

                if(txt1[index1-1] == txt2[index2-1]){
                    dp[index1][index2] = 1 + dp[index1-1][index2-1];
                    maxLength = Math.max(maxLength, dp[index1][index2]);
                }
                else {
                    dp[index1][index2] = 0;
                }
            }
        }

        return maxLength;
    }


}
