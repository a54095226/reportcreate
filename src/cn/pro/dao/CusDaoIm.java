package cn.pro.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.pro.model.Customer;

public class CusDaoIm implements CusDao{
	
	
	
    /**
     * 映射sql的标识字符串，
     * cus.getCus是userMapper.xml文件中mapper标签的namespace属性的值，
     * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
     */
	//mybatis 初始化的步骤
    // 1.根据配置文件文件信息装载Configuration 对象
	// 2.sqlsessionfactorybuild defaultsqlsessionfacry 方法从Configuration创建 sqlsessionfactory实例
	private SqlSessionFactory sessionFactory;
	//构造注入sqlfactory
	public CusDaoIm(SqlSessionFactory sessionFactory)
	{
		this.sessionFactory= sessionFactory;
	}
	public CusDaoIm()
	{
		
	}
	
	public Customer selectCusbyID(String id)
	{
		SqlSession sqlsession = sessionFactory.openSession();
		Customer cus = sqlsession.selectOne("cus.getCus", id);
		sqlsession.close();
		return cus;
	}
	
	public List<Customer> selectall()
	{
		SqlSession sqlsession = sessionFactory.openSession();
		List<Customer> listCus = sqlsession.selectList("getallCus");
		sqlsession.close();
		return listCus;
	}
	
	public void insert(Customer cus)
	{
		SqlSession sqlsession = sessionFactory.openSession();
		System.out.println("创建连接......");
        try {
        	System.out.println("开始插入数据......");
			sqlsession.insert("cus.insertCus", cus);
			sqlsession.commit();

	
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			   System.out.println("插入出现问题......"+e);
	           sqlsession.rollback();
			   System.out.println("回滚完成......");
	
		}
        finally
        {
        	System.out.println("关闭数据库连接......");
		sqlsession.close();
        }
	}
	
	public void update(Customer cus)
	{
		SqlSession sqlsession = sessionFactory.openSession();
        sqlsession.update("cus.updateCus", cus);
		sqlsession.commit();
		sqlsession.close();
	}
	
	

}
