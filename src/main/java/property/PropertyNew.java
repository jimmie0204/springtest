package property;

import org.junit.Test;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;

public class PropertyNew {

	@Test  
	public void test() {  
	    //会自动注册 System.getProperties() 和 System.getenv()  
	    Environment environment = new StandardEnvironment();  
	    System.out.println(environment.getProperty("file.encoding"));  
	}  
}
