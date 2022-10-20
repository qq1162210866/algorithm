package leetcode.offer;

/**
 * Offer12.java
 * Description: https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/20
 */
public class Offer12 {
    public static void main(String[] args) {
        new Offer12().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
    }

    boolean result;

    public boolean exist(char[][] board, String word) {
        //思路是对的，但是超时了
        result = false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean result = test(board, used, word, 0, i, j);
                if (result) return true;
            }
        }
        return result;
    }

    public boolean test(char[][] board, boolean[][] used, String word, int index, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (index >= word.length()) {
            result = true;
            return true;
        }
        if (i < 0 || i >= m) return false;
        if (j < 0 || j >= n) return false;
        if (used[i][j]) return false;

        if (board[i][j] == word.charAt(index)) {
            used[i][j] = true;
            System.err.println("使用了一个字符串" + board[i][j]);
            if (test(board, used, word, index + 1, i - 1, j)) return true;
            if (test(board, used, word, index + 1, i + 1, j)) return true;
            if (test(board, used, word, index + 1, i, j - 1)) return true;
            if (test(board, used, word, index + 1, i, j + 1)) return true;
            used[i][j] = false;
        } else {
            return false;
        }
        return false;
    }
}
