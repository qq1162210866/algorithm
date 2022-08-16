package leetcode.hot;

/**
 * LeetCode101.java
 * Description: https://leetcode.cn/problems/symmetric-tree/
 *
 * @author Peng Shiquan
 * @date 2022/8/16
 */
public class LeetCode101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        //判断当前左右树数值是否一致，在递归调用镜像，判断子树是否一致
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}
