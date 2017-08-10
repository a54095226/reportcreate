package cn.pro.server;

import java.util.List;

import cn.pro.model.Customer;

public interface CusServer {
	
	public List<Customer> showCus();
	
	public void insertUser(Customer cs);



}
