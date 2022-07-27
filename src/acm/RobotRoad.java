package acm;

/**
 * RobotRoad.java
 * Description: 机器人走路算法
 *
 * @author Peng Shiquan
 * @date 2021/6/4
 */
public class RobotRoad {
    public static void main(String[] args) {
        System.err.println(robotRoad(2, 2));
    }

    /**
     * Description:求机器人走路的方式有多少种
     *
     * @param m 行数
     * @param n 列数
     * @return int
     * @Author Peng Shiquan
     * @Date 2021-06-04
     */
    public static int robotRoad(int m, int n) {
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i - 1][j] + a[i][j - 1];
                }
            }
        }
        return a[m - 1][n - 1];
    }
}
