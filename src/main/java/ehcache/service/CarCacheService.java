package ehcache.service;/**
 * Created by jimmie on 2018/3/8.
 */

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jimmie
 * @create 2018-03-08 下午4:33
 */

@Component
public class CarCacheService {

    @Resource
    private CacheManager cacheManager;

    public String getCarByNo(String key){
        Cache myCarCache = cacheManager.getCache("myCarCache");
        Cache.ValueWrapper valueWrapper = myCarCache.get(key);

        if(valueWrapper==null) return null;
        System.out.println("从cacahe中获取，value=="+valueWrapper.get());
        return (String)valueWrapper.get();

    }

    public void putCacheCarByNo(String key,Object value){
        Cache myCarCache = cacheManager.getCache("myCarCache");
        //把ele放入缓存cache中
        myCarCache.put(key,value);
    }
}
