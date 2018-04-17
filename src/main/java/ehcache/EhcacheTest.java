package ehcache;/**
 * Created by jimmie on 2018/3/5.
 */

import ehcache.service.CarService;
import ehcache.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author jimmie
 * @create 2018-03-05 下午8:16
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ehcache/applicationContext.xml" })
public class EhcacheTest {

    @Resource
    private UserService userService;

    @Resource
    private CacheManager cacheManager;

    @Resource
    private CarService carService;

    @Test
    public void test1(){

        String property = System.getProperty("java.io.tmpdir");

        System.out.println("java.io.tmpdir=="+property);

        String s = userService.get("1");
        String s1 = userService.get("2");
        String s2 = userService.get("2");
        String s3 = userService.get("1");


        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test2(){
        cacheManager.getCache("useCache");
    }

    @Test
    public void test3(){
        String s = carService.get("1");
        String s1 = carService.get("1");
        String s2 = carService.get("1");

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
