package springbean;/**
 * Created by jimmie on 2018/1/26.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jimmie
 * @create 2018-01-26 下午5:05
 */

public class C {
    @Autowired
    private B b;

    public void hello(){
        System.out.println("c hello");

        b.print();
    }
}
