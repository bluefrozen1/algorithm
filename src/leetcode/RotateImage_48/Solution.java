package leetcode.RotateImage_48;

import java.util.Arrays;

public class Solution {

    // https://leetcode.com/problems/rotate-image/

    public static void main(String[] args) {
        int[][] rotate = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        new Solution().rotate(rotate);
        for (int i = 0; i < rotate.length; i++) {
            System.out.println(Arrays.toString(rotate[i]));
        }
    }

    public void rotate(int[][] matrix) {
        int[][] originMatrix = new int[matrix.length][];
        for(int i=0; i<matrix.length; i++) {
            originMatrix[i] = matrix[i].clone();
        }

        int i=0; int j=0;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = matrix.length-1; x >= 0; x--) {
                System.out.println("x=" + x + ", y=" + y + ", value=" + originMatrix[x][y] + ", i=" + i + ", j=" + j);
                matrix[i][j] = originMatrix[x][y];
                j++;
                if(j >= matrix.length) {
                    j = 0;
                }
            }
            i++;
            if(i >= matrix.length) {
                i = 0;
            }
        }
    }
}
