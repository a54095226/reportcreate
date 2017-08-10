package cn.pro.test;

public class TestReject {
	private int no;
	protected int name;
	public int adr;
	static{
		System.out.println("静态模块加载！");
	}
	{
		System.out.println("非静态模块加载！");
	}
	public TestReject()
	{
		System.out.println("加载类！");
		no = 1;
		name = 1;
		adr = 1;
	}
	public void setNo(int no)
	{
		this.no = no;
	}
	public int getNo()
	{
		return  no;
	}
	
	public static void main(String[] arg) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		Class<?> testc = Class.forName("cn.pro.test.TestReject");
		testc.newInstance();

		
	}

}
