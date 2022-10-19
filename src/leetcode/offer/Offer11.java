package leetcode.offer;

/**
 * Offer11.java
 * Description: https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/19
 */
public class Offer11 {
    public static void main(String[] args) {


    }

    public int minArray(int[] numbers) {
        int length = numbers.length;
        for (int i = 1; i < length; i++) {
            if (numbers[i] < numbers[i - 1]) return numbers[i];
        }
        return numbers[0];
    }

    public int minArray2(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else if (numbers[mid] < numbers[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return numbers[low];
    }

}
