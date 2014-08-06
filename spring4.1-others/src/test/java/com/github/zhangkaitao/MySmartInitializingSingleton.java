package com.github.zhangkaitao;

import org.springframework.beans.factory.SmartInitializingSingleton;

/**
 * User: zhangkaitao
 * Date: 14-7-31
 * Time: 下午8:11
 * Version: 1.0
 */
public class MySmartInitializingSingleton implements SmartInitializingSingleton {
    //所有非lazy单例Bean实例化完成后，会调用该方法
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("单例Bean实例化完成了");
    }
}
