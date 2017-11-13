package springAop4zhujie;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
  
  
public class Test {  
    public static void main(String[] args){  
        ApplicationContext act = new ClassPathXmlApplicationContext("springAop4zhujie/springAop4zhujie.xml");  
        CommonEmployee e = (CommonEmployee)act.getBean("employee");  //需要代理的类为代理类注入到容器
        System.out.println(e);
        HelloService e2 = (HelloService)act.getBean("helloService");  //不需要代理的类为原类注入到容器
        System.out.println(e2);
        e.signIn("liyp");  
//        try {
//			e.throwTest();
//		} catch (Exception e1) {
//			System.out.println("main catch a exception");//这句不能执行，因为已经被切面捕获处理
//		}
          System.out.println("end====");
    }  
}  