package sf;

import java.util.Scanner;

//N后问题
public class demo7 
{
	public static int num=0;//累加和
	//判断当前位置是否正确
	public static Boolean judge(int[] p,int k)
	{
		for(int i=0;i<k;i++)
		{
			//绝对值的判定和列的判定。（不用判定行）
			if((Math.abs(i-k)==Math.abs(p[i]-p[k]))||(p[i]==p[k])) {
				return false;
			}	
		}
	  //要注意这个return的位置，在这里是为了让for循环能够一直循环下去，不被中间的位置打断，可以将
	  //这个return放到for循环中体验一下。会发现，解的个数会变多。
	  return true;
	}
	//算法主体  递归回溯 k为当前考虑位置
	public static void Queen(int[] p,int n,int k)
	{
		//这里的方法主体还是要多想一想
		if(k>=n)
		{
			num++;
			//打印结果
			for(int i=0;i<n;i++)
				System.out.print(p[i]);
			System.out.println("");
		}else{
			for(int j=1;j<=n;j++)
			{
				//System.out.println(k);
				//将皇后的位置赋值给数组中的元素，相当于放置皇后
				p[k]=j;
				if(judge(p, k))
				{
					//递归下一个位置
					Queen(p, n, k+1);
				}
			}
		}
	}
	public static void main(String[] args)
	{
		System.out.println("请输入皇后的个数：");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []p=new int[n];
		Queen(p,n,0);
		//将结果打印出来，如果只是打印这一个计数，程序的运行会快一点。
		System.out.println(n+"皇后问题的解共："+num+"种");
	}

}
