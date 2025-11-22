package org.self.dp.subsets;

public class CountSubsetsWithSumKDP17 {

    public static void main(String[] args) {
        int[] arr;

        arr = new int[]{1,5,5};
        System.out.println(findWays(arr, 5));

        arr = new int[]{1,2,3};
        System.out.println(findWays(arr, 3));
    }

    public static int findWays(int num[], int tar) {
        int n = num.length;
        return solve(n-1, tar, num);
    }

    public static int solve(int index, int target, int[] arr){

        //base case
        //this is wrong, check for index==0
//        if(index < 0)
//            return 0;

        if(index == 0){
            if(arr[index] == target && arr[index] == 0)
                return 2;
            else if(arr[index] == target)
                return 1;
            else
                return 0;
        }


        //this is wrong
//        if(target == arr[index])
//            return 1;


        if(target == 0)
            return 1;

        //not pick
        int notpick = solve(index-1, target, arr);

        //pick
        int pick = solve(index-1, target-arr[index], arr);

        return pick + notpick;
    }
}
