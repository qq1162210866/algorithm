package leetcode.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode337.java
 * Description: https://leetcode.cn/problems/house-robber-iii/
 *
 * @author Peng Shiquan
 * @date 2022/10/9
 */
public class LeetCode337 {
    public static void main(String[] args) {

    }


    Map<TreeNode, Integer> yes = new HashMap<>();
    Map<TreeNode, Integer> no = new HashMap<>();

    public int rob(TreeNode root) {
        yes.put(null, 0);
        no.put(null, 0);
        dfs(root);
        return Math.max(yes.get(root), no.get(root));
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        yes.put(root, no.get(root.left) + no.get(root.right) + root.val);
        no.put(root, Math.max(yes.get(root.left), no.get(root.left))
                + Math.max(yes.get(root.right), no.get(root.right)));
    }
}
