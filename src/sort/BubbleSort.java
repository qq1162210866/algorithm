package sort;

/**
 * BubbleSort.java
 * Description: 冒泡排序
 *
 * @author Peng Shiquan
 * @date 2021/7/13
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 7, 3, 4, 5, 6, 1, 2};
        bubbleSort3(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    /**
     * Description: 排序算法基础版
     *
     * @param arr
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-08-15
     */
    public static void bubbleSort1(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) BaseSort.swap(arr, j, j + 1);
            }
        }
    }

    /**
     * Description: 优化了排序的条件判断
     *
     * @param arr
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-08-15
     */
    public static void bubbleSort2(int[] arr) {
        boolean swaped = true;
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            //如果没有发生交换，代表当前数组有序，直接返回即可
            if (!swaped) break;
            swaped = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    BaseSort.swap(arr, j, j + 1);
                    swaped = true;
                }
            }
        }
    }

    /**
     * Description: 记录排序的位置
     *
     * @param arr
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-08-15
     */
    public static void bubbleSort3(int[] arr) {
        /**
         *  当前循环是否交换
         */
        boolean swaped = true;
        /**
         * 当前循环的最后一个index
         */
        int lastIndex = arr.length - 1;
        /**
         * 最后交换的数组下标
         */
        int swapedIndex = -1;
        while (swaped) {
            swaped = false;
            //因为第一次的循环，交换的index只会到arr.length - 2,所以这里用小于
            for (int i = 0; i < lastIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    BaseSort.swap(arr, i, i + 1);
                    swaped = true;
                    swapedIndex = i;
                }
            }
            lastIndex = swapedIndex;
        }
    }
}
