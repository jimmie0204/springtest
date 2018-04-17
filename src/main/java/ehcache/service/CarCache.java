package ehcache.service;/**
 * Created by jimmie on 2018/3/8.
 */

import org.springframework.cache.Cache;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author jimmie
 * @create 2018-03-08 下午4:31
 */

@Component
public class CarCache implements Cache{

    @Resource
    private CarCacheService carCacheService;

    @Override
    public String getName() {
        return "carCache";
    }

    @Override
    public Object getNativeCache() {
        return null;
    }

    @Override
    public ValueWrapper get(Object key) {
        Map<Integer, Object> paramsMap = (Map<Integer, Object>) key;
        Object realKey = paramsMap.get(0);
        String carByNo = carCacheService.getCarByNo((String) realKey);
        if(carByNo==null)
            return null;
        return new ValueWrapper() {
            @Override
            public Object get() {
                return carByNo;
            }
        };
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        Map<Integer, Object> paramsMap = (Map<Integer, Object>) key;
        String realKey = (String)paramsMap.get(0);
        System.out.println("放入cache中，key为"+realKey+"，value为"+value);
        carCacheService.putCacheCarByNo(realKey,value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        return null;
    }

    @Override
    public void evict(Object key) {

    }

    @Override
    public void clear() {

    }

}
