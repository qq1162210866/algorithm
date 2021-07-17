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
        bubbleSort2(arr);
        for (int i : arr) {
            System.out.print(i);
        }

    }

    public static void bubbleSort1(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) BaseSort.swap(arr, j, j + 1);
            }
        }
    }

    public static void bubbleSort2(int[] arr) {
        boolean swaped = true;
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            //如果没有发生交换，代表当前数组有序，直接返回即可
            if (!swaped) break;
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    BaseSort.swap(arr, j, j + 1);
                    swaped = true;
                }
            }
        }
    }


}
