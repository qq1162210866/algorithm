package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode101.java
 * Description: 对称的二叉树
 *
 * @author Peng Shiquan
 * @date 2021/7/18
 */
public class LeetCode101 {
    Queue<TreeNode> treeNodes = new LinkedList<>();

    //复杂写法
    public boolean isSymmetric(TreeNode root) {
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            int length = treeNodes.size();
            Integer[] tmp = new Integer[length];
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = treeNodes.poll();
                if (treeNode == null) tmp[i] = Integer.MAX_VALUE;
                else tmp[i] = treeNode.val;
                treeNodes.add(treeNode != null ? treeNode.left : null);
                treeNodes.add(treeNode != null ? treeNode.right : null);
            }
            //左右指针判断
            int left = 0;
            int right = length - 1;
            while (left < right) {
                if (!tmp[left].equals(tmp[right])) return false;
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return root == null || reJudgment(root.left, root.right);
    }

    public boolean reJudgment(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        //交叉判断，根据镜像二叉树的特点得出的条件
        return reJudgment(left.left, right.right) && reJudgment(left.right, right.left);
    }

}
