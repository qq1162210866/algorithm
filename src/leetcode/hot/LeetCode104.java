package leetcode.hot;

/**
 * LeetCode104.java
 * Description: https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 *
 * @author Peng Shiquan
 * @date 2022/8/19
 */
public class LeetCode104 {
    int maxDepth;

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        depth(root, 0);
        return maxDepth;
    }

    public int depth(TreeNode node, int depth) {
        if (node == null) return 0;
        depth++;
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) maxDepth = depth;
        }
        return Integer.max(depth(node.left, depth), depth(node.right, depth));
    }
}
