package cn.pro.methed;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cn.pro.model.Customer;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadCus {
	
	
	public static boolean check(ArrayList<Customer> a,String e)
	{
		boolean bo=true;
		for(int i=0;i<a.size();i++)
		{
			if(e.equals("")||e.equals(a.get(i).getId()))
			{
				bo=false;	
			    break;
			}
		}
		return bo;
	}
	
	public static List<Customer> getuser()    
	  
    {   
  
        jxl.Workbook readwb = null;  
        ArrayList<Customer> a1 = new ArrayList<Customer>();
        
  
        try    
  
        {   
  
            //����Workbook����, ֻ��Workbook����   
  
            //ֱ�Ӵӱ����ļ�����Workbook   
  
            InputStream instream = new FileInputStream("webcontent/file-src/������������ϸ����20160614.xls");   
  
            readwb = Workbook.getWorkbook(instream);   
  
    
  
            //Sheet���±��Ǵ�0��ʼ   
  
            //��ȡ��һ��Sheet��   
  
            Sheet readsheet = readwb.getSheet(0);   
  
            //��ȡSheet������������������   
  
           // int rsColumns = readsheet.getColumns();   
  
            //��ȡSheet������������������   
  
            int rsRows = readsheet.getRows();   
  
            //��ȡָ����Ԫ��Ķ�������   
            
            
  
            for (int i = 0; i < rsRows; i++)   
  
            {   
            	
            	Cell cell = readsheet.getCell(1, i);   
            	Cell cell2 = readsheet.getCell(2, i);
            	Cell cell3 = readsheet.getCell(3, i);
            	String ki = cell.getContents();
            	String de = cell2.getContents();
            	String name = cell3.getContents();
            	Customer sk = new Customer();
            	if(check(a1,ki))
            		{
            		sk.setId(ki);
            		sk.setCid(de);
            		sk.setName(name);
            		
            		a1.add(sk);
            		}
  

  
            }   
            
            //�����Ѿ�������Excel������,�����µĿ�д���Excel������   
          
  

  
        } catch (Exception e) {   
  
            e.printStackTrace();   
  
        } finally {   
  
            readwb.close();   
  
        }   
        return  a1;
  
}   

}
