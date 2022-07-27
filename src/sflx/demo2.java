package sflx;

import java.lang.reflect.Array;

public class demo2 {
    static float max = Float.MAX_VALUE;//
    //它应该叫做float类型能够表示的最小精度，定义一个max变量    

    /**
     * 
     * @param v 源
     * @param a 图
     * @param dist 路径长度的数组
     * @param prev 路径的数组，存储下一个节点
     */
    public static void dijkstra(int v, float[][] a, float[] dist, int[] prev) {
        // v是源，dist[i]表示当前从源到顶点i的最短特殊路径长度,prev[i]=j：最短路径中顶点i的前一个顶点是j，类似于链表
    	
    	
        int n = dist.length - 1;// 节点个数     ？为什么长度-1   这里的dist.length是二维数组中的一维长度，应当-1
        
        
        //判断返回条件
        if (v < 1 || v > n)
            return;
        
        
      //S是已经到达的顶点，V是没有到达的顶点。但是所有的节点都在数组s中
        boolean[] s = new boolean[n + 1];
        
        
        
        // 初始化
        for (int i = 1; i <= n; i++) {
            dist[i] = a[v][i];
            s[i] = false;
            if (dist[i] == Float.MAX_VALUE)
                prev[i] = 0;
            else
                prev[i] = v;
        }
        dist[v] = 0;
        s[v] = true;
        
        
        

        for (int i = 1; i < n; i++) {// 循环n-1次  为什么循环n-1次？
            float temp = Float.MAX_VALUE;
            System.out.print("xunhuan"+"  "  );
            int u = v;
            for (int j = 1; j <= n; j++) {// 寻找不在集合内且距离集合最近的节点j
                if ((!s[j]) && (dist[j] < temp)) {
                    u = j;// 记录节点
                    temp = dist[j];// 记录最短特殊路径长度
                }
            }
            s[u] = true;// 将节点u放入集合s   s集合就是s和v的集合体  真假来表示是在s中还是在v中

            
            
            
            
     
            for (int j = 1; j <= n; j++) {// 重新设置dist[]和prev[]的值
                if ((!s[j]) && (a[u][j] < Float.MAX_VALUE)) {// 寻找不在集合内，且可达的节点
                    float newdist = dist[u] + a[u][j];
                    if (newdist < dist[j]) { // 与旧值进行比较，保留小的值
                        dist[j] = newdist;
                        prev[j] = u;
                    }
                }
            }
            
            
            
            
            
        }
    }

    
    
    
    
    public static void main(String[] args) {
        float[][] a = { { max, max, max, max, max, max },
                { max, 0, 10, max, 30, 100 }, { max, max, 0, 50, max, max },
                { max, max, max, 0, max, 10 }, { max, max, max, 20, 0, 60 },
                { max, max, max, max, max, 0 } };
        int n = a.length;
        float[] dist = new float[n];
        int[] prev = new int[n];
        System.out.println(n);
        dijkstra(1, a, dist, prev);
        //函数是通过改变prve数组来实现算法的，将解放入数组中
        System.out.println(" 顶点1到5的最短路径：");
        trace(prev, 5);//只是打印数组
        System.out.println();
        System.out.println(" 顶点1到3的最短路径：");
        trace(prev, 3);
    }

    
    
    
    
    public static void trace(int[] prev, int n) {
        if (n == 1) {
            System.out.print(n + "aa ");
            return;
        }
        trace(prev, prev[n]);//递归调用  直到n==1
        System.out.print(n + " ");
    }
}
