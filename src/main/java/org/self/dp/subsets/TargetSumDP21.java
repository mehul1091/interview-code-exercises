package org.self.dp.subsets;

public class TargetSumDP21 {

    public static void main(String[] args) {
        //run with VM args as -ea
        int[] nums;
        int target, result, expectedResult;
        TargetSumDP21 targetSumDP21 = new TargetSumDP21();

        nums = new int[]{1, 1, 1, 1, 1};
        target = 3;
        expectedResult = 5;
        result = targetSumDP21.findTargetSumWays(nums, target);
        System.out.println(result);
        assert (result == expectedResult) :
                new RuntimeException("expected result is " + expectedResult + " got " + result);

        nums = new int[]{1, 2, 3, 4, 5};
        target = -3;
        expectedResult = 3;
        result = targetSumDP21.findTargetSumWays(nums, target);
        System.out.println(result);
        assert (result == expectedResult) :
                new RuntimeException("expected result is " + expectedResult + " got " + result);

        nums = new int[]{1};
        target = -1;
        expectedResult = 1;
        result = targetSumDP21.findTargetSumWays(nums, target);
        System.out.println(result);
        assert (result == expectedResult) :
                new RuntimeException("expected result is " + expectedResult + " got " + result);

        nums = new int[]{0, 0, 0, 0};
        target = 0;
        expectedResult = 16;
        result = targetSumDP21.findTargetSumWays(nums, target);
        System.out.println(result);
        assert (result == expectedResult) :
                new RuntimeException("expected result is " + expectedResult + " got " + result);

        nums = new int[]{0, 1, 2};
        target = 3;
        expectedResult = 2;
        result = targetSumDP21.findTargetSumWays(nums, target);
        System.out.println(result);
        assert (result == expectedResult) :
                new RuntimeException("expected result is " + expectedResult + " got " + result);

        nums = new int[]{3, 1, 2};
        target = 10;
        expectedResult = 0;
        result = targetSumDP21.findTargetSumWays(nums, target);
        System.out.println(result);
        assert (result == expectedResult) :
                new RuntimeException("expected result is " + expectedResult + " got " + result);

        nums = new int[]{1, 2, 3, 4, 5};
        target = -3;
        expectedResult = 3;
        result = targetSumDP21.findTargetSumWays(nums, target);
        System.out.println(result);
        assert (result == expectedResult) :
                new RuntimeException("expected result is " + expectedResult + " got " + result);

        nums = new int[]{100};
        target = -100;
        expectedResult = 1;
        result = targetSumDP21.findTargetSumWays(nums, target);
        System.out.println(result);
        assert (result == expectedResult) :
                new RuntimeException("expected result is " + expectedResult + " got " + result);

        nums = new int[]{2, 3, 5};
        target = 10;
        expectedResult = 1;
        result = targetSumDP21.findTargetSumWays(nums, target);
        System.out.println(result);
        assert (result == expectedResult) :
                new RuntimeException("expected result is " + expectedResult + " got " + result);

        nums = new int[]{1, 1, 1, 1};
        target = 0;
        expectedResult = 6;
        result = targetSumDP21.findTargetSumWays(nums, target);
        System.out.println(result);
        assert (result == expectedResult) :
                new RuntimeException("expected result is " + expectedResult + " got " + result);


    }


    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int totalSum = 0;

        //find totalSum of elements
        for (int i = 0; i < n; i++) {
            totalSum = totalSum + nums[i];
        }

        int max = 0;

        //divide totalSum into 2 groups such that |S1 - S2| == |target|
        for (int S1 = totalSum / 2; S1 <= totalSum; S1++) {

            int value = Math.abs(2 * S1 - totalSum);

            if (value == Math.abs(target)) {
                int res = findSubsetWithTarget(nums, S1);
                max = Math.max(max, res);
            }
        }

        return max;
    }

    public int findSubsetWithTarget(int[] arr, int target) {

        int n = arr.length;
        return solve(n - 1, target, arr);
    }

    //recursion
    public int solve(int index, int target, int[] arr) {

        //base case
        //index reducing
       /* if(index < 0)
            return (int) -1e9;

        //this was missed
        if(target == 0)
            return 1;

        if(index == 0){
            return (target == arr[0]) ? 1 : 0;
        }
        */

        if (index == 0) {
            //case 1
            if (target == 0 && arr[0] == target)
                return 2;
            else if (target == 0 || arr[0] == target)
                return 1;
            else
                return 0;
        }


        //not pick
        int notpick = solve(index - 1, target, arr);

        //pick
        int pick = 0;
        if (target - arr[index] >= 0)
            pick = solve(index - 1, target - arr[index], arr);

        return notpick + pick;
    }

}
