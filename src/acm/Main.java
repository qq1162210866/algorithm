package acm;
import java.math.BigDecimal;
import java.util.Scanner;
public class Main 
{
	//http://dilegencehe.blog.163.com/blog/static/43255413201111178523181/
		//向上取整用Math.ceil(double a)
		//向下取整用Math.floor(double a)
	 public static void main(String args[])
	 {
		 Scanner reader = new Scanner(System.in);
		 int n=reader.nextInt();
		 //do PI=(float)3.14159265358979323;
		 //System.out.println(n*PI);
		 double f=Math.PI*n*n;
		 BigDecimal b=new BigDecimal(f);
		 double f1=b.setScale(7,BigDecimal.ROUND_HALF_UP).doubleValue();
		 System.out.println(f1);
			
			
	 }

}
