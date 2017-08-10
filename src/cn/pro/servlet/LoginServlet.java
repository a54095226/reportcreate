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
	//servlet第一步执行init方法，第一次创建 Servlet时执行 在后续每次用户请求时不再调用
	
	 
    public void init()
	{
		System.out.println("初始化servlet！！！！！！！！！");
	}
    
    //servlet第二步执行server方法，根据get post提交的方式执行doGet或doPost方法
	public void doGet(HttpServletRequest request,  
            HttpServletResponse response)  
     throws ServletException,  
            IOException {  
		
		System.out.println("执行server doGet方法！！！！！！！！！");
        ServletContext context = getServletContext();  
        WebApplicationContext applicationContext  = WebApplicationContextUtils .getWebApplicationContext(context);   

        CusServer cusserver = (CusServer) applicationContext.getBean("cusServer");
        System.out.println("获取spring bean！！！！！！！！！ cusServer");
        
        System.out.println(cusserver.showCus().size());
          
        //服务器端打印信息  
        //System.out.println("username=" + username);  
        //System.out.println("password=" + password);  
        //设置编码格式  
        request.setAttribute("name",cusserver.showCus());
        request.getRequestDispatcher("/success.jsp").forward(request, response);
        }                     
    //重写doPost方法  
    public void doPost(HttpServletRequest request,  
            HttpServletResponse response)  
    throws ServletException,  
            IOException {  
        doGet(request, response);       
        
        
        //在 Servlet 生命周期结束时调用destroy()方法 destroy() 方法可以让您的 Servlet 关闭数据库连接、停止后台线程、把 Cookie 列表或点击计数器写入到磁盘，并执行其他类似的清理活动。
    }       

}
