package org.self.monotonicstack.jun17;

import java.util.*;

import static org.self.monotonicstack.jun17.BuildingsWithOceanViewLC1762.findBuildings;

public class BuildingsWithOceanViewTest {


    // ==================== HELPER ====================
    private static void runTest(String name, int[] heights, int[] expected) {
        int[] actual = findBuildings(heights);
        boolean passed = Arrays.equals(actual, expected);
        System.out.printf("[%s] %s | Input: %s | Expected: %s | Actual: %s%n",
                passed ? "PASS" : "FAIL",
                name,
                Arrays.toString(heights),
                Arrays.toString(expected),
                Arrays.toString(actual));
    }

    // ==================== TEST CASES ====================
    public static void main(String[] args) {
        System.out.println("===== LeetCode 1762: Buildings With an Ocean View =====\n");

        // ---------- 1. Official Examples ----------
        runTest("Example 1",
                new int[]{4, 2, 3, 1},
                new int[]{0, 2, 3});

        runTest("Example 2",
                new int[]{4, 3, 2, 1},
                new int[]{0, 1, 2, 3});

        runTest("Example 3",
                new int[]{1, 3, 2, 4},
                new int[]{3});

        // ---------- 2. Edge Cases: Size ----------
        runTest("Single building",
                new int[]{5},
                new int[]{0});

        runTest("Two buildings - first taller",
                new int[]{5, 3},
                new int[]{0, 1});

        runTest("Two buildings - second taller",
                new int[]{3, 5},
                new int[]{1});

        runTest("Two buildings - equal height",
                new int[]{5, 5},
                new int[]{1});

        // ---------- 3. Edge Cases: Patterns ----------
        runTest("All same heights",
                new int[]{7, 7, 7, 7, 7},
                new int[]{4});

        runTest("Strictly increasing",
                new int[]{1, 2, 3, 4, 5},
                new int[]{4});

        runTest("Strictly decreasing",
                new int[]{5, 4, 3, 2, 1},
                new int[]{0, 1, 2, 3, 4});

        runTest("Only last building has view",
                new int[]{1, 1, 1, 1, 10},
                new int[]{4});

        runTest("Only first building has view (besides last)",
                new int[]{10, 1, 1, 1, 1},
                new int[]{0, 4});

        // ---------- 4. Duplicates & Plateaus ----------
        runTest("Plateau then drop",
                new int[]{5, 5, 5, 3, 3, 1},
                new int[]{2, 4, 5});

        runTest("Alternating peaks",
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[]{5, 6});

        runTest("Equal heights with one taller at end",
                new int[]{3, 3, 3, 3, 4},
                new int[]{4});

        // ---------- 5. Large Values ----------
        runTest("Large height values",
                new int[]{100000, 99999, 100000, 1},
                new int[]{2, 3});

        runTest("Max int height",
                new int[]{Integer.MAX_VALUE, 1, 2, 3},
                new int[]{0, 3});

        // ---------- 6. Stress / Complex ----------
        runTest("Sawtooth pattern",
                new int[]{10, 1, 10, 1, 10, 1, 10},
                new int[]{6});

        runTest("Increasing then decreasing",
                new int[]{1, 3, 5, 7, 9, 8, 6, 4, 2},
                new int[]{4, 5, 6, 7, 8});

        runTest("Decreasing then increasing",
                new int[]{9, 7, 5, 3, 1, 2, 4, 6, 8},
                new int[]{0, 8});

        runTest("All ones",
                new int[]{1, 1, 1, 1, 1, 1},
                new int[]{5});

        // ---------- 7. Empty / Null ----------
        runTest("Empty array",
                new int[]{},
                new int[]{});

        System.out.println("\n===== All tests completed =====");
    }
}
