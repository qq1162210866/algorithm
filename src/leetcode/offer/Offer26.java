package leetcode.offer;

/**
 * Offer26.java
 * Description: https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/26
 */
public class Offer26 {
    public static void main(String[] args) {

    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //空树不是任何树的子结构
        if (A == null || B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        //此处要判断两颗树的子树，不能使用或
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }

}
