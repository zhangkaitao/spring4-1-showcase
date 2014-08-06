package com.github.zhangkaitao.spring.service;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

import java.util.concurrent.Future;

/**
 * User: zhangkaitao
 * Date: 14-7-31
 * Time: 下午7:12
 * Version: 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class AsyncServiceTest {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void testAsync() throws Exception {
        asyncService.throwException();
        Thread.sleep(1000L);
    }

    @Test
    public void testAsyncGet1() throws Exception {
        //异步任务直接返回，所以是null，不会有结果，如果想要获取结果请返回AsyncResult
        Assert.assertEquals(null, asyncService.asyncGet1());
        Thread.sleep(1000L);
    }

    @Test
    public void testAsyncGet2() throws Exception {
        ListenableFuture<String> listenableFuture = asyncService.asyncGet2();
        SuccessCallback<String> successCallback = new SuccessCallback<String>() {
            @Override
            public void onSuccess(String str) {
                System.out.println("异步回调成功了, return : " + str);
            }
        };
        FailureCallback failureCallback = new FailureCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("异步回调失败了, exception message : " + throwable.getMessage());
            }
        };

        listenableFuture.addCallback(successCallback, failureCallback);
        Assert.assertEquals("123", listenableFuture.get());
    }
}
