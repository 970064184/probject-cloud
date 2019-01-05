package com.zhangbin.cloud.controller.test.innerclass;

public class TestInnerClass {
	
	public static void main(String[] args) {
		Animal animal = new Animal() {
			
			@Override
			public void jump() {
				System.out.println("动物跳");
			}
		};
		animal.jump();
		
		TestAnimal animal2 = new TestAnimal();
		animal2.jump(()->System.out.println("跳跳"));
				
		
		
		Fruit fruit = new Fruit() {
			
			@Override
			public void plant() {
				System.out.println("种植了"+this.getName());
			}
			
			@Override
			public String getName() {
				return "玫瑰";
			}
		};
//		fruit.getName();
//		fruit.plant();
		Framer framer = new Framer();
		framer.plant(fruit);
		
		
		Framer f = new Framer();
		f.plant(new Fruit() {
			
			@Override
			public void plant() {
				System.out.println("准备开种:"+this.getName());
			}
			
			@Override
			public String getName() {
				return "苹果";
			}
		});
		
		int[] a = new int[3];
		a[0] = 2;
		a[1] = 8;
		a[2] = 5;
		
		int[] i =  {1,2,3};
		System.out.println(i[2]);
		
	}
}
