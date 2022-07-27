package sflx;

public class demo3 {
    /**
     * @param n 图顶点个数
     * @param c 图的二维数组
     */
    public static void prim(int n,float [][] c){
        float [] lowcost=new float [n+1];
        int [] closest=new int [n+1];
        boolean [] s=new boolean[n+1];

        //初始化
        s[1]=true;      //以第一个节点为起点
        for(int i=2;i<=n;i++){
            lowcost[i]=c[1][i];
            closest[i]=1;
            s[i]=false;
        }

        for(int i=1;i<n;i++){   //循环n-1次找出剩余n-1个节点
            float min=Float.MAX_VALUE;
            int j=1;
            //找集合外与集合最近的节点
            for(int k=2;k<=n;k++){
                if((lowcost[k]<min)&&(!s[k])){
                    min=lowcost[k];
                    j=k;
                }
            }
            System.out.println("找到边"+j+","+closest[j]);

            s[j]=true;
            //找离j最近的节点k,寻找与集合最近的节点
            for(int k=2;k<=n;k++){
                if((c[j][k]<lowcost[k])&&(!s[k])){
                    lowcost[k]=c[j][k];     //记录权值
                    closest[k]=j;   //记录节点
                }
            }
        }
    }

    public static void main(String[] args){
        float [][] c={
                {100,100,100,100,100,100,100},
                {100,100,6,1,5,100,100},
                {100,6,100,5,100,3,100},
                {100,1,5,100,5,6,4},
                {100,5,100,5,100,100,2},
                {100,100,3,6,100,100,6},
                {100,100,100,4,2,6,100}};
        prim(6,c);
    }
}