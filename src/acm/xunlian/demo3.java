package acm.xunlian;

import java.util.*;

public class demo3 
{
	public static void main(String args[])
	{
		 List lst = f("ABCDE");
	        for(int i=0; i<lst.size(); i++){
	            System.out.println(lst.get(i));
	        }
	        String  s="abcdefg";
	        String a=s.substring(0);
	        System.out.println(a);
	}
	public static List f(String s)
	{
		List list=new Vector<>();
		if(s.length()==1)//递归边界
		{
			list.add(s);
			return list;
		}
		for(int i=0;i<s.length();i++)
		{
			char x=s.charAt(i);
			List t=f(s.substring(0,i)+s.substring(i+1));//递归
			
			for(int j=0;j<t.size();j++)
			{
				list.add(""+x+t.get(j));
				
			}
			
			
			
		}
		return list;
		
	}
	
}
