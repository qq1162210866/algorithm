package leetcode.hot;

/**
 * LeetCode226.java
 * Description: https://leetcode.cn/problems/invert-binary-tree/
 *
 * @author Peng Shiquan
 * @date 2022/8/11
 */
public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
