package sf;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * 01背包问题，分支限界法
 */
public class demo8 {
	/*
	 * 主方法
	 */
	public static void main(String[] args) {
		//输入数据
		System.out.println("请输入背包的容量w和物品的个数n");
		Scanner reader = new Scanner(System.in);
		int w = reader.nextInt();// 背包的容量
		int n = reader.nextInt();// 物品的个数
		int solution=-1;
		BLBag[] p = new BLBag[n];
		System.out.println("请依次输入各个物品的重量w和价值v和名称s");
		int weigth;
		int value;
		String pid;
		for (int i = 0; i < n; i++) {
			pid = reader.next();
			weigth = reader.nextInt();
			value = reader.nextInt();
			p[i] = new BLBag(pid, weigth, value);
		}
		// 输入数据结束
		/*
		 * 数据
		 * 001 16 45 002 15 25 003 15 25
		 */
		// 算法开始
		//声明状态数组并初始化为空
		Integer[] a=new Integer[n];
		for(int i=0;i<n;i++) a[i]=null;
		//对p数组按权重排序
		sort(p);
		//打印结果
		int haha=branchandlimit(p, w,  a, solution);
		System.out.println("最优解为："+haha);
	}
	/*
	 * 权重排序，选择排序
	 */
	public static void sort(BLBag[] p) {
		BLBag t;
		for (int i = 0; i < p.length; i++) {
			int max = i;
			t = p[i];
			for (int j = i; j < p.length; j++) {
				if (t.wi < p[j].wi) {
					t = p[j];
					max = j;
				}
			}
			t = p[i];
			p[i] = p[max];
			p[max] = t;

		}
	}
	/*
	 * 求上界的函数   数组p 当前位置  当前背包重量    返回是最大价值（不包含背包的已有价值）
	 */
	public static double findbound(BLBag[] p,int i,int weight)
	{
		double value = 0;
		//将状态位后面的物品求贪心算法的解，上界函数的解为返回值+当前背包价值
		forLOOP:for(int k=i;k<p.length;k++)//循环名字
		{
			//贪心算法求解问题（修改版）
			if(p[k].weight<weight){
				value=value+p[k].value;
				weight=weight-p[k].weight;
			}else{
				double a=weight*p[k].wi;//当前价值				
				value=value+a;
				weight=0;
				break forLOOP;//跳出循环
			}
		}
		return value;
		
	}
	/*
	 * 分支限界法主体 参数分别为物品数组p，重量，价值，状态数组，当前考虑位置i ,最优解
	 */
	public static int branchandlimit(BLBag[] p,int weight,Integer[] a,double solution)
	{	
		//声明队列
		LinkedList<Node> nodelist=new LinkedList<Node>();
		LinkedList<Node> nodesolution=new LinkedList<Node>();
		nodelist.add(new Node(0, 0, 0));
		nodesolution.add(new Node(0,0,0));
		while(!nodelist.isEmpty())
		{
			//取出元素
			Node node = nodelist.pop();
			//判断条件，节点的不放入的最大值大于当前最优解，节点小于数组的长度
			//这里不用等于，必须要大于
			if(node.getUnbounvalue()+node.getCurrvalue()>solution && node.getIndex()<p.length)
			{				
				//左节点
				int leftWeight=node.getCurrweight()+p[node.getIndex()].weight;
				int leftvalue=node.getCurrvalue()+p[node.getIndex()].value;				
				Node left=new Node(leftWeight, leftvalue, node.getIndex()+1);
				//设置左节点的父节点
				left.setFather(node);
				left.setIsleft(true);
				//将左节点添加到最优解队列中
				nodesolution.add(left);
				//设置左节点的上界价值
				left.setUnbounvalue((int)findbound(p, node.getIndex(), weight-node.getCurrweight()));
				//左节点的重量小于等于背包的承重，且左节点的上界价值大于最优解
				if(left.getCurrweight()<=weight && left.getUnbounvalue()+left.getCurrvalue()>solution)
				{				
					//将节点加入队列中
					nodelist.add(left);
					a[node.getIndex()]=1;
					//将最优值重新赋值  条件就是节点的当前价值大于问题的最优解
					if(left.getCurrvalue()>solution)
					{
						solution=left.getCurrvalue();
						//System.out.println("放入的物品有："+p[node.getIndex()].pid);
					}
				}
				//右节点   右节点的设置不需要太多，和父节点差不多
				Node right=new Node(node.getCurrweight(), node.getCurrvalue(), node.getIndex()+1);
				//将右节点添加到最优解队列中
				right.setFather(node);
				right.setIsleft(false);
				nodesolution.add(right);
				right.setUnbounvalue((int)findbound(p,node.getIndex(),weight-node.getCurrweight()));
				//右节点的上界价值大于当前最优解
				if(right.getUnbounvalue()+node.getCurrvalue()>solution)
				{
					//添加右节点
					nodelist.add(right);
					a[node.getIndex()]=0;
				}
			}
		}
		
		/*
		 * 调用最优解方法
		 */
		pr(nodesolution,(int)solution,p);
		//返回最优解
		
		return (int) solution;
	}
	/**
	 * 
	 * @Description: 求解最优解的方法
	 * @param @param nodesolution   
	 * @return void  
	 * @throws
	 * @author yanyu
	 * @date 2018年5月21日
	 */
	//参数为
	public static void pr(LinkedList<Node> nodesolution,int solution,BLBag[] p)
	{
		int[] a=new int[p.length];
		Node prnode=null;
		//从list中循环遍历最优解的节点
		for(Node node:nodesolution)
		{
			if(node.getCurrvalue()==solution){
				//System.out.println("最优解的父节点的索引为："+node.getFather().getIndex());
				prnode=node;
			}
		}
		//循环遍历最优节点的父节点，判断其是否为左节点
		while (prnode.getFather()!=null) 
		{
			if(prnode.isIsleft())
			{
				a[prnode.getIndex()-1]=1;
			}
			prnode=prnode.getFather();
		}
		//打印
		for(int i=0;i<p.length;i++) 
		{
			if(a[i]==1) System.out.println("放入了物品："+p[i].pid);
		}
	}
	
	
}
/*
 * 背包类
 */
