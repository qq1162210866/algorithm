package leetcode.offer;

/**
 * Offer27.java
 * Description: https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/27
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    public void mirror(TreeNode root) {
        if (root == null) return;
        root.left = root.right;
        root.right = root.left;
        mirror(root.left);
        mirror(root.right);
    }

    public static void main(String[] args) {

    }
}
