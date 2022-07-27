package sf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import java.lang.Math;

public class demo9 {
	/**
	 * @Title: demo9.java
	 * @Package sf
	 * @Description: 拉斯维加斯算法解决N后问题
	 * @author yanyu
	 * @date 2018年5月31日
	 */

	/**
	 * 主方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 输入数据
		System.out.println("请输入要求解的N后问题的N的个数");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// System.out.println(n);
		// 数据输入结束
		/*
		 * 解
		 * 
		 * 请输入皇后的个数： 4 2413 3142
		 */
		// 算法开始
		// 声明数组
		int[] a = new int[n];
		int[] c = new int[n];

		// 算法一次只能最多得到一个最优解，多次运行算法。
		
		for(int i=0;i<100;i++)
		{
			randomN(a, 2);
		}

	}

	/**
	 * 拉斯维加斯随机算法的主体
	 * 
	 * @param a
	 *            数组a，也是解集合
	 * @param bp
	 *            断点位置，回溯法和随机法的断点位置
	 * @return
	 */
	public static int[] randomN(int[] a, int bp) {
		/**
		 * 先使用随机法，在使用回溯法，随机放置的越多，失败的概率越大
		 */
		int count = 0;
		while (true && count == 0) {
			for (int i = 0; i < a.length; i++) {
				a[i] = randomnext(a.length);
				if (!placejudge(a, i))
					break;
				if (i == a.length - 1) {
					count = 1;
					break;
				}
			}
		}
		// 调用回溯法
		//tofb(a, bp-1, a.length);
		// 打印最优解
		for (int i = 0; i < a.length; i++)
			System.out.print((a[i] + 1) + " ");
		System.out.println();
		// 返回数组a
		return a;

	}

	/**
	 * 回溯法解决问题
	 * 
	 * @param a
	 * @param bp
	 * @return
	 */
	public static int[] tofb(int[] a, int k,int n) {
		if (k >= n) {
			// 打印结果
			return a;
		} else {
			for (int j = 1; j <= n; j++) {
				// System.out.println(k);
				// 将皇后的位置赋值给数组中的元素，相当于放置皇后
				a[k] = j;
				if (placejudge(a, k)) {
					// 递归下一个位置
					System.out.println("hah1");
					tofb(a, k+1, n);
				}
			}
			return a;
		}

	}

	/**
	 * 返回一个随机位置
	 * 
	 * @return
	 */
	public static int randomnext(int n) {
		// 生成0－（n+1）之间的随机数，不包括n+1
		Random rand = new Random();
		int randNum = rand.nextInt(n);
		return randNum;
	}

	/**
	 * 判断当前位置是否可以放入
	 * 
	 * @param a
	 * @param k
	 * @return
	 */
	public static boolean placejudge(int[] a, int k) {
		// 判断当前位置放入的是否正确
		for (int i = 0; i < k; i++)
			if (a[i] == a[k] || Math.abs(i - k) == Math.abs(a[i] - a[k]))
				return false;
		return true;
	}

	/**
	 * 
	 * @Description: 判断两个数组是不是相同
	 * @param @param
	 *            a
	 * @param @param
	 *            b
	 * @param @return
	 * @return boolean
	 * @throws @author
	 *             yanyu
	 * @date 2018年6月3日
	 */
	public static boolean intjudge(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				System.out.println("haha");
				return false;
			}
		}
		return true;

	}
}