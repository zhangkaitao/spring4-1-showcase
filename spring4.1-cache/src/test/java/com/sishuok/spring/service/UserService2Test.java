package com.sishuok.spring.service;

import com.sishuok.spring.AppConfig;
import com.sishuok.spring.entity.User;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-1
 * <p>Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserService2Test {

    @Autowired
    private UserService2 userService;

    @Autowired
    private CacheManager cacheManager;

    private Cache userCache;
    private Cache userCache2;
    private Cache userCache3;

    @Before
    public void setUp() {
        userCache = cacheManager.getCache("user");
        userCache2 = cacheManager.getCache("user2");
        userCache3 = cacheManager.getCache("user3");
    }


    @Test
    public void testCache() {
        Long id = 1L;
        User user = new User(id, "zhang", "zhang@gmail.com");
        userService.save(user);
        Assert.assertNotNull(userCache.get(id).get());
        Assert.assertNotNull(userCache2.get(id).get());
        Assert.assertNotNull(userCache3.get(id).get());
        userService.findById(id);
    }
}
