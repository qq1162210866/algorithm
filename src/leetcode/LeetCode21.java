package leetcode;

/**
 * LeetCode21.java
 * Description:调整数组顺序使奇数位于偶数前面
 *
 * @author Peng Shiquan
 * @date 2021/7/17
 */
public class LeetCode21 {
    public static void main(String[] args) {
        LeetCode21 leetCode21 = new LeetCode21();
        int[] ints = new int[]{2, 4, 6};
        int[] ints1 = leetCode21.exchange2(ints);
        for (int i : ints1)
            System.out.printf(i + " ");
    }

    public int[] exchange(int[] nums) {
        //找到奇数的数量
        int length = nums.length;
        if (length == 0) return new int[0];
        int oddNum = 0;
        for (int i : nums)
            if (i % 2 == 1) oddNum++;
        int[] result = new int[length];
        int i = 0;
        int j = oddNum;
        for (int tmp : nums) {
            if (tmp % 2 == 1) {
                result[i] = tmp;
                i++;
            } else {
                result[j] = tmp;
                j++;
            }
        }
        return result;

    }

    public int[] exchange2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //主要是为了防止当前数组都为同一类型的数字时的情况
            while (left < right && nums[left] % 2 == 1) left++;
            while (left < right && nums[right] % 2 == 0) right--;
            if (left >= right) break;
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}
