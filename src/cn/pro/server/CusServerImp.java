package cn.pro.server;

import java.util.List;


import cn.pro.dao.CusDao;
import cn.pro.dao.LogDao;
import cn.pro.model.Customer;

public class CusServerImp implements CusServer {
	
	
	private CusDao cusdao;
	private LogDao logDao;
    public  void setcusdaoppp(CusDao cusdao)  //set���������cusdaoppp��Ӧspring����bean��ע���nameֵ 
    {                                          //<property name="cusdaoppp" ref="cusDao" /> 
    	this.cusdao=cusdao;
    }
	

	@Override
	public List<Customer> showCus() {
		// TODO Auto-generated method stub
		return  cusdao.selectall();
		
	}


	public LogDao getLogDao() {
		return logDao;
	}


	public void setLogDao(LogDao logDAO) {
		this.logDao = logDAO;
	}
	
	public void insertUser(Customer cs)
	{
	

		logDao.insert("121");
		logDao.insert("221");
	}

}
