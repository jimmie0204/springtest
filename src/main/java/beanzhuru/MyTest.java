package beanzhuru;/**
 * Created by jimmie on 2018/4/17.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jimmie
 * @create 2018-04-17 上午11:36
 */

public class MyTest {

    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("/beanzhuru/beans-parent.xml");
//        Employee employee=(Employee)ac.getBean("employeeF");
//        //employee.setName("李经理");//在xml中属性注入
//        System.out.println(employee.getCar().getCarName());
//        System.out.println(employee.getName());

        Tom tom=(Tom)ac.getBean("tom");
        tom.print();
    }
}