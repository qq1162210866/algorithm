package leetcode.hot;

/**
 * LeetCode200.java
 * Description: https://leetcode.cn/problems/number-of-islands/
 *
 * @author Peng Shiquan
 * @date 2022/10/3
 */
public class LeetCode200 {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    infect(grid, i, j);
                }
            }
        }
        return result;
    }

    public void infect(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        infect(grid, i + 1, j);
        infect(grid, i - 1, j);
        infect(grid, i, j + 1);
        infect(grid, i, j - 1);
    }
}
