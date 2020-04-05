package com.leetcode;

public class LC_1252 {
    public static void main(String[] args) {
        System.out.println(oddCells_01(2 , 3, new int[][]{{0,1}, {1,1}}) == 6);
        System.out.println(oddCells_01(2 , 2, new int[][]{{1,1}, {0,0}}) == 0);

        System.out.println(oddCells_02(2 , 3, new int[][]{{0,1}, {1,1}}) == 6);
        System.out.println(oddCells_02(2 , 2, new int[][]{{1,1}, {0,0}}) == 0);

        System.out.println(oddCells_03(2 , 3, new int[][]{{0,1}, {1,1}}) == 6);
        System.out.println(oddCells_03(2 , 2, new int[][]{{1,1}, {0,0}}) == 0);
    }

    static int oddCells_01(int n, int m, int[][] indices) {
        int[][] result = new int[n][m];
        int oddCount = 0;

        for (int[] index : indices) {
            int row = index[0];
            int column = index[1];

            int[] rowArr = result[row];
            for (int j = 0; j < rowArr.length; j++) {
                rowArr[j]++;
            }

            for (int[] cur : result) {
                cur[column]++;
            }
        }

        for (int[] cur : result) {
            for (int num : cur) {
                if (num % 2 != 0) {
                    oddCount++;
                }
            }
        }

        return oddCount;
    }

    static int oddCells_02(int n, int m, int[][] indices) {
        int[][] result = new int[n][m];
        int oddCount = 0;

        for (int[] index : indices) {
            for (int i = 0; i < result.length; i++) {
                int[] cur = result[i];

                if (i == index[0]) {
                    for (int j = 0; j < cur.length; j++) {
                        cur[j]++;

                        if (j == index[1]) {
                            cur[j]++;
                        }
                    }
                } else {
                    cur[index[1]]++;
                }


            }
        }

        for (int[] cur : result) {
            for (int num : cur) {
                if (num % 2 != 0) {
                    oddCount++;
                }
            }
        }

        return oddCount;
    }

    static int oddCells_03(int n, int m, int[][] indices) {
        int oddCount = 0;

        int[] rows = new int[n];
        int[] columns = new int[m];

        for (int[] index : indices) {
            rows[index[0]]++;
            columns[index[1]]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((rows[i] + columns[j]) %2 != 0) {
                    oddCount++;
                }
            }
        }

        return oddCount;
    }
}
