package springAop4xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"springAop4xml/springAop4xml.xml");
		CommonEmployee e = (CommonEmployee) act.getBean("employee");
		e.signIn("ggg","dgfdfg");
	}
}
