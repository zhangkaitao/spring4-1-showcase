package com.github.zhangkaitao.spring.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureTask;
import org.springframework.util.concurrent.SuccessCallback;

import java.util.concurrent.Callable;

/*

		Callable<Object> task = new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				try {
					Object result = invocation.proceed();
					if (result instanceof Future) {
						return ((Future<?>) result).get();
					}
				}
				catch (Throwable ex) {
					handleError(ex, userDeclaredMethod, invocation.getArguments());
				}
				return null;
			}
		};

		Class<?> returnType = invocation.getMethod().getReturnType();
		if (ListenableFuture.class.isAssignableFrom(returnType)) {
			return ((AsyncListenableTaskExecutor) executor).submitListenable(task);
		}
		else if (Future.class.isAssignableFrom(returnType)) {
			return executor.submit(task);
		}
		else {
			executor.submit(task);
			return null;
		}


 */
/**
 * User: zhangkaitao
 * Date: 14-7-31
 * Time: 下午7:08
 * Version: 1.0
 */
@Service
@Async
public class AsyncService {

    public void throwException() {
        throw new RuntimeException("error");
    }

    public String asyncGet1() {
        return "123";
    }

    //返回值必须是ListenableFuture/Future，因为是实现的问题（return ((AsyncListenableTaskExecutor) executor).submitListenable(task);）
    public ListenableFuture<String> asyncGet2() {
        return new AsyncResult<String>("123");
    }

}
