package com.zhangbin.cloud.controller.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestBaseJava {
	
	public static void main(String[] args) {
//		test5();
//		test4();
//		test3();
//		test2();
//		test();
//		test1();
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("d");
		set.add("e");
		System.out.println(set.size());
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		for (Iterator iterator2 = set.iterator(); iterator2.hasNext();) {
			String string = (String) iterator2.next();
			System.out.println(string);
		}
		
	}
	
	private static void test4() {
		int x = 1,y = 1;

		if(x++==1 | ++y==1)
		{
		x =7;
		}
		System.out.println("x="+x+",y="+y); 
	}
	private static void test5() {
		int x = 1,y = 1;
		
		if( ++y==1 || x++==1)
		{
			x =7;
		}
		System.out.println("x="+x+",y="+y); 
	}
	private static void test3() {
		int x = 1,y = 1;

		if(x++==1 || ++y==1)
		{
		x =7;
		}
		System.out.println("x="+x+",y="+y); 
	}
	
	private static void test2() {
		/*int x = 1,y = 1;

		if(x++==2 && ++y==2)
		{
		x =7;
		}
		System.out.println("x="+x+",y="+y);*/
		/*int x = 1,y = 1;

		if(x++==1 & ++y==1)
		{
		x =7;
		}
		System.out.println("x="+x+",y="+y); */
		int x = 1,y = 1;

		if(x++==1 && ++y==1)
		{
		x =7;
		}
		System.out.println("x="+x+",y="+y); 
	}
	private static void test() {
		int x = 1,y = 1;

		if(x++==2 & ++y==2) {
		x =7;
		}
		System.out.println("x="+x+",y="+y); 
	}
	private static void test1() {
		int i = 1;
		i = i++;
		System.out.println("i="+i);
		int j = i++;
		System.out.println("i="+i);
		System.out.println("j="+j);
		int k = i+ ++i*i++;
		System.out.println("i="+i);
		System.out.println("j="+j);
		System.out.println("k="+k);
		
		int count =0;
		for(int m=0;m<100;m++) {
			count = count++;
		}
		System.out.println("count="+count);
		
		int x = 5, y = 6, z;
		x = ++x + x++;
//		z = x > y ? ++x : y++; 
		System.out.println("x="+x);
		System.out.println("y="+y);
//		System.out.println("z="+z);
	}
}
