package acm.xunlian;

public class demo5 
{
	public static int f(int a[],int end)
	{
		if(end<0)
		{
			return 0;
		}
		return f(a,end-1)+a[end];
		
	}
	public static int f(int a[],int min,int max)
	{
		int mid=(max+min)/2;
		if(mid==max){
			return a[max];
		}
		return f(a,min,mid)+f(a,mid+1,max);
		
	}
	public static void main(String args[])
	{
		int a[]={2,3,4,5,6,7,8,10};
		int i=f(a,0,7);
		System.out.println(i);
	}
	

}
