package acm.xunlian;

import java.util.*;

public class demo4 
{
	static Set set=new TreeSet();
	public static void main(String args[])
	{
		char[] a = "AA223344".toCharArray();//toCharArray()将字符串转换为字符数组
		f(a, 0);
		for(Object s: set) System.out.println(s);//循环遍历数组
		//2342A3A4答案
	    //按照字典的顺序来排列就是字典序
	}
	public static void test(char a[])
	{
		String s=new String(a);
		if(s.lastIndexOf("A")-s.indexOf("A")!=2) return;
		if(s.lastIndexOf("2")-s.indexOf("2")!=3) return;
		if(s.lastIndexOf("3")-s.indexOf("3")!=4) return;
		if(s.lastIndexOf("4")-s.indexOf("4")!=5) return;
		
		set.add(s);
	}
	public static void f(char a[],int k)//k为当前考虑的位置
	{
		if(k==a.length)
		{
			test(a);
			return;
		}
		for(int i=k;i<a.length;i++)
		{//这里就是全排列的问题，不过这里不是两个for循环，是i个for循环
			{char t=a[i]; a[i]=a[k]; a[k]=t;}
			f(a, k+1);
			{char t=a[i]; a[i]=a[k]; a[k]=t;}
		}
		
	}

}
