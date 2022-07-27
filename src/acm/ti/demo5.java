package acm.ti;

public class demo5
{
	public static void f(int[] a, int k, int n, String s)//k    n是最多五人  s是数组
	{
		if(k==a.length){ 
			if(n==0) System.out.println(s);
			return;
		}
		
		String s2 = s;
		for(int i=0; i<=a[k]; i++){
			//f(a,k+1,5-s2.length(),s2);   //填空位置
			s2 += (char)(k+'A');
		}
	}
	
	public static void main(String[] args)
	{
		int[] a = {4,2,2,1,1,3};
		//数组a[] 中既是每个国家可以派出的最多的名额
		f(a,0,5,"");
	}
}
