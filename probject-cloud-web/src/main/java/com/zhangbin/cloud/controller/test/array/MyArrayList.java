package com.zhangbin.cloud.controller.test.array;

import java.util.HashMap;
import java.util.Map;

public class MyArrayList<E> {
	
	transient Object[] elementData; 

    private int size;
    
	public MyArrayList() {
		this(10);
	}
	
	public MyArrayList(int initialCapacity){
		if(initialCapacity <0) {
			throw new RuntimeException("索引不能小于0");
//			 throw new IllegalArgumentException("Illegal Capacity: "+initialCapacity);
		}
		elementData = new Object[initialCapacity];
	}
	public boolean add (E e) {
		//数组扩容
		if(size >= elementData.length) {
			Object[] newArray = new Object[size * 2 +1];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		elementData[size++] = e;
		return true;
	}


	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<>(3);
		list.add("22");
		list.add("sds");
		list.add("dsds");
		list.add("dsd");
		System.out.println(list.size);
		Map<String, Object> map = new HashMap<>();
	}
}
