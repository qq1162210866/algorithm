package leetcode.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Offer32III.java
 * Description: https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/11/1
 */
public class Offer32III {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        boolean control = true;
        while (!treeNodes.isEmpty()) {
            LinkedList<TreeNode> treeNodes1 = new LinkedList<>();
            List<Integer> tmp = new ArrayList<>();
            while (!treeNodes.isEmpty()) {
                TreeNode node = treeNodes.removeFirst();
                tmp.add(node.val);
                if (node.left != null) treeNodes1.addLast(node.left);
                if (node.right != null) treeNodes1.addLast(node.right);
            }
            if (!control) {
                Collections.reverse(tmp);
            }
            result.add(tmp);
            control = !control;
            treeNodes = treeNodes1;
        }
        return result;

    }
}
