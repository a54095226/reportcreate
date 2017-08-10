package cn.pro.test;

import java.io.IOException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.pro.dao.CusDao;
import cn.pro.model.Customer;
import cn.pro.server.CusServer;
import cn.pro.transation.ServerProxy;




public class Test {

	public static void main(String[] args) throws IOException {
		
		
		
       
/*    BeanFactory bf = (BeanFactory)new ClassPathXmlApplicationContext("cn/pro/config/myApplicationContext.xml");
    ServerProxy sp = (ServerProxy)bf.getBean("cusServerprox");
     Customer c =  new Customer();
     c.setCid("3");
     c.setId("003");
     c.setName("ddd");
    CusServer cs = (CusServer)sp.bind();
     cs.insertUser( c );
   //  CusDao cd = (CusDao) bf.getBean("cusDao");
  //   cd.insert(c);
   */
        RunThread r = new RunThread();
		Thread a = new MyThread(r);
		a.start();
		Thread b = new MyThread(r);
		b.start();

		


        
    }

	}


