package springbean;/**
 * Created by jimmie on 2018/1/30.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jimmie
 * @create 2018-01-30 下午4:15
 */

@Configuration
@Order(1)
public class A1Order {

    public A1Order() {
        System.out.println("构造A1Order====");
    }
}
