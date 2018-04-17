package ehcache.dao;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 唐国翔 on 2017/7/27.
 */
@Repository
public class TestDao {
    private Map<String,String> usersData = new HashMap<>();
    public TestDao(){
        System.out.println("初始化开始。。。");
        usersData.put("1","张三");
        usersData.put("2","李四");
        usersData.put("3","王五");
        System.out.println("初始化结束。。。");
    }


    public String get(String userNo){
        System.out.println("查询到用户号为【"+userNo+"】的用户名为："+usersData.get(userNo));
        return usersData.get(userNo);
    }

    public void update(String userNo){
        System.out.println("移除"+userNo+"缓存");
    }

    public void removeAll(){
        System.out.println("移除全部缓存");
    }
}
