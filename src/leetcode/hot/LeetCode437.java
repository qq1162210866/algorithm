package leetcode.hot;

/**
 * LeetCode437.java
 * Description: https://leetcode.cn/problems/path-sum-iii/
 *
 * @author Peng Shiquan
 * @date 2022/10/11
 */
public class LeetCode437 {


    public static void main(String[] args) {

    }


    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int result = dfs(root, targetSum);
        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);
        return result;
    }

    public int dfs(TreeNode root, long targetSum) {
        int result = 0;
        if (root == null) return 0;
        int var = root.val;
        if (targetSum == var) result++;
        result += dfs(root.left, targetSum - var);
        result += dfs(root.right, targetSum - var);
        return result;
    }
}
