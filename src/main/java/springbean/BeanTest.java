package springbean;

import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

	
	@Test
	public void testGetBean(){
		ApplicationContext ac = new  ClassPathXmlApplicationContext("/springbean/spring.xml");
		A a = (A)ac.getBean("kk");
		A a2 = (A)ac.getBean("nn");
		System.out.println(a);
		System.out.println(a2);
	}
	
	@Test
	public void myBean(){
		ApplicationContext ac = new  ClassPathXmlApplicationContext("/springbean/spring.xml");
		//将applicationContext转换为ConfigurableApplicationContext
	    ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) ac;
	    
	    // 获取bean工厂并转换为DefaultListableBeanFactory
	    DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext
	        .getBeanFactory();
	    
	    // 通过BeanDefinitionBuilder创建bean定义
	    BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
	        .genericBeanDefinition(B.class);
	    // 设置属性userAcctDAO,此属性引用已经定义的bean:userAcctDAO
	    beanDefinitionBuilder
	        .addPropertyReference("a", "nn");

	    // 注册bean
	    defaultListableBeanFactory.registerBeanDefinition("bbb",
	        beanDefinitionBuilder.getRawBeanDefinition());
	    
		B b = (B)ac.getBean("bbb");
		System.out.println(b);
		System.out.println(b.getA());
		
		//注入两个A.class,一个是通过xml配置注入（id=nn），另一种通过如下方式注入(id=nn1)
		AbstractBeanDefinition bean = BeanDefinitionBuilder.genericBeanDefinition(A.class).getBeanDefinition();
		 // 注册bean
	    defaultListableBeanFactory.registerBeanDefinition("nn1",
	    		bean);
	    A a = (A)ac.getBean("nn1");
	    System.out.println(a);
	}

	@Test
	public void testChangeBeanKey(){
		ApplicationContext ac = new  ClassPathXmlApplicationContext("/springbean/spring.xml");
		//将applicationContext转换为ConfigurableApplicationContext
	    ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) ac;
	    
	    // 获取bean工厂并转换为DefaultListableBeanFactory
	    DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext
	        .getBeanFactory();
	    
		BeanDefinition bean = new ChildBeanDefinition("nn");//创建id=nn这个类的子节点bean
		defaultListableBeanFactory.registerBeanDefinition("changenn", bean);
		A a = (A)ac.getBean("changenn");
		A a2 = (A)ac.getBean("changenn");
		System.out.println(a);
		System.out.println(a2);
		A a3 = (A)ac.getBean("nn");//还存在，存在两个key，不是同一个bean，地址不同
		System.out.println(a3);
		
		
	}

}
