package processor;

import java.lang.reflect.Field;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest extends TestCase{

	
	private ApplicationContext context;  
	
	@BeforeClass
    protected void setUp() throws Exception {  
        super.setUp();  
        String[] paths = {"/processor/spring.xml"};  
  
        context = new ClassPathXmlApplicationContext(paths);  
          
    }  
    protected void tearDown() throws Exception {  
        super.tearDown();  
    } 
    
    @Test
    public void testBeanPostProcessor()  
    {  
          
    }  
    
    
    @Test
    public void testBeanFactoryPostProcessor()  
    {  
        //PostProcessorBean bean =(PostProcessorBean)ServiceLocator.getService("postProcessorBean");  
    	Student bean =(Student)context.getBean("student");  
        System.out.println("---------------testBeanFactoryPostProcessor----------------");  
        System.out.println("username:"+bean.getUsername());  
        System.out.println("password:"+bean.getPassword());
        
        try {
			Field field = bean.getClass().getDeclaredField("school");
			field.setAccessible(true);
			System.out.println(field.get(bean));;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        //  
    }  
    

}
