/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sishuok.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-7-8 ÏÂÎç9:34
 * <p>Version: 1.0
 */
@Service
public class RegisterService {

    @Autowired
    private ApplicationContext applicationContext;

    public void register(String username, String password) {
        System.out.println(username + "×¢²á³É¹¦£¡");
        publishRegisterEvent(new User(username, password));
    }

    private void publishRegisterEvent(User user) {
        applicationContext.publishEvent(new RegisterEvent(user));
    }


}
