package cn.pro.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.pro.dao.CusDao;
import cn.pro.server.CusServer;
import cn.pro.server.CusServerImp;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9201766216405744585L;
	//servlet��һ��ִ��init��������һ�δ��� Servletʱִ�� �ں���ÿ���û�����ʱ���ٵ���
	
	 
    public void init()
	{
		System.out.println("��ʼ��servlet������������������");
	}
    
    //servlet�ڶ���ִ��server����������get post�ύ�ķ�ʽִ��doGet��doPost����
	public void doGet(HttpServletRequest request,  
            HttpServletResponse response)  
     throws ServletException,  
            IOException {  
		
		System.out.println("ִ��server doGet����������������������");
        ServletContext context = getServletContext();  
        WebApplicationContext applicationContext  = WebApplicationContextUtils .getWebApplicationContext(context);   

        CusServer cusserver = (CusServer) applicationContext.getBean("cusServer");
        System.out.println("��ȡspring bean������������������ cusServer");
        
        System.out.println(cusserver.showCus().size());
          
        //�������˴�ӡ��Ϣ  
        //System.out.println("username=" + username);  
        //System.out.println("password=" + password);  
        //���ñ����ʽ  
        request.setAttribute("name",cusserver.showCus());
        request.getRequestDispatcher("/success.jsp").forward(request, response);
        }                     
    //��дdoPost����  
    public void doPost(HttpServletRequest request,  
            HttpServletResponse response)  
    throws ServletException,  
            IOException {  
        doGet(request, response);       
        
        
        //�� Servlet �������ڽ���ʱ����destroy()���� destroy() �������������� Servlet �ر����ݿ����ӡ�ֹͣ��̨�̡߳��� Cookie �б����������д�뵽���̣���ִ���������Ƶ�������
    }       

}
