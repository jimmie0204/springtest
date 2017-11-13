package factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {  
	  public static void main(String[] args) {  
	      
	      ApplicationContext  context  = new  ClassPathXmlApplicationContext("/factoryBean/spring.xml");  
	        
	      Person  person =   (Person)context.getBean("person");  
	        
//		 Car  car =   (Car)context.getBean("car");  
//			        
//		 System.out.println(car);  
	    System.out.println(person);  
	  }  
	}  