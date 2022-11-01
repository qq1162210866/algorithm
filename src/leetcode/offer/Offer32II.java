package leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Offer32II.java
 * Description: https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/11/1
 */
public class Offer32II {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            LinkedList<TreeNode> treeNodes1 = new LinkedList<>();
            List<Integer> tmp = new ArrayList<>();
            while (!treeNodes.isEmpty()) {
                TreeNode node = treeNodes.removeFirst();
                tmp.add(node.val);
                if (node.left != null) treeNodes1.addLast(node.left);
                if (node.right != null) treeNodes1.addLast(node.right);
            }
            result.add(tmp);
            treeNodes = treeNodes1;
        }
        return result;
    }
}
