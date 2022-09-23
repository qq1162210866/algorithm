package leetcode.hot;

/**
 * LeetCode236.java
 * Description: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author Peng Shiquan
 * @date 2022/9/23
 */
public class LeetCode236 {
    public static void main(String[] args) {


    }

    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        dfs(root, p, q);
        return result;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        //判断当前节点是否为最大祖先,
        //pq分别在左子树和右子树。或者都在左子树或者右子树。或者当前值
        //这个值会遍历更新
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) result = root;
        return left || right || (root.val == p.val || root.val == q.val);
    }
}
