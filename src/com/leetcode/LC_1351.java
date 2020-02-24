package com.leetcode;

public class LC_1351 {
    public static void main(String[] args) {
        System.out.println(countNegatives_01(new int[][]{{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}}) == 8);
        System.out.println(countNegatives_01(new int[][]{{3,2}, {1,0}}) == 0);
        System.out.println(countNegatives_01(new int[][]{{1,-1}, {-1,-1}}) == 3);
        System.out.println(countNegatives_01(new int[][]{{-1}}) == 1);

        System.out.println(countNegatives_02(new int[][]{{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}}) == 8);
        System.out.println(countNegatives_02(new int[][]{{3,2}, {1,0}}) == 0);
        System.out.println(countNegatives_02(new int[][]{{1,-1}, {-1,-1}}) == 3);
        System.out.println(countNegatives_02(new int[][]{{-1}}) == 1);
    }

    static int countNegatives_01(int[][] grid) {
        int count = 0;
        for (int i = grid.length - 1; i >= 0 ; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][0] < 0) {
                    count += grid[i].length;
                    break;
                }

                if(grid[i][j] < 0) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    static int countNegatives_02(int[][] grid) {
        int count = 0;
        for (int i = grid.length - 1, start = 0; i >= 0; i--) {
            for (int j = start; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count += grid[i].length - j;
                    start = j;
                    break;
                }
            }
        }
        return count;
    }
}
