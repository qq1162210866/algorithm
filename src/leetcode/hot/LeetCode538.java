package leetcode.hot;

/**
 * LeetCode538.java
 * Description: https://leetcode.cn/problems/convert-bst-to-greater-tree/
 *
 * @author Peng Shiquan
 * @date 2022/9/7
 */
public class LeetCode538 {
    public static void main(String[] args) {

    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        //值是累计的，左子树的值肯定大于右子树的值
        if (root != null) {
            //转换右子树，求累计值。为null则跳出
            convertBST(root.right);
            //累加值
            sum += root.val;
            root.val = sum;
            //将累加值计算到左子树上
            convertBST(root.left);
        }
        return root;
    }

    public TreeNode convertBST2(TreeNode root) {
        //还有一种morris遍历，但是换了一种形式就不会了
        return root;
    }
}
