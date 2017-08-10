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
  
            //构建Workbook对象, 只读Workbook对象   
  
            //直接从本地文件创建Workbook   
  
            InputStream instream = new FileInputStream("webcontent/file-src/工作簿消费明细完整20160614.xls");   
  
            readwb = Workbook.getWorkbook(instream);   
  
    
  
            //Sheet的下标是从0开始   
  
            //获取第一张Sheet表   
  
            Sheet readsheet = readwb.getSheet(0);   
  
            //获取Sheet表中所包含的总列数   
  
           // int rsColumns = readsheet.getColumns();   
  
            //获取Sheet表中所包含的总行数   
  
            int rsRows = readsheet.getRows();   
  
            //获取指定单元格的对象引用   
            
            
  
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
            
            //利用已经创建的Excel工作薄,创建新的可写入的Excel工作薄   
          
  

  
        } catch (Exception e) {   
  
            e.printStackTrace();   
  
        } finally {   
  
            readwb.close();   
  
        }   
        return  a1;
  
}   

}
