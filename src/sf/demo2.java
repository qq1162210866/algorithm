package sf;
//二分法算法
import java.util.*;
public class demo2 
{
	public static int rank(int key,int[] a)
	{
		int lo=0;//左指针
		int hi=a.length-1;//右指针
		while (lo<=hi) 
		{
			//还有一种(hi-lo)/2+lo 和下面的一样
			int mid=(lo+hi)/2;
			if(key<a[mid])
				hi=mid-1;//移动右指针，不需要再次查找第mid个元素
			else if(key>a[mid])
				lo=mid+1;//移动左指针
			else
				return mid;
		}
		return -1;
	}
	public static void main (String args[])
	{
		//可以做一个排序的函数，这里只是简单的二分法
		int a[]={1,2,3,4,5,6,7,8};
		System.out.print(rank(5, a)+1);
	}

}
