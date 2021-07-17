package sort;

/**
 * BaseSort.java
 * Description: 基础排序类，提供一些基础的方法
 *
 * @author Peng Shiquan
 * @date 2021/7/13
 */
public class BaseSort {
    /**
     * Description: 将数组两个位置交换
     *
     * @param arr
     * @param i
     * @param j
     * @return void
     * @Author Peng Shiquan
     * @Date 2021-07-13
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
