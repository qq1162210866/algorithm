package acm.xunlian;

public class demo2 
{
	public static void main(String args[])
	{
		int a[]={4,2,2,1,1,3};
		f(a, 0, 5, "");
	}
	public static void f(int a[],int k,int n,String s)
	//a为各个国家的最大人数，k为当前要考虑的位置，n为当前可以放进去的人数，s为当前放进去的组合
	{
		if(k==a.length)//递归边界
		{
			if(n==0) System.out.println(s);
			return;
		}
		String s2=s;
		for(int i=0;i<=a[k];i++){
			f(a, k+1, n-i, s2);//这里k的位置要+1，n要-i,减去当前的人数   不是道为什么k要+1  n就要-i
			 s2 += (char)(k+'A');//
		}
	}

}
