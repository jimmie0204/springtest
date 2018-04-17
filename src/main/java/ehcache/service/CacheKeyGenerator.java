package ehcache.service;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class CacheKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        Map<Integer, Object> paramsMap = new HashMap<>();
        int index = 0;
        for (Object param : params) {
            paramsMap.put(index++, param);
        }
        return paramsMap;
    }
}
