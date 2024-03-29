package leetcode.hot;

/**
 * LeetCode62.java
 * Description: https://leetcode.cn/problems/unique-paths/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/20
 */
public class LeetCode62 {

    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        return result[m - 1][n - 1];
    }

    public static void main(String[] args) {

    }
}