class BLBag {
	public int weight;// 重量
	public int value;// 价值
	public double wi;// 权重
	public String pid;// 背包名称
	public BLBag(String pid, int weight, int value) {
		this.weight = weight;
		this.value = value;
		this.pid = pid;
		this.wi = (double) value / weight;
	}
}
/**
 * 
 * ClassName: Node 
 * @Description: 节点类
 * @author yanyu
 * @date 2018年5月17日
 */
class Node
{
	//当前物品的属性
	private int currweight;//当前重量
	private int currvalue;//当前价值
	private int unbounvalue;//上界价值
	private int index;//索引
	private Node father;//父节点
	private boolean isleft;//是否为左节点
	public boolean isIsleft() {
		return isleft;
	}
	public void setIsleft(boolean isleft) {
		this.isleft = isleft;
	}
	public Node getFather() {
		return father;
	}
	public void setFather(Node father) {
		this.father = father;
	}
	public int getCurrweight() {
		return currweight;
	}
	public void setCurrweight(int currweight) {
		this.currweight = currweight;
	}
	public int getCurrvalue() {
		return currvalue;
	}
	public void setCurrvalue(int currvalue) {
		this.currvalue = currvalue;
	}
	public int getUnbounvalue() {
		return unbounvalue;
	}
	public void setUnbounvalue(int unbounvalue) {
		this.unbounvalue = unbounvalue;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	//构造函数
	public Node(int currweight,int currvalue,int index)
	{
		this.currweight=currweight;
		this.currvalue=currvalue;
		this.index=index;
	}
	
}