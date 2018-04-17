package dozer;/**
 * Created by jimmie on 2018/2/1.
 */

import factoryBean.Car;
import org.dozer.Mapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jimmie
 * @create 2018-02-01 下午3:10
 */


public class DozerTest {

    /**
     * 继承的可以直接转，大小写不一样的属性不能转
     */
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/dozer/spring-dozer.xml");
        Mapper dozerMapper = (Mapper)context.getBean("dozerMapper");
        Car car = new Car();
        car.setYear(2);
        car.setMake("sss");
        Car2 car2 = dozerMapper.map(car, Car2.class);
        System.out.println(car2.getMake()+"===="+car2.getYear());

    }
}
