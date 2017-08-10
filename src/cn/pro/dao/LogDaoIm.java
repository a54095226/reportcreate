package cn.pro.dao;

import org.apache.ibatis.session.SqlSession;

import cn.pro.transation.ResourceHolder;

public class LogDaoIm implements LogDao{
	public void insert(String name)
	{   
		SqlSession sqlsession = (SqlSession)ResourceHolder.getResource();
		sqlsession.insert("cus.insertlog", name);
		throw new RuntimeException("Exception");
	}

}
