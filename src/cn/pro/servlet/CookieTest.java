package cn.pro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CookieTest extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
         HttpSession session = req.getSession(true);
         
         resp.setContentType("text/html");
         
         PrintWriter out = resp.getWriter();
         out.println("Session is new:"+session.isNew());
         out.println("<br/>");
         out.println("Session id:"+session.getId());
         
         out.println("<br/>");
         out.println("Request send Session :"+req.getRequestedSessionId());
         out.println("<br/>");
         out.println("Session from cookie:"+req.isRequestedSessionIdFromCookie());
         out.println("<br/>");
         out.println("Session from url:"+req.isRequestedSessionIdFromURL());
         out.println("<br/>");
         out.println("Session is valid:"+req.isRequestedSessionIdValid());
         out.println("<br/>");
         out.println("<a href="+resp.encodeURL("cookie")+">SHUAXIANG</a>");
         out.close();
         
	}

}
