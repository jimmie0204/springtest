package interceptor;

import interceptor.IHello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class LogInterceptTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"interceptor/springAop.xml");
		IHello helloProxy = (IHello) context.getBean("helloProxy");
		helloProxy.sayHello("world");
	}
}