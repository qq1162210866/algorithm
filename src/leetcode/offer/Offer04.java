package leetcode.offer;

/**
 * Offer04.java
 * Description: https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/17
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            System.err.println(i + "   " + j);
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }

    public static void main(String[] args) {
        new Offer04().findNumberIn2DArray(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20);
    }
}
