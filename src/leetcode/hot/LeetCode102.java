package leetcode.hot;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode102.java
 * Description: https://leetcode.cn/problems/binary-tree-level-order-traversal/
 *
 * @author Peng Shiquan
 * @date 2022/9/17
 */
public class LeetCode102 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            Deque<TreeNode> treeNodesNew = new ArrayDeque<>();
            List<Integer> integers = new ArrayList<>();
            while (!treeNodes.isEmpty()) {
                TreeNode tmp = treeNodes.poll();
                integers.add(tmp.val);
                if (tmp.left != null) treeNodesNew.add(tmp.left);
                if (tmp.right != null) treeNodesNew.add(tmp.right);
            }
            result.add(integers);
            treeNodes = treeNodesNew;
        }
        return result;
    }
}
