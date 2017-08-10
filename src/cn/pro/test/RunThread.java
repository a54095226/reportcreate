package cn.pro.test;


public class RunThread implements Runnable {
	

	   private static int seqNum = 10;


	

	@Override
	public void run() {
		for(int i = 0 ;i<3;i++)
		{
			  seqNum--;
			  System.out.println(Thread.currentThread().getName() + "ÔËÐÐ  ThreadLocal= " +seqNum);
		}
		
	}

}
