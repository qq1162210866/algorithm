package leetcode.offer;

/**
 * Offer29.java
 * Description: https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/28
 */
public class Offer29 {
    public static void main(String[] args) {

    }

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        if (n == 0) return new int[0];
        int length = m * n;
        int[] result = new int[length];
        //结果集的下标
        int index = 0;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[up][i];
                if (index == length) return result;
            }
            up++;
            for (int i = up; i <= down; i++) {
                result[index++] = matrix[i][right];
                if (index == length) return result;
            }
            right--;
            for (int i = right; i >= left; i--) {
                result[index++] = matrix[down][i];
                if (index == length) return result;
            }
            down--;
            for (int i = down; i >= up; i--) {
                result[index++] = matrix[i][left];
                if (index == length) return result;
            }
            left++;
        }

    }
}
