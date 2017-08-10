package cn.pro.action;


import com.opensymphony.xwork2.ActionSupport;

import cn.pro.model.User;

public class UserAction extends ActionSupport {
	
	private User user;    //第二种传递参数的方法
	
	public String add()
	
	{   System.out.println("执行第一个action");
		System.out.println(user.getName());
		System.out.println(user.getPass());
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
