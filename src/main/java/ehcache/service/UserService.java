package ehcache.service;

import ehcache.dao.TestDao;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 唐国翔 on 2017/7/27.
 */
@Service
public class UserService {
    @Resource
    private TestDao testDao;

    @Cacheable(value = "userCache",key = "'get'+#userNo")
    public String get(String userNo){
        String userName = testDao.get(userNo);
        return userName;
    }
    @CacheEvict(value = "userCache",key = "'update'+#userNo")
    public void update(){
        String userNo = "1";
        testDao.update(userNo);
    }
    @CacheEvict(value = "userCache",allEntries = true)
    public void removeAll(){
        testDao.removeAll();
    }

}
