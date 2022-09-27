package leetcode.hot;

/**
 * LeetCode96.java
 * Description: https://leetcode.cn/problems/unique-binary-search-trees/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/24
 */
public class LeetCode96 {
    public static void main(String[] args) {
        System.err.println(new LeetCode96().numTrees(3));
    }

    public int numTrees(int n) {
        int[] result = new int[n + 1];
        //前面简单的都可以直接推导出来
        result[0] = 1;
        result[1] = 1;
        //G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)   重要的公式
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //其实就是左边部分乘以右边部分
                result[i] += result[i - j] * result[j - 1];
            }
        }
        return result[n];
    }
}
