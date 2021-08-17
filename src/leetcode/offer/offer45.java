package leetcode.offer;

/**
 * offer45.java
 * Description: 把数组排成最小的数
 *
 * @author Peng Shiquan
 * @date 2021/8/17
 */
public class offer45 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        String result = new offer45().minNumber(nums);
        System.err.println(result);
    }

    public String minNumber(int[] nums) {
        int length = nums.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length - 1; i++) {
            String tmp1 = nums[i] + "";
            String tmp2 = nums[i + 1] + "";
            if ()
        }
    }
}
