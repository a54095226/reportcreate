package cn.pro.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.pro.model.User;

public class LoginAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;   //第一种传递参数的方法
	private User user;        //第二种传递参数的方法              
	
	//在action服务器跳转中，所有的action都是共享一个值存储的空间，和servlet一样，如果一个servlet跳转到另一个servlet，他们是共享一个request存储的空间，
	//request其实是一个Theadlocal类，也就是一个线程map类，每一个线程共享一个request

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// all struts logic here
	public String add() {
		System.out.println("跳转到另一个action1");
       System.out.println(user.getName());
		return SUCCESS;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
