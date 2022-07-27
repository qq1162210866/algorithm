package acm.ti;

public class demo2 
{
	public static void main(String[] args)
	{
		int n=0;
		int k=0;
		loop1:for(int i=1;i<=236;++i)
		{
			for(int j=236;j>1;--j)
			{
				//System.out.println(i);
				n=((i+j)*(j-i+1))/2;//递增公式
				//System.out.println(i+" "+j);
				if(n==236)
				{
					n=i;
					k=j;
					break loop1;
				}
			}
		}
		
		System.out.println(n+" "+k);
	}

}
