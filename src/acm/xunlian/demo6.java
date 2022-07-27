package acm.xunlian;

public class demo6 
{	
	//n是杨辉三角的行，m是杨辉三角的列
	public static int f(int n,int m)
	{
		if(m>n) return 0;
		if(n==1) return 1;
		if(m==1) return 1;
		
		return f(n-1, m-1)+f(n-1, m);
	}
	//n为输入,k为数组中的当前位置,a数组为缓冲输出
	public static void g(int n,int k,int a[])
	{
		if(n<=0)
		{
			for(int j=0;j<k;j++)
			{
				System.out.print(a[j]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=n;i>0;i--)
		{
			if(k>0 && i>a[k-1]) continue;//这里要注意i>a[k-1]的符号
			a[k]=i;
			//n-i是存进数组后剩下的项。如5存进数组中，剩下就是1
			g(n-i,k+1,a);//这里不清楚k+1和k++的区别。两者输出也不同
		}
	}
	public static void main(String args[])
	{
		int level=6;
		for(int j=1;j<10;j++){
			for(int i=1;i<=j;i++)		
				System.out.print(f(j, i)+" ");
			System.out.println();
		}
		int a[]=new int [1000];
		g(6,0,a);
		
		
	}
}
