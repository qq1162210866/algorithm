package leetcode.hot;

/**
 * LeetCode543.java
 * Description: https://leetcode.cn/problems/diameter-of-binary-tree/
 *
 * @author Peng Shiquan
 * @date 2022/8/15
 */
public class LeetCode543 {
    public static void main(String[] args) {

    }

    //最后的结果
    int result;

    public int diameterOfBinaryTree(TreeNode root) {
        result = 1;
        depth(root);
        return result - 1;

    }

    /**
     * Description: 求树的最长的深度
     *
     * @param root
     * @return int
     * @author Peng Shiquan
     * @date 2022-08-15
     */
    public int depth(TreeNode root) {
        if (root == null) return 0;
        //递归寻找左树的最长深度，同时更新最后的直径数据
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        //查询左右树后，判断最后的结果集和当前树哪个最大
        result = Integer.max(result, leftDepth + rightDepth + 1);
        //返回结果集，用于求树的直径
        return Integer.max(leftDepth, rightDepth) + 1;
    }
}
