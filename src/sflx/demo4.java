package sflx;

import java.util.Arrays;

//01背包问题
public class demo4 {
	// 算法
	public void test(Goods[] g,int n) {
		int newvalue=0;
		int [][] p=new int[g.length][n+1];
		//两次循环  i是当前背包重量 j是要放入的物品
		for (int i = 1; i <= n; i++) {
			for (int j=0;j<g.length;j++){
				if(j==0){
					if(g[j].getWeight()<=i){
						if(g[j].getValue()>p[j][i]) p[j][i]=g[j].getValue();
					}
					
				}else{
					//???
					p[j][i]=p[j-1][i];
					if(g[j].getWeight()>i) continue;
					newvalue=p[j-1][i-g[j].getWeight()]+g[j].getValue();
					p[j][i]=Math.max(newvalue, p[j][i]);
					
					//if(i==1&&j==2) System.out.println(newvalue);
				}
				
			}
		}//for循环结束
		
		for (int i = 0; i < p.length; i++) {
            System.out.println(Arrays.toString(p[i]));
        }

	}

	// 主方法
	 public static void main(String[] args){
		// 商品数组
		Goods[] g = { new Goods("a", 2, 6), new Goods("b", 2, 3),
				new Goods("c", 6, 5), new Goods("d", 5, 4),
				new Goods("e", 4, 6)};
		demo4 demo4=new demo4();
		demo4.test(g, 10);
	}
	

}

// 商品类
class Goods {
	private String name;
	private int weight;
	private int value;

	public Goods(String name, int weight, int value) {
		this.name = name;
		this.weight = weight;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public int getValue() {
		return value;
	}

	

}
