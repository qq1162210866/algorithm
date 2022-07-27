package sf;

import java.util.Scanner;

public class demo4 
{
	 static int title=1;
	 static int a[][]=new int[100][100];
	//tr，tc分别为当前棋盘的行号和列号。dr，dc为特殊方格的行号和列号。size为棋盘的大小。
	public static void qipanfugai(int tr,int tc,int dr,int dc,int size)
	{
		//递归边界
		if(size==1)//这里的size为上一层的s，当s为2时还要递归一次。再递归一次的时候t会被在加一次
		{
			return;
		}
		int t=title++;//覆盖棋盘的数字
		//System.out.println(t+"t被加了一次");
		int s=size/2;//s为将棋盘分割
		//递归主体
		//左上角棋盘覆盖
		if(dr<tr+s&&dc<tc+s){//特殊方格在左上角，下面也是一样
			qipanfugai(tr, tc, dr, dc, s);
			//System.out.println("哈哈");
		}else{
			a[tr+s-1][tc+s-1]=t;//用t覆盖右下角的方格
			qipanfugai(tr, tc, tr+s-1, tc+s-1, s);//递归给下一步，特殊方格的位置发生了变化
		}
		//右上角棋盘覆盖
		if(dr<tr+s&&dc>=tc+s){
			qipanfugai(tr, tc+s, dr, dc, s);
		}else{
			a[tr+s-1][tc+s]=t;
			qipanfugai(tr, tc+s, tr+s-1, tc+s, s);
		}
		//左下角棋盘覆盖
		if(dr>=tr+s&&dc<tc+s){
			qipanfugai(tr+s, tc, dr, dc, s);
		}else{
			a[tr+s][tc+s-1]=t;
			qipanfugai(tr+s, tc, tr+s, tc+s-1, s);
		}
		//右下角棋盘覆盖
		if(dr>=tr+s&&dc>=tc+s){
			qipanfugai(tr+s, tc+s, dr, dc, s);
		}else{
			a[tr+s][tc+s]=t;
			qipanfugai(tr+s, tc+s, tr+s, tc+s, s);
		}
		
	}
	public static void main(String args[])
	{
		System.out.println("请输入棋盘的大小和特殊方格的位置。输入格式为“4 2 2”");
		Scanner reader = new Scanner(System.in);
		int dr,dc,size;
		size=reader.nextInt();
		dr=reader.nextInt();
		dc=reader.nextInt();
		System.out.println();
		qipanfugai(0,0, dr, dc, size);//特殊方格没有动，所以一直为0
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
