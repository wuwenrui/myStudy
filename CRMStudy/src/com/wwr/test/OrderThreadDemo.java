package com.wwr.test;

public class OrderThreadDemo {

public int a = 0;
	
	boolean flag = false;
	
	public void writer(){
		a=1;
		flag=true;
	}
	
	public void reader(){
		if(flag){
			int i=a+1;
			System.out.println("i的值为"+i);
		}
	}

	public static class Thread1 implements Runnable{

		@Override
		public void run() {
			System.out.println("写线程更改数据");
			new OrderThreadDemo().writer();
		}
	}
	
	public static class Thread2 implements Runnable{

		@Override
		public void run() {
			System.out.println("读线程读取数据");
			new OrderThreadDemo().reader();
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Thread1()).start();
		new Thread(new Thread2()).start();
	}
	
	
	
}
