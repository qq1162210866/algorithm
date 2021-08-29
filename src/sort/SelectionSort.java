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
        int[] arr = new int[]{275, 322, 12, 2, 23, 12, 43, 123, 22, 3, 56, 34, 99, 12, 1232, 3, 14, 45, 22, 22, 11, 44, 74};
        selectionSort2(arr);
        for (int i : arr) {
            System.out.print(i + "，");
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

    public static void selectionSort2(int[] arr) {
        int length = arr.length;
        int minIndex, maxIndex;
        for (int i = 0; i < length; i++) {
            minIndex = maxIndex = i;
            for (int j = i + 1; j < length - i; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
                if (arr[j] > arr[maxIndex]) maxIndex = j;
            }
            if (minIndex == maxIndex) break;
            BaseSort.swap(arr, i, minIndex);
            //防止最大值为i的情况。
            if (maxIndex == i) {
                BaseSort.swap(arr, length - 1 - i, minIndex);
            } else {
                BaseSort.swap(arr, length - 1 - i, maxIndex);
            }
        }
    }
}
