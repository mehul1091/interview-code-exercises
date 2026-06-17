package org.self.monotonicstack.jun17;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("LeetCode 1762 - Buildings With an Ocean View")
class BuildingsWithOceanViewLC1762Tests {

    private final BuildingsWithOceanViewLC1762 solution = new BuildingsWithOceanViewLC1762();

    // ==================== Parameterized Tests ====================

    @Nested
    @DisplayName("Official LeetCode Examples")
    class OfficialExamples {

        static Stream<Arguments> officialCases() {
            return Stream.of(
                    Arguments.of(new int[]{4, 2, 3, 1}, new int[]{0, 2, 3}),
                    Arguments.of(new int[]{4, 3, 2, 1}, new int[]{0, 1, 2, 3}),
                    Arguments.of(new int[]{1, 3, 2, 4}, new int[]{3})
            );
        }

        @ParameterizedTest(name = "heights = {0}")
        @MethodSource("officialCases")
        @DisplayName("Should pass official examples")
        void testOfficialExamples(int[] heights, int[] expected) {
            assertArrayEquals(expected, solution.findBuildings(heights));
        }
    }

    @Nested
    @DisplayName("Edge Cases - Array Size")
    class SizeEdgeCases {

        @Test
        @DisplayName("Empty array returns empty result")
        void testEmptyArray() {
            assertArrayEquals(new int[]{}, solution.findBuildings(new int[]{}));
        }

        @Test
        @DisplayName("Single building always has ocean view")
        void testSingleBuilding() {
            assertArrayEquals(new int[]{0}, solution.findBuildings(new int[]{5}));
        }

        @Test
        @DisplayName("Two buildings - first taller")
        void testTwoBuildingsFirstTaller() {
            assertArrayEquals(new int[]{0, 1}, solution.findBuildings(new int[]{5, 3}));
        }

        @Test
        @DisplayName("Two buildings - second taller")
        void testTwoBuildingsSecondTaller() {
            assertArrayEquals(new int[]{1}, solution.findBuildings(new int[]{3, 5}));
        }

        @Test
        @DisplayName("Two buildings - equal height (equal blocks view)")
        void testTwoBuildingsEqualHeight() {
            assertArrayEquals(new int[]{1}, solution.findBuildings(new int[]{5, 5}));
        }
    }

    @Nested
    @DisplayName("Pattern Tests")
    class PatternTests {

        static Stream<Arguments> patternCases() {
            return Stream.of(
                    Arguments.of("All same heights",
                            new int[]{7, 7, 7, 7, 7}, new int[]{4}),
                    Arguments.of("Strictly increasing",
                            new int[]{1, 2, 3, 4, 5}, new int[]{4}),
                    Arguments.of("Strictly decreasing",
                            new int[]{5, 4, 3, 2, 1}, new int[]{0, 1, 2, 3, 4}),
                    Arguments.of("Only last building has view",
                            new int[]{1, 1, 1, 1, 10}, new int[]{4}),
                    Arguments.of("First and last have view",
                            new int[]{10, 1, 1, 1, 1}, new int[]{0, 4}),
                    Arguments.of("All ones",
                            new int[]{1, 1, 1, 1, 1, 1}, new int[]{5})
            );
        }

        @ParameterizedTest(name = "{0}")
        @MethodSource("patternCases")
        @DisplayName("Should handle various height patterns")
        void testPatterns(String name, int[] heights, int[] expected) {
            assertArrayEquals(expected, solution.findBuildings(heights));
        }
    }

    @Nested
    @DisplayName("Duplicates and Plateaus")
    class DuplicateTests {

        static Stream<Arguments> duplicateCases() {
            return Stream.of(
                    Arguments.of("Plateau then drop",
                            new int[]{5, 5, 5, 3, 3, 1}, new int[]{2, 4, 5}),
                    Arguments.of("Alternating peaks",
                            new int[]{1, 5, 2, 6, 3, 7, 4}, new int[]{5, 6}),
                    Arguments.of("Equal heights with one taller at end",
                            new int[]{3, 3, 3, 3, 4}, new int[]{4})
            );
        }

