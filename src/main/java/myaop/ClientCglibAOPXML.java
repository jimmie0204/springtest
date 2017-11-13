package myaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientCglibAOPXML {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"myaop/springCglibAop.xml");
		CglibProxy_ cglibProxy = (CglibProxy_) context.getBean("cglibProxy");
		Target target = (Target) cglibProxy.getProxy(Target.class);
		// 我们在使用Spring时，只需要写下面的代码就可以了：
		target.helloAop("zhang san");
		System.out.println("--------------------------");
		target.noUseAop("zhang san");
		System.out.println("--------------------------");
		target.helloAop("zhang san");

	}
}
