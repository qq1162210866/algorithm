package acm.ti;

public class demo1 
{
	public static void main(String[] args)
	{
		int [] a=new int [101];
		a[0]=0;
		int n=0;
		for(int i=1;i<=100;i++)
		{
			//System.out.println(i);
			a[i]=a[i-1]+i;
		}
		for(int j=0;j<=100;j++)
		{
			
			n=a[j]+n;
		}
		System.out.println(n);
		System.out.println(a[100]);
	}

}