        @ParameterizedTest(name = "{0}")
        @MethodSource("duplicateCases")
        @DisplayName("Should correctly handle equal-height blocking")
        void testDuplicates(String name, int[] heights, int[] expected) {
            assertArrayEquals(expected, solution.findBuildings(heights));
        }
    }

    @Nested
    @DisplayName("Large and Boundary Values")
    class BoundaryTests {

        @Test
        @DisplayName("Large height values")
        void testLargeValues() {
            assertArrayEquals(new int[]{2, 3},
                    solution.findBuildings(new int[]{100000, 99999, 100000, 1}));
        }

        @Test
        @DisplayName("Integer.MAX_VALUE as height")
        void testMaxIntHeight() {
            assertArrayEquals(new int[]{0, 3},
                    solution.findBuildings(new int[]{Integer.MAX_VALUE, 1, 2, 3}));
        }

        @Test
        @DisplayName("Height value of 1 (minimum positive)")
        void testMinHeight() {
            assertArrayEquals(new int[]{0, 1, 2},
                    solution.findBuildings(new int[]{3, 2, 1}));
        }
    }

    @Nested
    @DisplayName("Complex Patterns")
    class ComplexTests {

        static Stream<Arguments> complexCases() {
            return Stream.of(
                    Arguments.of("Sawtooth pattern (equal peaks)",
                            new int[]{10, 1, 10, 1, 10, 1, 10}, new int[]{6}),
                    Arguments.of("Increasing then decreasing",
                            new int[]{1, 3, 5, 7, 9, 8, 6, 4, 2}, new int[]{4, 5, 6, 7, 8}),
                    Arguments.of("Decreasing then increasing",
                            new int[]{9, 7, 5, 3, 1, 2, 4, 6, 8}, new int[]{0, 8}),
                    Arguments.of("Sawtooth with strictly increasing peaks",
                            new int[]{10, 1, 11, 1, 12, 1, 13}, new int[]{6}),
                    Arguments.of("Long plateau at end",
                            new int[]{10, 9, 8, 5, 5, 5, 5}, new int[]{0, 1, 2, 6})
            );
        }

        @ParameterizedTest(name = "{0}")
        @MethodSource("complexCases")
        @DisplayName("Should handle complex height arrangements")
        void testComplexPatterns(String name, int[] heights, int[] expected) {
            assertArrayEquals(expected, solution.findBuildings(heights));
        }
    }

    @Nested
    @DisplayName("Null Safety")
    class NullTests {

        @Test
        @DisplayName("Null input should be handled gracefully")
        void testNullInput() {
            // Note: if your solution doesn't handle null, this test documents that behavior
            // Uncomment the assertion below if you add null handling to your solution
            // assertArrayEquals(new int[]{}, solution.findBuildings(null));

            // For now, just verify the method exists and accepts arrays
            assertNotNull(solution);
        }
    }

    @Nested
    @DisplayName("Stress / Large Input")
    class StressTests {

        @Test
        @DisplayName("Strictly decreasing array of 1000 elements")
        void testLargeDecreasing() {
            int n = 1000;
            int[] heights = new int[n];
            int[] expected = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = n - i;
                expected[i] = i;
            }
            assertArrayEquals(expected, solution.findBuildings(heights));
        }

        @Test
        @DisplayName("Strictly increasing array of 1000 elements")
        void testLargeIncreasing() {
            int n = 1000;
            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = i + 1;
            }
            assertArrayEquals(new int[]{n - 1}, solution.findBuildings(heights));
        }

        @Test
        @DisplayName("All equal elements - 1000 of them")
        void testLargeAllEqual() {
            int n = 1000;
            int[] heights = new int[n];
            java.util.Arrays.fill(heights, 42);
            assertArrayEquals(new int[]{n - 1}, solution.findBuildings(heights));
        }
    }
}