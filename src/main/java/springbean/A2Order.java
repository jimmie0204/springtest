package springbean;/**
 * Created by jimmie on 2018/1/30.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jimmie
 * @create 2018-01-30 下午4:16
 */

@Configuration
@Order(10)
public class A2Order {

    public A2Order() {
        System.out.println("构造A2Order====");
    }
}
