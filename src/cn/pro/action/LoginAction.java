package cn.pro.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.pro.model.User;

public class LoginAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;   //��һ�ִ��ݲ����ķ���
	private User user;        //�ڶ��ִ��ݲ����ķ���              
	
	//��action��������ת�У����е�action���ǹ���һ��ֵ�洢�Ŀռ䣬��servletһ�������һ��servlet��ת����һ��servlet�������ǹ���һ��request�洢�Ŀռ䣬
	//request��ʵ��һ��Theadlocal�࣬Ҳ����һ���߳�map�࣬ÿһ���̹߳���һ��request

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// all struts logic here
	public String add() {
		System.out.println("��ת����һ��action1");
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
