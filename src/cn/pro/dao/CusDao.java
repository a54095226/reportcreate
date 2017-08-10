package cn.pro.dao;

import java.util.List;

import cn.pro.model.Customer;

public interface CusDao {
	
	public Customer selectCusbyID(String id);
	public void insert(Customer cus);
	public void update(Customer cus);
	public List<Customer> selectall(); 
	

}
