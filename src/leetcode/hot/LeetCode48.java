package leetcode.hot;

/**
 * LeetCode48.java
 * Description: https://leetcode.cn/problems/rotate-image/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/16
 */
public class LeetCode48 {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        //规律就是matrix[i][j] 变为 matrix[j][n-1-i]
        int length = matrix.length;
        int[][] matrix_new = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix_new[j][length - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }
}
