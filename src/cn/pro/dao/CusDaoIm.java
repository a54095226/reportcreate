package cn.pro.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.pro.model.Customer;

public class CusDaoIm implements CusDao{
	
	
	
    /**
     * ӳ��sql�ı�ʶ�ַ�����
     * cus.getCus��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
     * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
     */
	//mybatis ��ʼ���Ĳ���
    // 1.���������ļ��ļ���Ϣװ��Configuration ����
	// 2.sqlsessionfactorybuild defaultsqlsessionfacry ������Configuration���� sqlsessionfactoryʵ��
	private SqlSessionFactory sessionFactory;
	//����ע��sqlfactory
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
		System.out.println("��������......");
        try {
        	System.out.println("��ʼ��������......");
			sqlsession.insert("cus.insertCus", cus);
			sqlsession.commit();

	
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			   System.out.println("�����������......"+e);
	           sqlsession.rollback();
			   System.out.println("�ع����......");
	
		}
        finally
        {
        	System.out.println("�ر����ݿ�����......");
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
