package leetcode.hot;

/**
 * LeetCode79.java
 * Description: https://leetcode.cn/problems/word-search/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/22
 */
public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean flag = check(board, used, i, j, 0, word);
                    if (flag) return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] used, int i, int j, int index, String word) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        used[i][j] = true;
        boolean result = false;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!used[newi][newj]) {
                    //要做回退操作，不能再这个地方return
                    result = check(board, used, newi, newj, index + 1, word);
                    //当找到时，可以不用回退，直接返回
                    if (result) {
                        result = true;
                        break;
                    }
                }
            }
        }
        used[i][j] = false;
        return result;
    }

    public static void main(String[] args) {

    }
}
