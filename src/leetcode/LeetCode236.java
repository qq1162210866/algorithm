package leetcode;

import java.math.BigDecimal;

/**
 * LeetCode236.java
 * Description:  二叉树的最近公共祖先
 *
 * @author Peng Shiquan
 * @date 2021/7/15
 */
public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode findLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode findRight = lowestCommonAncestor(root.right, p, q);
        if (findRight != null && findLeft != null) {
            return root;
        } else if (findRight != null && findLeft == null) {
            //右子树存在p，q，则前面的节点就是最近祖先
            return findRight;
        } else if (findRight == null && findLeft != null) {
            return findLeft;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}