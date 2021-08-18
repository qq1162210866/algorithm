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
        int[] nums = new int[]{2, 1};
        String result = new offer45().minNumber(nums);
        System.err.println(result);
    }

    public String minNumber(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                String tmp1 = nums[j] + "";
                String tmp2 = nums[j + 1] + "";
                //排序的依据，即题目里面的意思。tmp1+tmp2>tmp2+tmp1  tmp1>tmp2
                if (Long.parseLong(tmp1 + tmp2) > Long.parseLong(tmp2 + tmp1)) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

}
