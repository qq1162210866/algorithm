package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Offer07.java
 * Description: https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/19
 */
public class Offer07 {
    public static void main(String[] args) {

    }

    Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;
        if (preLength == 0 || inLength == 0) return null;
        indexMap = new HashMap<>(inLength);
        for (int i = 0; i < inLength; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preLength - 1, 0, preLength - 1);
    }


    /**
     * Description:
     *
     * @param preorder 前序遍历数组
     * @param inorder  中序遍历的数组
     * @param preLeft  当前树左子树开始的下标（前序数组）
     * @param preRight 当前数右子树结束的下标（前序数组）
     * @param inLeft   当前树左子树开始的下标（中序数组）
     * @param inRight  当前树右子树结束的下标（中序数组）
     * @return leetcode.offer.TreeNode
     * @author Peng Shiquan
     * @date 2022-10-19
     */
    public TreeNode build(int[] preorder, int[] inorder,
                          int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        int root = preorder[preLeft];
        int preRootIndex = preLeft;
        int inRootIndex = indexMap.get(root);
        TreeNode rootTree = new TreeNode(root);
        int leftTreeLength = inRootIndex - inLeft;
        rootTree.left = build(preorder, inorder,
                preRootIndex + 1, leftTreeLength + preRootIndex, inLeft, inRootIndex - 1);
        rootTree.right = build(preorder, inorder,
                leftTreeLength + preRootIndex + 1, preRight, inRootIndex + 1, inRight);
        return rootTree;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
