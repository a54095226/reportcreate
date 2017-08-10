package cn.pro.transation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



public class ServerProxy implements InvocationHandler{
	
	/*�Զ�����������
	 * */
    private Object tagit;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
	
	public void before()
	{
		

		System.out.println("���Ӵ���....");
		if(ResourceHolder.getResource()==null)
		{

			System.out.println("���������Ӵ���....");


			ResourceHolder.addResource(factory.openSession(false) );
		}
		sqlSession = (SqlSession)ResourceHolder.getResource();
	}
	public void after()
	{
		
		sqlSession.close();
		System.out.println("�ر����ݿ�����....");
	}
	public void  catchex()
	{
		
		sqlSession.rollback();
		System.out.println("���ݻع�....");
	}
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		before();
		try{
		arg1.invoke(tagit, arg2);
		System.out.println("�ύ����");
		
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
