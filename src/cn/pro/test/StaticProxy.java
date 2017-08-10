package cn.pro.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StaticProxy implements InvocationHandler {
	private Object userserver ;
    public void change(int j)
    {
    	j++;
    	System.out.println(j);
    }
    public void change(Testint j)
    {
    	j.i++;
    	System.out.println(j.i);
    }
	public Object bind(Object userserver)
	{
		this.userserver = userserver;
		return Proxy.newProxyInstance(this.userserver.getClass().getClassLoader(), this.userserver.getClass().getInterfaces(), this);
	}

	public void log(Method arg1)
	{
		System.out.println(arg1+"log methed.....");
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		log(arg1);
		arg1.invoke(userserver, arg2);
		return null;
	}
	
	public static void main(String[] args)
	{
		StaticProxy hander = new StaticProxy();
        UserServer us = (UserServer)hander.bind(new UserServerImp());
        us.save();

	}

}
