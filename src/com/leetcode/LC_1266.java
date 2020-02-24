package com.leetcode;

public class LC_1266 {
    public static void main(String[] args) {
        System.out.println(minTimeToVisitAllPoints(new int[][]{{1,1},{3,4},{-1,0}}) == 7);
        System.out.println(minTimeToVisitAllPoints(new int[][]{{3,2},{-2,2}}) == 5);
    }

    static int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        for (int i = 0; i < points.length - 1; i++) {
            int curX = points[i][0];
            int curY = points[i][1];

            int nextX = points[i + 1][0];
            int nextY = points[i + 1][1];

            int xDist = Math.abs(nextX - curX);
            int yDist = Math.abs(nextY - curY);

            time += Math.max(xDist, yDist);
        }
        return time;
    }
}
