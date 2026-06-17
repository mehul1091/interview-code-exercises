package org.self.monotonicstack.jun17;

import java.util.Arrays;
import java.util.Stack;

public class BuildingsWithOceanViewLC1762 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findBuildings(new int[]{4,2,3,1})));

        System.out.println(Arrays.toString(findBuildings(new int[]{4,3,2,1})));

        System.out.println(Arrays.toString(findBuildings(new int[]{1,3,2,4})));
    }

    public static int[] findBuildings(int[] heights) {
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<heights.length; i++){

            while(!s.isEmpty() && heights[s.peek()] <= heights[i]){
                int idx = s.pop();
            }

            s.push(i);
        }

        int[] res = new int[s.size()];
        int i = 0;

        // here we are NOT popping the elements
        // Only traversing the elements from bottom of the stack
        for(Integer idx : s){
            res[i++] = idx;
        }

        //If popping elements from stack, then need to reverse
/*
        while(!s.isEmpty()){
            res[i++] = s.pop();
        }
        Arrays.sort(res);
*/
        return res;
    }
}
