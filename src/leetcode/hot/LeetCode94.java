package leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode94.java
 * Description: https://leetcode.cn/problems/binary-tree-inorder-traversal/
 *
 * @author Peng Shiquan
 * @date 2022/8/16
 */
public class LeetCode94 {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        result.addAll(inorderTraversal(root.left));

        result.add(root.val);

        result.addAll(inorderTraversal(root.right));

        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode predecessor = null;
        while (root != null) {
            if (root.left != null) {
                //先找到predecessor节点，即左子树中序遍历的最后一个节点
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                //判断predecessor节点右子树状态，只有两种情况，为null和predecessor右子树是当前root节点
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    //说明左子树全部遍历完毕
                    result.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }

            } else {
                //当左子树为null时，可以直接添加当前root值到结果集中
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }


}
