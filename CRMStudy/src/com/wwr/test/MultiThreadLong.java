package com.wwr.test;

public class MultiThreadLong {

	public static long t=0;
	/**
	 * 数据变更线程
	 * @author wuwenrui
	 *
	 */
	public static class ChangeT implements Runnable{

		private long to;
		
		public ChangeT(long to){
			this.to=to;
		}
		
		@Override
		public void run() {
			while(true){
				MultiThreadLong.t=to;
				Thread.yield();
			}
		}
		
	}
	
	/**
	 * 数据读取线程
	 * @author wuwenrui
	 *
	 */
	public static class ReadT implements Runnable{

		@Override
		public void run() {
			while(true){
				long tmp = MultiThreadLong.t;
				if(tmp!=111L && tmp!=-999L && tmp!=333L && tmp!=-444L)
					System.out.println(tmp);
				Thread.yield();
			}
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("开始");
		new Thread(new ChangeT(111L)).start();
		new Thread(new ChangeT(-999L)).start();
		new Thread(new ChangeT(333L)).start();
		new Thread(new ChangeT(-444L)).start();
		new Thread(new ReadT()).start();
		System.out.println("结束");
	}
	
}
