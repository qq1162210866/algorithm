package acm;

public class demo2 
{
	public static  void main(String args[])
	{
		for(int n=1;n<=50;n++)
		{
			System.out.println(n);
			for(int x=1;x<=10;x++)
			{
				int k=0; 
				for (int i=0; i < x; i++) {
					k=k+i;
				}
				System.out.print((x*n+k)+" ");
			}
			System.out.println();
		}

	}
	
}
