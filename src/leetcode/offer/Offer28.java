package leetcode.offer;

/**
 * Offer28.java
 * Description: https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 * @author Peng Shiquan
 * @date 2022/10/27
 */
public class Offer28 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.right, right.left) && check(left.left, right.right);
    }

}
