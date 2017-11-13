package factoryBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {  
	   
	@Autowired
    private  Car  car;  
  
    public Car getCar() {  
        return car;  
    }  
  
    public void setCar(Car car) {  
        this.car = car;  
    }  
      
    public  String  toString(){  
          
        return  car.getMake()+"::::"+car.getYear();  
    }  
}  