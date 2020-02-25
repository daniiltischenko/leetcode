package com.leetcode;

public class LC_240 {
    public static void main(String[] args) {
        System.out.println(searchMatrix_01(new int[][] {
                        { 1, 4, 7, 11, 15 },
                        { 2, 5, 8, 12, 19 },
                        { 3, 6, 9, 16, 22 },
                        { 10, 13, 14, 17, 24 },
                        { 18, 21, 23, 26, 30 }}, 35) == false);

        System.out.println(searchMatrix_01(new int[][] {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }}, 0) == false);

        System.out.println(searchMatrix_01(new int[][] {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }}, 5) == true);

        System.out.println(searchMatrix_01(new int[][] {
                {1},
                {3},
                {5}}, 2) == false);

        System.out.println(searchMatrix_01(new int[][] {
                        {3,3,8,13,13,18},
                        {4,5,11,13,18,20},
                        {9,9,14,15,23,23},
                        {13,18,22,22,25,27},
                        {18,22,23,28,30,33},
                        {21,25,28,30,35,35},
                        {24,25,33,36,37,40}},
                21) == true);

        System.out.println(searchMatrix_02(new int[][] {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }}, 35) == false);

        System.out.println(searchMatrix_02(new int[][] {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }}, 0) == false);

        System.out.println(searchMatrix_02(new int[][] {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }}, 5) == true);

        System.out.println(searchMatrix_02(new int[][] {
                {1},
                {3},
                {5}}, 2) == false);

        System.out.println(searchMatrix_02(new int[][] {
                        {3,3,8,13,13,18},
                        {4,5,11,13,18,20},
                        {9,9,14,15,23,23},
                        {13,18,22,22,25,27},
                        {18,22,23,28,30,33},
                        {21,25,28,30,35,35},
                        {24,25,33,36,37,40}},
                21) == true);
    }

    static boolean searchMatrix_01(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        if (target < matrix[0][0]) {
            return false;
        }

        if (target > matrix[matrix.length-1][matrix[0].length-1]) {
            return false;
        }

        for (int i = 0, start = matrix[0].length - 1; i < matrix.length; i++) {
            for (int j = start; j >= 0; j--) {

                if (target == matrix[i][j]) {
                    return true;
                }

                if (target > matrix[i][j]) {
                    start = j;
                    break;
                }
            }
        }

        return false;
    }

    static boolean searchMatrix_02(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        if (target < matrix[0][0]) {
            return false;
        }

        if (target > matrix[matrix.length-1][matrix[0].length-1]) {
            return false;
        }

        int col = matrix[0].length - 1;
        int row = 0;

        while (col >= 0 && row <= matrix.length-1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            } else if (target < matrix[row][col]) {
                col--;
            }
        }

        return false;
    }
}
