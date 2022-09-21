package sort;

import java.util.Arrays;

/**
 * QuickSort.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2022/9/21
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{43, 322, 12, 2, 23, 12, 275, 123, 22, 3, 56, 34, 99, 12, 1232, 3, 14, 45, 22, 22, 11, 44, 74};
        sort2(arr, 0, arr.length - 1);
        System.err.println(Arrays.toString(arr));
    }

    /**
     * Description: 快速排序基础版
     *
     * @param nums
     * @return void
     * @author Peng Shiquan
     * @date 2022-09-21
     */
    public static void sort(int[] nums, int left, int right) {
        if (left >= right) return;
        int j = partition2(nums, left, right);
        sort(nums, left, j - 1);
        sort(nums, j + 1, right);
    }

    //博客上的partition方法，现在有些细节看不懂
    public static int partition(int[] nums, int left, int right) {
        //以左边第一个元素为锚定元素
        int num = nums[left];
        int i = left;
        int j = right + 1;
        while (true) {
            while (nums[++i] < num) if (i >= right) break;
            while (nums[--j] > num) if (j <= left) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    public static int partition2(int[] nums, int left, int right) {
        // 以 nums[l] 作为基准数
        int i = left, j = right;
        while (i < j) {
            //为什么这两个换位置就不对了？
            //再最后一次判断，如果返回i，j--就满足条件了
            while (i < j && nums[j] >= nums[left]) j--;
            while (i < j && nums[i] <= nums[left]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }

    /**
     * Description: 基于三项切分的快速排序
     *
     * @param nums
     * @param left
     * @param right
     * @return void
     * @author Peng Shiquan
     * @date 2022-09-21
     */
    public static void sort2(int[] nums, int left, int right) {
        if (left >= right) return;
        //left到p0-1为小于num数字，p2+1到right为大于num的数字
        int p0 = left, i = left + 1, p2 = right;
        int num = nums[left];
        //要遍历所有的位置，所以需要=p2
        while (i <= p2) {
            if (nums[i] > num) {
                swap(nums, i, p2);
                p2--;
            } else if (nums[i] == num) {
                i++;
            } else {
                swap(nums, i, p0);
                p0++;
                i++;
            }
        }
        sort2(nums, left, p0 - 1);
        sort2(nums, p2 + 1, right);
    }


    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
