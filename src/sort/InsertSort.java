package sort;

/**
 * InsertSort.java
 * Description: 插入排序
 *
 * @author Peng Shiquan
 * @date 2021/7/13
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 7, 3, 4, 5, 6, 1, 2};
        insertSort(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void insertSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                BaseSort.swap(arr, j, j - 1);
                j--;
            }
        }
    }
}
