package leetcode.hot;

/**
 * LeetCode240.java
 * Description: https://leetcode.cn/problems/search-a-2d-matrix-ii/
 *
 * @author Peng Shiquan
 * @date 2022/10/6
 */
public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;

        for (int i = 0; i < m; i++) {
            int index = search(matrix[i], target);
            if (index >= 0) return true;
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int length = nums.length;
        if (target > nums[length - 1] || target < nums[0]) {
            return -1;
        }
        int low = 0, high = length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = n - 1;
        while (y >= 0 && x < m) {
            int num = matrix[x][y];
            if (num == target) {
                return true;
            } else if (num > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
