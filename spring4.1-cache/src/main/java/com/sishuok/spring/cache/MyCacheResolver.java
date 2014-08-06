package com.sishuok.spring.cache;

import com.sishuok.spring.service.UserService;
import com.sishuok.spring.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

import java.util.*;

/**
 * User: zhangkaitao
 * Date: 14-8-1
 * Time: ÉÏÎç11:21
 * Version: 1.0
 */
public class MyCacheResolver implements CacheResolver {

    @Autowired
    private CacheManager cacheManager;

    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        List<Cache> caches = new ArrayList<Cache>();
        for(String cacheName : context.getOperation().getCacheNames()) {
            caches.add(cacheManager.getCache(cacheName));
        }
        if(context.getTarget() instanceof UserService2) {
            caches.add(cacheManager.getCache("user2"));
            caches.add(cacheManager.getCache("user3"));
        }
        return caches;
    }
}
