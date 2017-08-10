package cn.pro.transation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



public class ServerProxy implements InvocationHandler{
	
	/*自定义事务处理类
	 * */
    private Object tagit;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
	
	public void before()
	{
		

		System.out.println("连接创建....");
		if(ResourceHolder.getResource()==null)
		{

			System.out.println("创建新连接创建....");


			ResourceHolder.addResource(factory.openSession(false) );
		}
		sqlSession = (SqlSession)ResourceHolder.getResource();
	}
	public void after()
	{
		
		sqlSession.close();
		System.out.println("关闭数据库连接....");
	}
	public void  catchex()
	{
		
		sqlSession.rollback();
		System.out.println("数据回滚....");
	}
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		before();
		try{
		arg1.invoke(tagit, arg2);
		System.out.println("提交数据");
		
		sqlSession.commit();
		}
		catch(Exception e)
		{
			catchex();
		}
		finally
		{
		after();
		}
		return null;
	}
	public SqlSessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}
	public Object getTagit() {
		return tagit;
	}
	public void setTagit(Object tagit) {
		this.tagit = tagit;
	}
	public Object bind()
	{
		return Proxy.newProxyInstance(tagit.getClass().getClassLoader(), tagit.getClass().getInterfaces(), this);
	}

}
