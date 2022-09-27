package leetcode.hot;

/**
 * LeetCode114.java
 * Description: https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/27
 */
public class LeetCode114 {

    TreeNode head;
    TreeNode cur;

    public void flatten(TreeNode root) {
        if (root == null) return;
        dfs(root);
        //将结果放到root下面
        root.right = head.right;
        root.left = null;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (head == null) {
            head = new TreeNode(root.val);
            cur = head;
        } else {
            cur.right = new TreeNode(root.val);
            cur = cur.right;
        }
        dfs(root.left);
        dfs(root.right);

    }

    public static void main(String[] args) {
        new LeetCode114().flatten(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5)));
    }

}
