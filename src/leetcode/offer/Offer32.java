package leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Offer32.java
 * Description: https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/31
 */
public class Offer32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        treeNodes.addLast(root);
        while (!treeNodes.isEmpty()) {
            TreeNode tmp = treeNodes.pop();
            if (tmp != null) {
                if (tmp.left != null) treeNodes.add(tmp.left);
                if (tmp.right != null) treeNodes.add(tmp.right);
                result.add(tmp.val);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

    }
}
