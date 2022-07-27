package sf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//排序算法
//
public class demo3 
{
	//Comparable是一个接口，现在具体还不清楚
	//具体排序算法的实现
/*	public static void sort(Comparable[] a)
	{
		//选择排序
		int N=a.length;
		for(int i=0;i<N;i++)
		{
			//标记单元
			int min=i;
			for(int j=i+1;j<N;j++)
			{
				if(less(a[j], a[min]))
				{
					//交换这里要换点心思
					min=j;
				}
			}
			exch(a, i, min);//提供的是要交换的数组中的数字的位置
		}
	}
*/
		
/*	public static void sort(Comparable[] a)
		{
		//插入排序 
		//用一个数组完成插入排序的算法，将a数组中前面和后面分成两个部分
		int N=a.length;
		//这里不用考虑a[i]数组中只有一个元素的情况，所以直接从1开始。
		for(int i=1;i<N;i++)//为什么要从1开始，因为插入要有一个数组，那个一就是开始的数组
		{
			//建立数组a[i],再用j循环找出j再a[i]中的数组位置
			for(int j=i;j>0 && less(a[j], a[j-1]);j--)//比较位置，交换相邻的两个数字。不是严格意义上的插入排序
			{
				exch(a, j, j-1);
			}
		}
		}
*/
	
/*	public static void sort(Comparable[] a)
			{
		//希尔排序        插入排序对于有序的数组排序比较快   希尔排序就是利用这一点
		int N=a.length;
		int h=1;//h有序数组
		//1,4,13,40,121,364,1093。。。定义h的大小，直到符合标准   3.6
		while (h<N/3) h=3*h+1;//为什么是N/3?  克努特的步长序列 保证有序数组中的元素最少为三个
		while(h>=1)
		{
			for(int i=h;i<N;i++)
			{
				for(int j=i;j>=h && less(a[j], a[j-h]);j-=hj=j-h)
					exch(a, j, j-h);
			}
			System.out.println(h);
			//舍入除，取小值
			h=h/3;//最后肯定会变成0，也会跳出循环
			
			
		}
*/
		
/*	public static void sort(Comparable[] a)
	{
		//自顶向下的归并排序            用到了归并，但是小规模的排序可以用选择和插入排序。大规模用到了归并
		sort(a, 0,a.length-1);	
		
	}
	public static void sort(Comparable[] a,int lo,int hi)
	{
		//用的分治的思想
		if(hi<=lo) return;
		int mid=(lo+hi)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
*/
	
	
/*	public static void sort(Comparable[] a)
	{
		//自底向上的归并排序
		int N=a.length;
		for(int sz=1;sz<N;sz=sz+sz)//sz=1并不是指子数组长度为一，只是状态为第一种状态
			//sz=sz+sz  可以改写为sz=sz*2
		{
			for(int lo=0;lo<N-sz;lo+=sz+sz)//lo+=sz+sz等同于lo=lo+sz+sz
				//lo一定小于N  lo为最左边的数组第一个元素的位置，所以要小于N-sz
			{
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));//归并排序。最后一个参数是最右边的数组的位置
				//这里取最小的函数是为了考虑最后一种情况，最后一个数组的长度小于sz。要不然会数组越界
			}
		}
		
	}
*/
	public static void sort(Comparable[] a)
	{
		//快速排序
		
		
		sort(a, 0, a.length-1);
	}
	public static void sort(Comparable[] a,int lo,int hi)
	{
		if(hi<=lo) return;
		int j=partition(a, lo, hi);//确定切点
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println(" "+1111);
		System.out.println(j);
		sort(a, lo,j-1);//切点左边排序。
		sort(a, j+1, hi);//切点右边排序
		
	}
	
	
	
	
	private static boolean less(Comparable v,Comparable w)
	{
		//比较用来排序的两个参数。根据第一个参数小于、等于或大于第二个参数分别返回负整数、零或正整数。
		//如果v大于w，返回false
		return v.compareTo(w)<0;
		
	}
	public static void exch(Comparable[] a,int i,int j)
	{
		//交换位置
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	/*
	 * 原地归并数组的方法
	 */
	private static void merge(Comparable[] a,int lo,int mid,int hi)
	//lo是左最小 mid是左最大 mid是右最小  hi是右最大
	{
		Comparable[] aux = new Comparable[a.length];//这里声明要用到的辅助数组，辅助数组的实现对于算法没有太大的影响
		int i=lo , j=mid+1;//定义两个子数组的开始位置
		for(int k=lo;k<=hi;k++)//复制数组
		{
			aux[k]=a[k];
		}
		for(int k=lo;k<=hi;k++)
		{
			if     (i>mid)                a[k]=aux[j++];//j++等同于j=j+1
			else if(j>hi)                 a[k]=aux[i++];
			else if(less(aux[j], aux[i])) a[k]=aux[j++];//右边小于左边，取右边元素
			else                          a[k]=aux[i++];
		}
		
	}
	/*
	 * 快速排序的切分方法
	 */
	public static int partition(Comparable[] a,int lo,int hi)
	{
		int i=lo,j=hi+1;
		Comparable v=a[lo];//这里还是不清楚Comparable的用法
		//System.out.println(v);
		/*
		 * 该接口定义类的自然顺序,实现该接口的类就可以按这种方式排序.一般要求:e1.equals((Object)e2)和e1.compareTo(
		 * (Object)e2)==0具有相同的值,这样的话我们就称自然顺序就和equals一致. 这个接口有什么用呢?
		 * 如果数据或者List中的元素实现了该接口的话,我们就可以调用Collections.sort或者Arrays方法给他们排序.
		 * 如果自然顺序和equals不一致的话,如果出现在Sorted Map和Set里面,
		 * 就会出现预想不到的逻辑错误,可能你调用add的时候添加不了,而集合里面确没有这个元素.具体的讨论要接口哈希表的应用.
		 */
		while (true) 
		{
			while(less(a[++i], v))  if (i==hi) break;  //
			while(less(v, a[--j]))  if (j==lo) break; //两个比较的先后顺序要注意
			if (i>=j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
		
	}
	
	//主方法
	public static void main(String args[])
	{
		//1,4,2,6,7,55,8,23,7,90,56   11
		//Comparable[]a={1,4,2,6,7,55,8,23,7,90,56};
		//1 1 2 2 2 4 4 5 5 7 
		Comparable[]a={1,2,3,4,5 , 7,8,6,9,0};
		/*
		 * 这里不清楚随机算法为什么不能放在sort函数中，有一些小bug
		 */
		List s = Arrays.asList(a);
		Collections.shuffle(s);
		a = (Comparable[]) s.toArray();//将数组转换为list,并将其打乱随机，最后在转换为数组
		sort(a);
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		
	}

}
