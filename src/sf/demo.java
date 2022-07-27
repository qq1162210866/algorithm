package sf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class demo {
	/*
	 * 此方法是为了和其他的方法保持一致，和本算法无关
	 */
	public static void sort(Comparable[] a)
	{
		//快速排序
		//将原数组随机打乱
		List s = Arrays.asList(a);
		Collections.shuffle(s);
		Comparable[] b = (Comparable[]) s.toArray();//将数组转换为list,并将其打乱随机，最后在转换为数组
		//调用快速排序的算法，传入的是数组b
		sort(b, 0, a.length-1);
		//打印排序的结果，这里还是打印数组b
		for (int i = 0; i < a.length; i++) {
			System.out.print(b[i] + " ");
		}
	}
	public static void sort(Comparable[] a,int lo,int hi)
	{
		if(hi<=lo) return;
		int j=partition(a, lo, hi);//确定切点
		sort(a, lo,j-1);//切点左边排序。
		sort(a, j+1, hi);//切点右边排序
		
	}
	/*
	 * 快速排序的切分方法
	 */
	public static int partition(Comparable[] a,int lo,int hi)
	{
		int i=lo,j=hi+1;
		Comparable v=a[lo];//将随机的数组的第一个元素作为切分元素，将切分元素的值给v，方便后面的比较。
		//这里还是不清楚Comparable的用法
		/*
		 * 该接口定义类的自然顺序,实现该接口的类就可以按这种方式排序.一般要求:e1.equals((Object)e2)和e1.compareTo(
		 * (Object)e2)==0具有相同的值,这样的话我们就称自然顺序就和equals一致. 这个接口有什么用呢?
		 * 如果数据或者List中的元素实现了该接口的话,我们就可以调用Collections.sort或者Arrays方法给他们排序.
		 * 如果自然顺序和equals不一致的话,如果出现在Sorted Map和Set里面,
		 * 就会出现预想不到的逻辑错误,可能你调用add的时候添加不了,而集合里面确没有这个元素.具体的讨论要接口哈希表的应用.
		 */
		while (true) 
		{
			//1.注意++i和--j,先+。2.两个比较的先后顺序要注意 
			/*
			 * 算法的主体是找到两个分别大于和小于的位置，如果只有一个，另一个还是会找到，不过不在特定边
			 * 5,2,3,4,1
			 */
			while(less(a[++i], v))  if (i==hi) break;  //直到找到比v大的。
			while(less(v, a[--j]))  if (j==lo) break; //直到找到比v小的
			if (i>=j) break;//检查扫描是否完成
			exch(a, i, j);//将大于v的和小于v的交换。
			System.out.println("hah");
			for (int p = 0; p < a.length; p++) {
				System.out.print(a[p] + " ");
			}
		}
		exch(a, lo, j);//交换，将切分元素放到切分元素合适的位置
		return j;
		
	}

	private static boolean less(Comparable v, Comparable w) {
		// 比较用来排序的两个参数。根据第一个参数小于、等于或大于第二个参数分别返回负整数、零或正整数。
		// 如果v大于w，返回false,相等也是false
		return v.compareTo(w) < 0;

	}

	private static void exch(Comparable[] a, int i, int j) {
		// 交换位置
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String args[]) {
		// 1 2 4 6 7 7 8 23 55 56 90 
		Comparable[] a = {1,4,2,6,7,55,8,23,7,90,56};
		Comparable[] b = {5,2,3,4,1};
		/*
		 * 这里不清楚随机算法为什么不能放在sort函数中，有一些小bug
		 * 还是传入的参数问题，穿进去的数组a不是主函数的数组a
		 */
		int j=partition(b, 0, 4);
		System.out.println(j);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		//sort(a); 

	}

}
