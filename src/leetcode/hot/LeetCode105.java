package leetcode.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode105.java
 * Description: https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/17
 */
public class LeetCode105 {
    public static void main(String[] args) {

    }

    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        //中序遍历不好查找，所以将这个使用map缓存
        for (int i = 0; i < length; i++) {
            inorderMap.put(inorder[i], i);
        }
        //构建树
        return build(preorder, inorder, 0, length - 1, 0, length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRiight) {
        //当左节点大于右节点时，代表构建完毕，返回null即可
        if (preorderLeft > preorderRight) {
            return null;
        }
        //分别找到先序和中序跟节点的下标
        int preorderRootIndex = preorderLeft;
        int inorderLRootIndex = inorderMap.get(preorder[preorderRootIndex]);
        TreeNode root = new TreeNode(preorder[preorderRootIndex]);
        //求左子树的长度
        int leftRootLength = inorderLRootIndex - inorderLeft;
        //注意各个参数开始和结束，其实就是各个遍历在本次递归中各个数的开始坐标和结束坐标
        root.left = build(preorder, inorder, preorderRootIndex + 1,
                preorderRootIndex + leftRootLength, inorderLeft, inorderLRootIndex - 1);
        root.right = build(preorder, inorder, preorderRootIndex + leftRootLength + 1,
                preorderRight, inorderLRootIndex + 1, inorderRiight);
        return root;
    }
}
