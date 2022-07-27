package acm.xunlian;
//求第10001个素数
public class demo8 
{
	public static void f(int a)
	{
		
	}
	public static void main(String args[])
	{
		int N=1000*1000*10;
		int x=10001;
		byte a[]=new byte[N];
		for(int i=2;i<N/2;i++)//这里要注意两个for循环的结束条件
		{
			if (a[i]==1) continue;
			for(int k=2;k<=N/i;k++)
			{
				if(i*k<N) a[i*k]=1;//将i*k作为参数，如果i*k在数组a中，将i*k标记为1 即不是素数
			}
		}
		//打印第x个素数
		int m=0;
		for(int i=0;i<N;i++)
		{
			if (a[i]==0) 
			{
				m++;
				if(m==x) System.out.println(i+" ");
			}
		}
		System.out.println("m="+m);//计算数组a中有多少个素数
	}

}
