package factoryBean;

import org.springframework.beans.factory.FactoryBean;  

public class MyCarFactoryBean  implements FactoryBean<Car>{  
      
    private String  make;  
      
    private  int  year;  
  
    public void setMake(String make) {  
        this.make = make;  
    }  
  
    public void setYear(int year) {  
        this.year = year;  
    }  
  
    @Override  
    public Car getObject() throws Exception {  
        // TODO Auto-generated method stub  
          
        //Here  is a complex  car  object  created  
         // wouldn't be a very useful FactoryBean  
        // if we could simply instantiate the object!  
        Car  car  = new  Car();  
          
        if(year== 0){  
           car.setYear(100);  
        }  
          
        if("make".equals(make)){  
            car.setMake("we are making  bla bla  bla");  
        }else{  
            car.setMake(this.make);  
        }  
          
        return  car;  
    }  
  
    @Override  
    public Class<?> getObjectType() {  
        // TODO Auto-generated method stub  
        return Car.class;  
    }  
  
    @Override  
    public boolean isSingleton() {  
        // TODO Auto-generated method stub  
        return true;  
    }  
  
}  