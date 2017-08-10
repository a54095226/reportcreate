package cn.pro.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestFilter2 implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("TestFilter2 destroy!");
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("doFilter2 before!");
		arg2.doFilter(arg0, arg1);
		System.out.println("doFilter2 after!");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println(" init!");
		
	}

}
