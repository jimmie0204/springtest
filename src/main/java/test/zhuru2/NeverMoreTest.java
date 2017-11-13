package test.zhuru2;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NeverMoreTest {

	Logger log = LoggerFactory.getLogger(NeverMoreTest.class);
	
	@Test
	public void propertyPlaceholder2(){
		 	ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:test/zhuru2/spring2.xml");
		 	NeverMore neverMore = appContext.getBean(NeverMore.class);
		 	System.out.println(neverMore.getClass());
	        Assert.assertEquals(35.0, neverMore.getPrice());
	}
	
	
	
}
