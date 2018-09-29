package beanzhuru;/**
 * Created by jimmie on 2018/4/17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jimmie
 * @create 2018-04-17 下午1:28
 */

@Component
public class Tom {

    @Autowired
    @Qualifier("employeeF2")
    private Employee employee2;

    @Autowired
    @Qualifier("employeeF")
//    @Resource(name = "employeeF")
    private Employee employee;

    public void print(){
        System.out.println("Tom的名字为："+employee.getName());
        System.out.println("另一个Tom的名字为："+employee2.getName());

    }
}
