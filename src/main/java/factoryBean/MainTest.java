package factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("/factoryBean/spring.xml");

        Person person = (Person) context.getBean("person");
        Car car1 = person.getCar();

        Car car = (Car) context.getBean("car");

        System.out.println(car == car1);


        Person person2 = (Person) context.getBean("person");
        Car car2 = person2.getCar();

        Car car3 = (Car) context.getBean("car");

        System.out.println(person == person2);
        System.out.println(car1 == car2);
        System.out.println(car2 == car3);
        System.out.println(car == car3);
    }
}