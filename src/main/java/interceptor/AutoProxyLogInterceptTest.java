package interceptor;

import interceptor.IHello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AutoProxyLogInterceptTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"interceptor/springAopAutoProxy.xml");
		HelloSpeaker2 helloProxy = (HelloSpeaker2) context.getBean("helloSpeaker2");
		helloProxy.sayHello("world");
	}
}