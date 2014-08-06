package com.sishuok.spring.cache;

import com.sishuok.spring.entity.User;
import junit.framework.Assert;
import net.sf.ehcache.jcache.JCache;
import net.sf.ehcache.jcache.JCacheManager;
import org.junit.Test;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.core.io.ClassPathResource;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import java.io.IOException;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-2
 * <p>Version: 1.0
 */

public class SpringCacheTest {

    @Test
    public void test() throws IOException {
        CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();
        MutableConfiguration<Object, Object> mutableConfiguration = new MutableConfiguration<Object, Object>();
        mutableConfiguration.setStoreByValue(false);  // otherwise value has to be Serializable
        cacheManager.createCache("user", mutableConfiguration);

        JCacheCacheManager jCacheCacheManager = new JCacheCacheManager(cacheManager);

        Long id = 1L;
        User user = new User(id, "zhang", "zhang@gmail.com");

        //根据缓存名字获取Cache
        Cache cache = jCacheCacheManager.getCache("user");

        //往缓存写数据(如果不存在 )
        cache.putIfAbsent(id, user);
        //从缓存读数据
        Assert.assertNotNull(cache.get(id, User.class));
    }

}
