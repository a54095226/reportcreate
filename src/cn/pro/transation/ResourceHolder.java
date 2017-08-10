package cn.pro.transation;



public class ResourceHolder {
    private static ThreadLocal<Object> resources= new ThreadLocal<Object>();  
    
    public static void addResource(Object value){  
            resources.set(value);  
  
    }  
      
    public static Object getResource(){  
          
        return resources.get();
    }  
      
    public static void clear(){  
        resources.remove();  

   }
}
