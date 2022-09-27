package leetcode.hot;

/**
 * LeetCode98.java
 * Description: https://leetcode.cn/problems/validate-binary-search-tree/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/24
 */
public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long low, long up) {
        if (root == null) return true;
        if (root.val <= low || root.val >= up) {
            //说明当前节点不在范围内，是错的
            return false;
        }
        //递归到子树，但是修改部分边界值
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, up);
    }

    //中序遍历到解法
    Long pre = Long.MIN_VALUE;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST2(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = (long) root.val;
        return isValidBST(root.right);

    }

    public static void main(String[] args) {

    }
}
