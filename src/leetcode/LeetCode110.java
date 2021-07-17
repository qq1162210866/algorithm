package leetcode;

/**
 * LeetCode110.java
 * Description:  求当前数是否为平衡二叉树
 *
 * @author Peng Shiquan
 * @date 2021/7/16
 */
public class LeetCode110 {
    public static void main(String[] args) {
        LeetCode110 leetCode110 = new LeetCode110();

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        //有可能子树的高度一致，但是子树不是平衡二叉树
        boolean result = Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
        return result;
    }

    public int treeHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }


}
