package ehcache.tool;/**
 * Created by jimmie on 2018/3/8.
 */

import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

/**
 * @author jimmie
 * @create 2018-03-08 下午5:13
 */

public class JimmieCacheManager extends EhCacheCacheManager {


    public Collection<Cache> getCaches() {
        return caches;
    }

    public void setCaches(Collection<Cache> caches) {
        this.caches = caches;
    }

    private Collection<Cache> caches;



    @Override
    protected Collection<Cache> loadCaches() {

        Collection<Cache> ehcacheCaches = super.loadCaches();
        caches.addAll(ehcacheCaches);
        return caches;
    }

}