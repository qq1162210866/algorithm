package sort;

/**
 * SelectionSort.java
 * Description: 选择排序
 *
 * @author Peng Shiquan
 * @date 2021/7/13
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 7, 3, 4, 5, 6, 1, 2};
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void selectionSort(int[] arr) {
        int length = arr.length;
        int minIndex = 0;
        //循环到数组到前一个元素即可。
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            BaseSort.swap(arr, i, minIndex);
        }
    }
}
