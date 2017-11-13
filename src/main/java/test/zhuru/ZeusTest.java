package test.zhuru;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ZeusTest {

	Logger log = LoggerFactory.getLogger(ZeusTest.class);
	
	@Test
	public void propertyPlaceholder(){
		 	ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:test/zhuru/spring.xml");
	        Zeus zeus = appContext.getBean(Zeus.class);
	        Assert.assertEquals("666", zeus.getName());
	        log.info(zeus.getName());
	}
	
	
	
}
