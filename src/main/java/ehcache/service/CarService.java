package ehcache.service;/**
 * Created by jimmie on 2018/3/8.
 */

import ehcache.dao.TestDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jimmie
 * @create 2018-03-08 下午4:29
 */

@Service
public class CarService {

    @Resource
    private TestDao testDao;

    @Cacheable(value = "carCache")
    public String get(String userNo){
        String userName = testDao.get(userNo);
        return userName;
    }
}
