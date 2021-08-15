package leetcode;

/**
 * LeetCode54.java
 * Description:. 二叉搜索树的第k大节点
 *
 * @author Peng Shiquan
 * @date 2021/7/18
 */
public class LeetCode54 {
    int k;
    int result;

    public int kthLargest(TreeNode root, int k) {
        //通过对象调用，不能写 k=k
        this.k = k;
        dfs(root);
        return result;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        //减少后续的遍历，找到节点后就返回
        if (k == 0) return;
        if (--k == 0) {
            result = root.val;
            return;
        }
        dfs(root.left);
    }
}
