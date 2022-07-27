package acm.xunlian;

public class demo7 
{
	//err_sum为错误和  a[]为输入  k为当前考虑项 arr_sum为当前累加和  b数组为储存当前项的状态
	public static void f(int err_sum,int arr_sum,int a[],int k,boolean b[])
	{
		if(arr_sum==err_sum)//先判断累加和是否等于错误和
		{
			for (int i = 0; i < b.length; i++) 
				if(b[i]) System.out.print(i+1+" ");
			System.out.println();
			return;
		}
		if(arr_sum>err_sum) return; //累加和超出
		if(k>=a.length) return;  //当前位置越界
		//验证第k个位置取还是不取，不用判断语句，错误直接回溯
		b[k]=false;//重置数组b的k位置的状态    先假设第k个位置不取  false为不取
		f(err_sum, arr_sum, a, k+1, b);//
		b[k]=true;
		arr_sum+=a[k];
		f(err_sum, arr_sum, a, k+1, b);
		//检验第k个位置后的回溯
		b[k]=false;
		
	}
	
	public static void main(String args[])
	{
		int err_sum=6;
		int a[]={3,2,4,3,1};
		boolean b[]=new boolean[a.length];
		f(err_sum,0,a,0,b);
	}

}
